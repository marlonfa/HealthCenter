/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.acoes.FilaTriagem;
import com.fearsoft.healthcenter.controladores.FilaConsultaControle;
import com.fearsoft.healthcenter.controladores.FilaTriagemControle;
import com.fearsoft.healthcenter.controladores.TriagemControle;
import com.fearsoft.healthcenter.entidades.Triagem;
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
@WebServlet(name = "TriagemServlet", urlPatterns = {"/enfermeiro/TriagemServlet"})
public class TriagemServlet extends HttpServlet {

    private TriagemControle triagemControle;
    private FilaTriagemControle filaTriagemControle;
    private FilaConsultaControle filaConsultaControle;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.filaTriagemControle = new FilaTriagemControle();
        this.triagemControle = new TriagemControle();


        String tipoOperacao = request.getParameter("tipoOperacao");

        if (tipoOperacao.equals("filaTriagem")) {
            filaTriagem(request);
        } else if (tipoOperacao.equals("realizarTriagem")) {
            realizarTriagem(request);
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

    private void filaTriagem(HttpServletRequest request) {
        Long idFilaTriagem = Long.parseLong(request.getParameter("triagem"));

        this.filaTriagemControle.setFilaTriagem((FilaTriagem) this.filaTriagemControle.find(idFilaTriagem));

        this.triagemControle.getTriagem().setDataConsulta(this.filaTriagemControle.getFilaTriagem().getDataTriagem());
        this.triagemControle.getTriagem().setMedico(this.filaTriagemControle.getFilaTriagem().getMedico());
        this.triagemControle.getTriagem().setPaciente(this.filaTriagemControle.getFilaTriagem().getPaciente());
        this.triagemControle.getTriagem().setDataConsulta(this.filaTriagemControle.getFilaTriagem().getDataTriagem());

        HttpSession session = request.getSession();

        session.setAttribute("triagem", this.triagemControle.getTriagem());
        session.setAttribute("filaTriagemRemovido", this.filaTriagemControle.getFilaTriagem());
    }

    //PEGAR TRIAGEM DA SESSAO
    //SETAR OS DADOS NA TRIAGEM
    //CRIAR UMA FILA DE CONSULTA PARA UM MEDICO
    //SETAR O ID DO MEDICO NA FILA DE CONSULTA
    //REMOVER ID DA FILA DE TRIAGEM
    private void realizarTriagem(HttpServletRequest request) {
        this.triagemControle.setTriagem((Triagem) request.getSession().getAttribute("triagem"));

        Float altura = Float.parseFloat(request.getParameter("altura").replace(",", "."));
        Float peso = Float.parseFloat(request.getParameter("peso").replace(",", "."));
        Float temperatura = Float.parseFloat(request.getParameter("temperatura").replace(",", "."));

        this.triagemControle.getTriagem().setAltura(altura);
        this.triagemControle.getTriagem().setPeso(peso);
        this.triagemControle.getTriagem().setPressaoArterial(request.getParameter("pressaoArterial"));
        this.triagemControle.getTriagem().setTemperatura(temperatura);

        this.triagemControle.saveOrUpdate(this.triagemControle.getTriagem());

        this.filaConsultaControle = new FilaConsultaControle();

        this.filaConsultaControle.getFilaConsulta().setTriagem(this.triagemControle.getTriagem());
        this.filaConsultaControle.getFilaConsulta().setUsernameMedico(this.triagemControle.getTriagem().getMedico().getUsuario().getUsername());
        
        this.filaConsultaControle.saveOrUpdate(this.filaConsultaControle.getFilaConsulta());

        this.filaTriagemControle.delete((FilaTriagem) request.getSession().getAttribute("filaTriagemRemovido"));

    }
}
