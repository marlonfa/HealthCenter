/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.MedicoControle;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Medico;
import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.Sexo;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eder Ferreira
 */
@WebServlet(name = "HealthCenterServlet", urlPatterns = {"/administrador/HealthCenterServlet"})
public class HealthCenterServlet extends HttpServlet {
    private MedicoControle medicoControle;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        medicoControle = new MedicoControle();
        cadastrarMedico(request, response, null);
        
        
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
    
    private void cadastrarMedico(HttpServletRequest request, HttpServletResponse response, Medico medico) throws ServletException, IOException{
        if(null == medico){
            medico = new Medico();
            medico.setEndereco(new Endereco());
            medico.setContato(new Contato());
        }        
        medico.setNome(request.getParameter("nome"));
        medico.setNaturalidade(request.getParameter("naturalidade"));
        medico.setEspecialidade(request.getParameter("especialidade"));
        medico.setDataNascimento(new Date());
        medico.setSexo(Sexo.MASCULINO);
        medico.setEstadoCivil(EstadoCivil.DIVORCIADO);
        medico.setCpf(request.getParameter("cpf"));
        medico.setRg(request.getParameter("rg"));
        medico.setCrm(request.getParameter("crm"));
        
        medico.getEndereco().setNomeEndereço(request.getParameter("nomeEndereco"));
        medico.getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        medico.getEndereco().setComplemento(request.getParameter("complemento"));
        medico.getEndereco().setBairro(request.getParameter("bairro"));
        medico.getEndereco().setCidade(request.getParameter("cidade"));
        medico.getEndereco().setCep(request.getParameter("cep"));
        
        medico.getContato().setTelefone(request.getParameter("telefone"));
        medico.getContato().setCelular(request.getParameter("celular"));
        medico.getContato().setEmail(request.getParameter("email"));
        medico.setSenha(request.getParameter("senha"));
        
        medicoControle.createOrSave(medico);
        request.setAttribute("medico", medico);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/administrador/viewMedico.jsp");
        dispatcher.forward(request, response);
    }
}
