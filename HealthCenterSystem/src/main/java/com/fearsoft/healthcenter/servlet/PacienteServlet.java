/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.ConsultaControle;
import com.fearsoft.healthcenter.controladores.PacienteControle;
import com.fearsoft.healthcenter.entidades.Consulta;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Paciente;
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
@WebServlet(name = "PacienteServlet", urlPatterns = {"/recepcionista/PacienteServlet"})
public class PacienteServlet extends HttpServlet {
    private PacienteControle pacienteControle;
    private Paciente paciente;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        pacienteControle = new PacienteControle();
        
        String tipoOperacao = request.getParameter("tipoOperacao");
        System.out.println("TIPO DE OPERAÇÃO "+tipoOperacao);
        
        if(tipoOperacao.equals("cadPaciente") ){
            cadastrarPaciente(request, response);
        }else if(tipoOperacao.equals("removePaciente")){
            removerPaciente(request, response);
        }else if(tipoOperacao.equals("editPaciente")){
            editPaciente(request, response);
        }else if(tipoOperacao.equals("editPaciente2")){
            editPaciente2(request, response);
        }else if(tipoOperacao.equals("viewPaciente")){
            viewPaciente(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void cadastrarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
            //Cria um novo médico, endereço e usuario
            pacienteControle.getPaciente().setEndereco(new Endereco());
            pacienteControle.getPaciente().setContato(new Contato());
            pacienteControle.getPaciente().setUsuario(new Usuario());
            
            //Seta os valores dos campos da página jsp nos objetos
            setarPaciente(request, response);
    }
    
    private void removerPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("REMOVER");
        pacienteControle.delete(getPaciente(request, response));
    }
    
    private void viewPaciente(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("paciente", getPaciente(request, response));
        paciente = (Paciente) session.getAttribute("paciente");
        System.out.println(session.getAttribute("paciente"));
    }
    
    private void editPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("paciente", getPaciente(request, response));
        paciente = (Paciente) session.getAttribute("paciente");
    }
    
    private void editPaciente2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
        pacienteControle.setPaciente(paciente);
        setarPaciente(request, response);
    }
    
    //Retorna o médico passando o ID como busca
    private Paciente getPaciente(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
//        for (Iterator it = pacienteControle.findAll().iterator(); it.hasNext();) {
//            Paciente m = (Paciente) it.next();
//            if(m.getId()==id){
//                return m;
//            }
//        }
        return (Paciente) this.pacienteControle.find(id);
    }
    
    private void setarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        pacienteControle.getPaciente().setNome(request.getParameter("nome"));
        pacienteControle.getPaciente().setNaturalidade(request.getParameter("naturalidade"));
        
        Date data = null;
        data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
        pacienteControle.getPaciente().setDataNascimento(data);
        
        String sexo = request.getParameter("sexo");
        if("Masculino".equals(sexo)){
            pacienteControle.getPaciente().setSexo(Sexo.MASCULINO);
        }else{
            pacienteControle.getPaciente().setSexo(Sexo.FEMININO);
        }
        
        pacienteControle.getPaciente().setEstadoCivil(Enum.valueOf(EstadoCivil.class, request.getParameter("estadoCivil")));
        pacienteControle.getPaciente().setCpf(formatString(request.getParameter("cpf")));
        pacienteControle.getPaciente().setRg(formatString(request.getParameter("rg")));
        pacienteControle.getPaciente().setSus(formatString(request.getParameter("sus")));
        
        pacienteControle.getPaciente().getEndereco().setNomeEndereco(request.getParameter("nomeEndereco"));
        pacienteControle.getPaciente().getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        pacienteControle.getPaciente().getEndereco().setComplemento(request.getParameter("complemento"));
        pacienteControle.getPaciente().getEndereco().setBairro(request.getParameter("bairro"));
        pacienteControle.getPaciente().getEndereco().setCidade(request.getParameter("cidade"));
        pacienteControle.getPaciente().getEndereco().setCep(formatString(request.getParameter("cep")));
        
        pacienteControle.getPaciente().getContato().setTelefone(formatString(request.getParameter("telefone")));
        pacienteControle.getPaciente().getContato().setCelular(formatString(request.getParameter("celular")));
        pacienteControle.getPaciente().getContato().setEmail(request.getParameter("email"));
        
        pacienteControle.getPaciente().getUsuario().setName(request.getParameter("nome"));
        pacienteControle.getPaciente().getUsuario().setUsername(formatString(request.getParameter("cpf")));
        pacienteControle.getPaciente().getUsuario().setPassword(request.getParameter("senha"));
        pacienteControle.getPaciente().getUsuario().setAuthority(Authority.ROLE_PAC);

        
        pacienteControle.saveOrUpdate(pacienteControle.getPaciente());
        
        HttpSession session = request.getSession();
        session.setAttribute("paciente", pacienteControle.getPaciente());
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
