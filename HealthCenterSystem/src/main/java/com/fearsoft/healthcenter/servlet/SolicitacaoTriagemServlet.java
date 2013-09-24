/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.FilaTriagemControle;
import com.fearsoft.healthcenter.controladores.MedicoControle;
import com.fearsoft.healthcenter.controladores.PacienteControle;
import com.fearsoft.healthcenter.controladores.TriagemControle;
import com.fearsoft.healthcenter.entidades.Medico;
import com.fearsoft.healthcenter.entidades.Paciente;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eder Ferreira
 */
@WebServlet(name = "SolicitacaoTriagemServlet", urlPatterns = {"/recepcionista/SolicitacaoTriagemServlet"})
public class SolicitacaoTriagemServlet extends HttpServlet {

    private TriagemControle triagemControle;
    private FilaTriagemControle filaTriagemControle;
    private MedicoControle medicoControle;
    private PacienteControle pacienteControle;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipoOperacao = request.getParameter("tipoOperacao");
        System.out.println("\n\n"+tipoOperacao);
        if (tipoOperacao.equals("solicitarTriagem")) {
            solicitarTriagem(request);
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

    private void solicitarTriagem(HttpServletRequest request) throws NumberFormatException {
        Date dataTriagem = new Date();
        this.pacienteControle = new PacienteControle();
        this.medicoControle = new MedicoControle();
        Long idMedico = Long.parseLong(request.getParameter("medicoId").toString());
        Long idPaciente = Long.parseLong(request.getParameter("pacienteId").toString());
        filaTriagemControle = new FilaTriagemControle();
        filaTriagemControle.getFilaTriagem().setDataTriagem(dataTriagem);
        filaTriagemControle.getFilaTriagem().setMedico((Medico) this.medicoControle.find(idMedico));
        filaTriagemControle.getFilaTriagem().setPaciente((Paciente) this.pacienteControle.find(idPaciente));
        this.filaTriagemControle.saveOrUpdate(this.filaTriagemControle.getFilaTriagem());
    }

  }
