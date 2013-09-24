/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.HistoricoClinicoControle;
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
@WebServlet(name = "HistoricoClinicoServlet", urlPatterns = {"/medico/HistoricoClinicoServlet"})
public class HistoricoClinicoServlet extends HttpServlet {

    private HistoricoClinicoControle historicoClinicoControle;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.historicoClinicoControle = new HistoricoClinicoControle();
        
        Long id = Long.parseLong(request.getParameter("historicoId"));
        
        HttpSession session = request.getSession();
        session.setAttribute("historicoClinico", this.historicoClinicoControle.find(id));
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
}
