/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.EnfermeiroControle;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Enfermeiro;
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
@WebServlet(name = "EnfermeiroServlet", urlPatterns = {"/administrador/EnfermeiroServlet"})
public class EnfermeiroServlet extends HttpServlet {
private EnfermeiroControle enfermeiroControle;
    private Enfermeiro enfermeiro;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        enfermeiroControle = new EnfermeiroControle();
        
        String tipoOperacao = request.getParameter("tipoOperacao");
        System.out.println("TIPO DE OPERAÇÃO "+tipoOperacao);
        
        if(tipoOperacao.equals("cadEnfermeiro") ){
            System.out.println("cadastrar");
            cadastrarEnfermeiro(request, response);
        }else if(tipoOperacao.equals("removeEnfermeiro")){
            removerEnfermeiro(request, response);
        }else if(tipoOperacao.equals("editEnfermeiro")){
            editEnfermeiro(request, response);
        }else if(tipoOperacao.equals("editEnfermeiro2")){
            editEnfermeiro2(request, response);
        }else if(tipoOperacao.equals("viewEnfermeiro")){
            viewEnfermeiro(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EnfermeiroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EnfermeiroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void cadastrarEnfermeiro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
            //Cria um novo médico, endereço e usuario
            enfermeiroControle.getEnfermeiro().setEndereco(new Endereco());
            enfermeiroControle.getEnfermeiro().setContato(new Contato());
            enfermeiroControle.getEnfermeiro().setUsuario(new Usuario());
            
            //Seta os valores dos campos da página jsp nos objetos
            setarEnfermeiro(request, response);
    }
    
    private void removerEnfermeiro(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("REMOVER");
        enfermeiroControle.delete(getEnfermeiro(request, response));
    }
    
    private void viewEnfermeiro(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("enfermeiro", getEnfermeiro(request, response));
        enfermeiro = (Enfermeiro) session.getAttribute("enfermeiro");
        System.out.println(session.getAttribute("enfermeiro"));
    }
    
    private void editEnfermeiro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("enfermeiro", getEnfermeiro(request, response));
        enfermeiro = (Enfermeiro) session.getAttribute("enfermeiro");
    }
    
    private void editEnfermeiro2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
        enfermeiroControle.setEnfermeiro(enfermeiro);
        setarEnfermeiro(request, response);
    }
    
    //Retorna o médico passando o ID como busca
    private Enfermeiro getEnfermeiro(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        for (Iterator it = enfermeiroControle.findAll().iterator(); it.hasNext();) {
            Enfermeiro m = (Enfermeiro) it.next();
            if(m.getId()==id){
                return m;
            }
        }
        return null;
    }
    
    private void setarEnfermeiro(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        enfermeiroControle.getEnfermeiro().setNome(request.getParameter("nome"));
        enfermeiroControle.getEnfermeiro().setNaturalidade(request.getParameter("naturalidade"));
        
        Date data = null;
        data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
        enfermeiroControle.getEnfermeiro().setDataNascimento(data);
        
        String sexo = request.getParameter("sexo");
        if("Masculino".equals(sexo)){
            enfermeiroControle.getEnfermeiro().setSexo(Sexo.MASCULINO);
        }else{
            enfermeiroControle.getEnfermeiro().setSexo(Sexo.FEMININO);
        }
        
        enfermeiroControle.getEnfermeiro().setEstadoCivil(Enum.valueOf(EstadoCivil.class, request.getParameter("estadoCivil")));
        enfermeiroControle.getEnfermeiro().setCpf(formatString(request.getParameter("cpf")));
        enfermeiroControle.getEnfermeiro().setRg(formatString(request.getParameter("rg")));
        enfermeiroControle.getEnfermeiro().setCoren(request.getParameter("coren"));
        
        enfermeiroControle.getEnfermeiro().getEndereco().setNomeEndereco(request.getParameter("nomeEndereco"));
        enfermeiroControle.getEnfermeiro().getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        enfermeiroControle.getEnfermeiro().getEndereco().setComplemento(request.getParameter("complemento"));
        enfermeiroControle.getEnfermeiro().getEndereco().setBairro(request.getParameter("bairro"));
        enfermeiroControle.getEnfermeiro().getEndereco().setCidade(request.getParameter("cidade"));
        enfermeiroControle.getEnfermeiro().getEndereco().setCep(formatString(request.getParameter("cep")));
        
        enfermeiroControle.getEnfermeiro().getContato().setTelefone(formatString(request.getParameter("telefone")));
        enfermeiroControle.getEnfermeiro().getContato().setCelular(formatString(request.getParameter("celular")));
        enfermeiroControle.getEnfermeiro().getContato().setEmail(request.getParameter("email"));
        
        enfermeiroControle.getEnfermeiro().getUsuario().setName(request.getParameter("nome"));
        enfermeiroControle.getEnfermeiro().getUsuario().setUsername(formatString(request.getParameter("cpf")));
        enfermeiroControle.getEnfermeiro().getUsuario().setPassword(request.getParameter("senha"));
        enfermeiroControle.getEnfermeiro().getUsuario().setAuthority(Authority.ROLE_MED);

        
        enfermeiroControle.saveOrUpdate(enfermeiroControle.getEnfermeiro());
        
        HttpSession session = request.getSession();
        session.setAttribute("enfermeiro", enfermeiroControle.getEnfermeiro());
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
