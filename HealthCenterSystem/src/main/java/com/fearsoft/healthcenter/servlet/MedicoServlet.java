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
import java.util.Date;
import java.util.Iterator;
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
    private HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        medicoControle = new MedicoControle();
        
        String tipoOperacao = request.getParameter("tipoOperacao");
        System.out.println(request.getParameter("tipoOperacao"));
        
        if(tipoOperacao.equals("cadMedico") ){
            cadastrarMedico(request, response);
            System.out.println("CADASTRAR");
        }else if(tipoOperacao.equals("removeMedico")){
            System.out.println("REMOVER MEDICO");
            removerMedico(request, response);
        }else if(tipoOperacao.equals("editMedico")){
            System.out.println("EDITAR MEDICO");
            editMedico(request, response);
        }else if(tipoOperacao.equals("editMedico2")){
            editMedico2(request, response);
        }
        else{
            System.out.println("VISUALIZAR MEDICO");
            viewMedico(request, response);
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
    
    private void cadastrarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            //Cria um novo médico, endereço e usuario
//            medicoControle.setMedico(new Medico());
            medicoControle.getMedico().setEndereco(new Endereco());
            medicoControle.getMedico().setContato(new Contato());
            medicoControle.getMedico().setUsuario(new Usuario());
            
            System.out.println("CRIADO MEDICO   ");
            
            //Seta os valores dos campos da página jsp nos objetos
            setarMedico(request, response);
    }
    
    private void removerMedico(HttpServletRequest request, HttpServletResponse response) throws IOException{
        medicoControle.delete(getMedico(request, response));
        }
    
    private void viewMedico(HttpServletRequest request, HttpServletResponse response){
        System.out.println(getMedico(request, response).toString());
        session.setAttribute("medico", getMedico(request, response));
    }
    
    private void editMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println(request.getParameter("id"));
        System.out.println("EDITMEDICO METODO1");
        session = request.getSession(true);
         System.out.println("EDITMEDICO METODO2");
        session.setAttribute("medico", getMedico(request, response));
         System.out.println("EDITMEDICO METODO3");
//        setarMedico(request, response);
         System.out.println("EDITMEDICO METODO4");
        
        
    }
    
    private void editMedico2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        setarMedico(request, response);
    }
    
    //Retorna o médico passando o ID como busca
    private Medico getMedico(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        for (Iterator it = medicoControle.findAll().iterator(); it.hasNext();) {
            Medico m = (Medico) it.next();
            if(m.getId()==id){
                return m;
            }
        }
        return null;
    }
    
    private void setarMedico(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("SETAR MEDICO");
        System.out.println(request.getParameter("nome"));
        medicoControle.getMedico().setNome(request.getParameter("nome"));
        medicoControle.getMedico().setNaturalidade(request.getParameter("naturalidade"));
        
        
        medicoControle.getMedico().setEspecialidade(Enum.valueOf(MedicoEspecialidade.class, request.getParameter("especialidade")));
        medicoControle.getMedico().setDataNascimento(new Date());
        
        
        medicoControle.getMedico().setSexo(Sexo.MASCULINO);
        medicoControle.getMedico().setEstadoCivil(EstadoCivil.DIVORCIADO);
        medicoControle.getMedico().setCpf(request.getParameter("cpf"));
        medicoControle.getMedico().setRg(request.getParameter("rg"));
        medicoControle.getMedico().setCrm(request.getParameter("crm"));
        
        medicoControle.getMedico().getEndereco().setNomeEndereco(request.getParameter("nomeEndereco"));
        medicoControle.getMedico().getEndereco().setNumero(Integer.parseInt(request.getParameter("numeroEndereco")));
        medicoControle.getMedico().getEndereco().setComplemento(request.getParameter("complemento"));
        medicoControle.getMedico().getEndereco().setBairro(request.getParameter("bairro"));
        medicoControle.getMedico().getEndereco().setCidade(request.getParameter("cidade"));
        medicoControle.getMedico().getEndereco().setCep(request.getParameter("cep"));
        
        medicoControle.getMedico().getContato().setTelefone(request.getParameter("telefone"));
        medicoControle.getMedico().getContato().setCelular(request.getParameter("celular"));
        medicoControle.getMedico().getContato().setEmail(request.getParameter("email"));
        
        medicoControle.getMedico().getUsuario().setName(request.getParameter("nome"));
        medicoControle.getMedico().getUsuario().setUsername(request.getParameter("cpf"));
        medicoControle.getMedico().getUsuario().setPassword(request.getParameter("senha"));
        medicoControle.getMedico().getUsuario().setAuthority(Authority.ROLE_MED);

        
//        session.setAttribute('medico', medicoControle.getMedico());
        
        
        Medico medico = (Medico) session.getAttribute("medico");
        medico = medicoControle.getMedico();
        
        
        System.out.println("ANTES DE SALVAR");
        medicoControle.saveOrUpdate(medicoControle.getMedico());
        System.out.println("SALVO");
        
        session = request.getSession(true);
        session.setAttribute("medico", medicoControle.getMedico());
        System.out.println("SETADO");
        
    }
}
