/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import com.fearsoft.healthcenter.controladores.MedicoControle;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Medico;
import com.fearsoft.healthcenter.entidades.Usuario;
import com.fearsoft.healthcenter.enums.Authority;
import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.MedicoEspecialidade;
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
 * @author Eder Ferreira
 */
@WebServlet(name = "MedicoServlet", urlPatterns = {"/administrador/MedicoServlet"})
public class MedicoServlet extends HttpServlet {
    private MedicoControle medicoControle;
    private Medico medico;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        medicoControle = new MedicoControle();
        
        String tipoOperacao = request.getParameter("tipoOperacao");
        System.out.println("TIPO DE OPERAÇÃO "+tipoOperacao);
        
        if(tipoOperacao.equals("cadMedico") ){
            cadastrarMedico(request, response);
        }else if(tipoOperacao.equals("removeMedico")){
            removerMedico(request, response);
        }else if(tipoOperacao.equals("editMedico")){
            editMedico(request, response);
        }else if(tipoOperacao.equals("editMedico2")){
            editMedico2(request, response);
        }else if(tipoOperacao.equals("viewMedico")){
            viewMedico(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void cadastrarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
            //Cria um novo médico, endereço e usuario
            medicoControle.getMedico().setEndereco(new Endereco());
            medicoControle.getMedico().setContato(new Contato());
            medicoControle.getMedico().setUsuario(new Usuario());
            
            //Seta os valores dos campos da página jsp nos objetos
            setarMedico(request, response);
    }
    
    private void removerMedico(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("REMOVER");
        medicoControle.delete(getMedico(request, response));
    }
    
    private void viewMedico(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("medico", getMedico(request, response));
        medico = (Medico) session.getAttribute("medico");
        System.out.println(session.getAttribute("medico"));
    }
    
    private void editMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("medico", getMedico(request, response));
        medico = (Medico) session.getAttribute("medico");
    }
    
    private void editMedico2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
        medicoControle.setMedico(medico);
        setarMedico(request, response);
    }
    
    //Retorna o médico passando o ID como busca
    private Medico getMedico(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
//        for (Iterator it = medicoControle.findAll().iterator(); it.hasNext();) {
//            Medico m = (Medico) it.next();
//            if(m.getId()==id){
//                return m;
//            }
//        }
//        return null;
        return (Medico) this.medicoControle.find(id);
    }
    
    private void setarMedico(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        medicoControle.getMedico().setNome(request.getParameter("nome"));
        medicoControle.getMedico().setNaturalidade(request.getParameter("naturalidade"));
        medicoControle.getMedico().setEspecialidade(Enum.valueOf(MedicoEspecialidade.class, request.getParameter("especialidade")));
        
        Date data = null;
        data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
        medicoControle.getMedico().setDataNascimento(data);
        
        String sexo = request.getParameter("sexo");
        if("Masculino".equals(sexo)){
            medicoControle.getMedico().setSexo(Sexo.MASCULINO);
        }else{
            medicoControle.getMedico().setSexo(Sexo.FEMININO);
        }
        
        medicoControle.getMedico().setEstadoCivil(Enum.valueOf(EstadoCivil.class, request.getParameter("estadoCivil")));
        medicoControle.getMedico().setCpf(formatString(request.getParameter("cpf")));
        medicoControle.getMedico().setRg(formatString(request.getParameter("rg")));
        medicoControle.getMedico().setCrm(request.getParameter("crm"));
        
        medicoControle.getMedico().getEndereco().setNomeEndereco(request.getParameter("nomeEndereco"));
        medicoControle.getMedico().getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        medicoControle.getMedico().getEndereco().setComplemento(request.getParameter("complemento"));
        medicoControle.getMedico().getEndereco().setBairro(request.getParameter("bairro"));
        medicoControle.getMedico().getEndereco().setCidade(request.getParameter("cidade"));
        medicoControle.getMedico().getEndereco().setCep(formatString(request.getParameter("cep")));
        
        medicoControle.getMedico().getContato().setTelefone(formatString(request.getParameter("telefone")));
        medicoControle.getMedico().getContato().setCelular(formatString(request.getParameter("celular")));
        medicoControle.getMedico().getContato().setEmail(request.getParameter("email"));
        
        medicoControle.getMedico().getUsuario().setName(request.getParameter("nome"));
        medicoControle.getMedico().getUsuario().setUsername(formatString(request.getParameter("cpf")));
        medicoControle.getMedico().getUsuario().setPassword(request.getParameter("senha"));
        medicoControle.getMedico().getUsuario().setAuthority(Authority.ROLE_MED);

        
        medicoControle.saveOrUpdate(medicoControle.getMedico());
        
        HttpSession session = request.getSession();
        session.setAttribute("medico", medicoControle.getMedico());
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
