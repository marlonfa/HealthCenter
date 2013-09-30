/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.acoes.FilaConsulta;
import com.fearsoft.healthcenter.controladores.ConsultaControle;
import com.fearsoft.healthcenter.controladores.FilaConsultaControle;
import com.fearsoft.healthcenter.controladores.HistoricoClinicoControle;
import com.fearsoft.healthcenter.entidades.Consulta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eder Ferreira
 */
@WebServlet(name = "ConsultaServlet", urlPatterns = {"/medico/ConsultaServlet"})
public class ConsultaServlet extends HttpServlet {

    private FilaConsultaControle filaConsultaControle;
    private ConsultaControle consultaControle;
    private HistoricoClinicoControle historicoClinicoControle;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.filaConsultaControle = new FilaConsultaControle();
        this.consultaControle = new ConsultaControle();
        
        String tipoOperacao = request.getParameter("tipoOperacao");

        if (tipoOperacao.equals("filaConsulta")) {
            filaConsulta(request);
        } else if (tipoOperacao.equals("realizarConsulta")) {
            realizarConsulta(request);
        }else if(tipoOperacao.equals("removerConsulta")){
            revomerConsulta(request);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void filaConsulta(HttpServletRequest request) {
        Long idFilaConsulta = Long.parseLong(request.getParameter("consulta"));

        this.filaConsultaControle.setFilaConsulta((FilaConsulta) this.filaConsultaControle.find(idFilaConsulta));
        
        this.consultaControle.getConsulta().setTriagem(this.filaConsultaControle.getFilaConsulta().getTriagem());
        this.filaConsultaControle.getFilaConsulta().setUsernameMedico(this.filaConsultaControle.getFilaConsulta().getTriagem().getMedico().getUsuario().getUsername());
        
        HttpSession session = request.getSession();

        session.setAttribute("consulta", this.consultaControle.getConsulta());
        session.setAttribute("filaConsultaRemovido", this.filaConsultaControle.getFilaConsulta());
    
    }

    private void realizarConsulta(HttpServletRequest request) {
        this.consultaControle.setConsulta((Consulta) request.getSession().getAttribute("consulta"));

        this.consultaControle.getConsulta().setSintomas(request.getParameter("sintomas"));
        this.consultaControle.getConsulta().setDiagnostico(request.getParameter("diagnostico"));
        this.consultaControle.getConsulta().setPrescricao(request.getParameter("prescricao"));

        this.consultaControle.saveOrUpdate(this.consultaControle.getConsulta());
        
        this.historicoClinicoControle = new HistoricoClinicoControle();
        
        this.historicoClinicoControle.getHistoricoClinico().setConsulta(this.consultaControle.getConsulta());
        this.historicoClinicoControle.getHistoricoClinico().setIdPaciente(this.consultaControle.getConsulta().getTriagem().getPaciente().getId());
        
        this.historicoClinicoControle.saveOrUpdate(this.historicoClinicoControle.getHistoricoClinico());

        this.filaConsultaControle.delete((FilaConsulta) request.getSession().getAttribute("filaConsultaRemovido"));
    }

    private void revomerConsulta(HttpServletRequest request) {
        Long idFilaConsulta = Long.parseLong(request.getParameter("consulta"));

        this.filaConsultaControle.delete((FilaConsulta) this.filaConsultaControle.find(idFilaConsulta));
        
    }
}
