/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.AdministradorControle;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Administrador;
import com.fearsoft.healthcenter.entidades.Usuario;
import com.fearsoft.healthcenter.enums.Authority;
import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.Sexo;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marlon
 */
@WebServlet(name = "AdministradorServlet", urlPatterns = {"/administrador/AdministradorServlet"})
public class AdministradorServlet extends HttpServlet {
    private AdministradorControle administradorControle;
    private Administrador administrador;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        administradorControle = new AdministradorControle();
        
        String tipoOperacao = request.getParameter("tipoOperacao");
        System.out.println("TIPO DE OPERAÇÃO "+tipoOperacao);
        
        if(tipoOperacao.equals("cadAdministrador") ){
            cadastrarAdministrador(request, response);
        }else if(tipoOperacao.equals("removeAdministrador")){
            removerAdministrador(request, response);
        }else if(tipoOperacao.equals("editAdministrador")){
            editAdministrador(request, response);
        }else if(tipoOperacao.equals("editAdministrador2")){
            editAdministrador2(request, response);
        }else if(tipoOperacao.equals("viewAdministrador")){
            viewAdministrador(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void cadastrarAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
            //Cria um novo médico, endereço e usuario
            administradorControle.getAdministrador().setEndereco(new Endereco());
            administradorControle.getAdministrador().setContato(new Contato());
            administradorControle.getAdministrador().setUsuario(new Usuario());
            
            //Seta os valores dos campos da página jsp nos objetos
            setarAdministrador(request, response);
    }
    
    private void removerAdministrador(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("REMOVER");
        administradorControle.delete(getAdministrador(request, response));
    }
    
    private void viewAdministrador(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("administrador", getAdministrador(request, response));
        administrador = (Administrador) session.getAttribute("administrador");
        System.out.println(session.getAttribute("administrador"));
    }
    
    private void editAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("administrador", getAdministrador(request, response));
        administrador = (Administrador) session.getAttribute("administrador");
    }
    
    private void editAdministrador2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
        administradorControle.setAdministrador(administrador);
        setarAdministrador(request, response);
    }
    
    //Retorna o médico passando o ID como busca
    private Administrador getAdministrador(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        for (Iterator it = administradorControle.findAll().iterator(); it.hasNext();) {
            Administrador m = (Administrador) it.next();
            if(m.getId()==id){
                return m;
            }
        }
        return null;
    }
    
    private void setarAdministrador(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        administradorControle.getAdministrador().setNome(request.getParameter("nome"));
        administradorControle.getAdministrador().setNaturalidade(request.getParameter("naturalidade"));
        
        Date data = null;
        data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
        administradorControle.getAdministrador().setDataNascimento(data);
        
        String sexo = request.getParameter("sexo");
        if("Masculino".equals(sexo)){
            administradorControle.getAdministrador().setSexo(Sexo.MASCULINO);
        }else{
            administradorControle.getAdministrador().setSexo(Sexo.FEMININO);
        }
        
        administradorControle.getAdministrador().setEstadoCivil(Enum.valueOf(EstadoCivil.class, request.getParameter("estadoCivil")));
        administradorControle.getAdministrador().setCpf(formatString(request.getParameter("cpf")));
        administradorControle.getAdministrador().setRg(formatString(request.getParameter("rg")));
        
        administradorControle.getAdministrador().getEndereco().setNomeEndereco(request.getParameter("nomeEndereco"));
        administradorControle.getAdministrador().getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        administradorControle.getAdministrador().getEndereco().setComplemento(request.getParameter("complemento"));
        administradorControle.getAdministrador().getEndereco().setBairro(request.getParameter("bairro"));
        administradorControle.getAdministrador().getEndereco().setCidade(request.getParameter("cidade"));
        administradorControle.getAdministrador().getEndereco().setCep(formatString(request.getParameter("cep")));
        
        administradorControle.getAdministrador().getContato().setTelefone(formatString(request.getParameter("telefone")));
        administradorControle.getAdministrador().getContato().setCelular(formatString(request.getParameter("celular")));
        administradorControle.getAdministrador().getContato().setEmail(request.getParameter("email"));
        
        administradorControle.getAdministrador().getUsuario().setName(request.getParameter("nome"));
        administradorControle.getAdministrador().getUsuario().setUsername(formatString(request.getParameter("cpf")));
        administradorControle.getAdministrador().getUsuario().setPassword(request.getParameter("senha"));
        administradorControle.getAdministrador().getUsuario().setAuthority(Authority.ROLE_MED);

        
        administradorControle.saveOrUpdate(administradorControle.getAdministrador());
        
        HttpSession session = request.getSession();
        session.setAttribute("administrador", administradorControle.getAdministrador());
    }
    
    private String formatString(String string){
        if(string.contains(" ")){
            string = string.replaceAll(" ", "");
            formatString(string);
        }if(string.contains(".")){
            string = string.replaceAll("\\.", "");
            formatString(string);
        }if(string.contains("_")){
            string = string.replaceAll("\\_", "");
            formatString(string);
        }if (string.contains("/")){
            string = string.replaceAll("\\/", "");
            formatString(string);
        }if (string.contains("-")){
            string = string.replaceAll("-", "");
            formatString(string);
        }if (string.contains("(")){
            string = string.replaceAll("\\(", "");
            formatString(string);
        }if (string.contains(")")){
            string = string.replaceAll("\\)", "");
            formatString(string);
        }return string;
    }
}
