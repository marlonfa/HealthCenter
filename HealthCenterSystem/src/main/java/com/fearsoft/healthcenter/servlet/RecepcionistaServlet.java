/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.RecepcionistaControle;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Recepcionista;
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
@WebServlet(name = "RecepcionistaServlet", urlPatterns = {"/administrador/RecepcionistaServlet"})
public class RecepcionistaServlet extends HttpServlet {
private RecepcionistaControle recepcionistaControle;
    private Recepcionista recepcionista;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        recepcionistaControle = new RecepcionistaControle();
        
        String tipoOperacao = request.getParameter("tipoOperacao");
        System.out.println("TIPO DE OPERAÇÃO "+tipoOperacao);
        
        if(tipoOperacao.equals("cadRecepcionista") ){
            cadastrarRecepcionista(request, response);
        }else if(tipoOperacao.equals("removeRecepcionista")){
            removerRecepcionista(request, response);
        }else if(tipoOperacao.equals("editRecepcionista")){
            editRecepcionista(request, response);
        }else if(tipoOperacao.equals("editRecepcionista2")){
            editRecepcionista2(request, response);
        }else if(tipoOperacao.equals("viewRecepcionista")){
            viewRecepcionista(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RecepcionistaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RecepcionistaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void cadastrarRecepcionista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
            //Cria um novo médico, endereço e usuario
            recepcionistaControle.getRecepcionista().setEndereco(new Endereco());
            recepcionistaControle.getRecepcionista().setContato(new Contato());
            recepcionistaControle.getRecepcionista().setUsuario(new Usuario());
            
            //Seta os valores dos campos da página jsp nos objetos
            setarRecepcionista(request, response);
    }
    
    private void removerRecepcionista(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("REMOVER");
        recepcionistaControle.delete(getRecepcionista(request, response));
    }
    
    private void viewRecepcionista(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("recepcionista", getRecepcionista(request, response));
        recepcionista = (Recepcionista) session.getAttribute("recepcionista");
        System.out.println(session.getAttribute("recepcionista"));
    }
    
    private void editRecepcionista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("recepcionista", getRecepcionista(request, response));
        recepcionista = (Recepcionista) session.getAttribute("recepcionista");
    }
    
    private void editRecepcionista2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
        recepcionistaControle.setRecepcionista(recepcionista);
        setarRecepcionista(request, response);
    }
    
    //Retorna o médico passando o ID como busca
    private Recepcionista getRecepcionista(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        for (Iterator it = recepcionistaControle.findAll().iterator(); it.hasNext();) {
            Recepcionista m = (Recepcionista) it.next();
            if(m.getId()==id){
                return m;
            }
        }
        return null;
    }
    
    private void setarRecepcionista(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        recepcionistaControle.getRecepcionista().setNome(request.getParameter("nome"));
        recepcionistaControle.getRecepcionista().setNaturalidade(request.getParameter("naturalidade"));
        
        Date data = null;
        data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
        recepcionistaControle.getRecepcionista().setDataNascimento(data);
        
        String sexo = request.getParameter("sexo");
        if("Masculino".equals(sexo)){
            recepcionistaControle.getRecepcionista().setSexo(Sexo.MASCULINO);
        }else{
            recepcionistaControle.getRecepcionista().setSexo(Sexo.FEMININO);
        }
        
        recepcionistaControle.getRecepcionista().setEstadoCivil(Enum.valueOf(EstadoCivil.class, request.getParameter("estadoCivil")));
        recepcionistaControle.getRecepcionista().setCpf(formatString(request.getParameter("cpf")));
        recepcionistaControle.getRecepcionista().setRg(formatString(request.getParameter("rg")));
        
        recepcionistaControle.getRecepcionista().getEndereco().setNomeEndereco(request.getParameter("nomeEndereco"));
        recepcionistaControle.getRecepcionista().getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        recepcionistaControle.getRecepcionista().getEndereco().setComplemento(request.getParameter("complemento"));
        recepcionistaControle.getRecepcionista().getEndereco().setBairro(request.getParameter("bairro"));
        recepcionistaControle.getRecepcionista().getEndereco().setCidade(request.getParameter("cidade"));
        recepcionistaControle.getRecepcionista().getEndereco().setCep(formatString(request.getParameter("cep")));
        
        recepcionistaControle.getRecepcionista().getContato().setTelefone(formatString(request.getParameter("telefone")));
        recepcionistaControle.getRecepcionista().getContato().setCelular(formatString(request.getParameter("celular")));
        recepcionistaControle.getRecepcionista().getContato().setEmail(request.getParameter("email"));
        
        recepcionistaControle.getRecepcionista().getUsuario().setName(request.getParameter("nome"));
        recepcionistaControle.getRecepcionista().getUsuario().setUsername(formatString(request.getParameter("cpf")));
        recepcionistaControle.getRecepcionista().getUsuario().setPassword(request.getParameter("senha"));
        recepcionistaControle.getRecepcionista().getUsuario().setAuthority(Authority.ROLE_MED);

        
        recepcionistaControle.saveOrUpdate(recepcionistaControle.getRecepcionista());
        
        HttpSession session = request.getSession();
        session.setAttribute("recepcionista", recepcionistaControle.getRecepcionista());
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
