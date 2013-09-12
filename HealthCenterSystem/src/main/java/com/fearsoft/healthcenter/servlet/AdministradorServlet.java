/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.AdministradorControle;
import com.fearsoft.healthcenter.entidades.Administrador;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Usuario;
import com.fearsoft.healthcenter.enums.Authority;
import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.Sexo;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marlon
 */
public class AdministradorServlet extends HttpServlet {
    private AdministradorControle administradorControle;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveOrUpdateAdministrador(request, response, null);
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
    
    private void saveOrUpdateAdministrador(HttpServletRequest request, HttpServletResponse response, Administrador administrador) throws ServletException, IOException{
        administradorControle = new AdministradorControle();
        if(null == administrador){
            administradorControle.setAdministrador(new Administrador());
            administradorControle.getAdministrador().setEndereco(new Endereco());
            administradorControle.getAdministrador().setContato(new Contato());
            administradorControle.getAdministrador().setUsuario(new Usuario());
        }    
        
        administradorControle.getAdministrador().setNome(request.getParameter("nome"));
        administradorControle.getAdministrador().setNaturalidade(request.getParameter("naturalidade"));
        administradorControle.getAdministrador().setDataNascimento(new Date());
        administradorControle.getAdministrador().setSexo(Sexo.MASCULINO);
        administradorControle.getAdministrador().setEstadoCivil(EstadoCivil.DIVORCIADO);
        administradorControle.getAdministrador().setCpf(request.getParameter("cpf"));
        administradorControle.getAdministrador().setRg(request.getParameter("rg"));
        
        administradorControle.getAdministrador().getEndereco().setNomeEndereco(request.getParameter("nomeEndereco"));
        administradorControle.getAdministrador().getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        administradorControle.getAdministrador().getEndereco().setComplemento(request.getParameter("complemento"));
        administradorControle.getAdministrador().getEndereco().setBairro(request.getParameter("bairro"));
        administradorControle.getAdministrador().getEndereco().setCidade(request.getParameter("cidade"));
        administradorControle.getAdministrador().getEndereco().setCep(request.getParameter("cep"));
        
        administradorControle.getAdministrador().getContato().setTelefone(request.getParameter("telefone"));
        administradorControle.getAdministrador().getContato().setCelular(request.getParameter("celular"));
        administradorControle.getAdministrador().getContato().setEmail(request.getParameter("email"));
        
        administradorControle.getAdministrador().getUsuario().setName(request.getParameter("nome"));
        administradorControle.getAdministrador().getUsuario().setUsername(request.getParameter("cpf"));
        administradorControle.getAdministrador().getUsuario().setPassword(request.getParameter("senha"));
        administradorControle.getAdministrador().getUsuario().setAuthority(Authority.ROLE_ADMIN);

        administradorControle.createOrSave(administradorControle.getAdministrador());
        
        request.setAttribute("medico", administradorControle.getAdministrador());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/administrador/viewMedico.jsp");
        dispatcher.forward(request, response);
    }
}
