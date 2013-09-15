/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.util;

import com.fearsoft.healthcenter.entidades.Administrador;
import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Enfermeiro;
import com.fearsoft.healthcenter.entidades.Medico;
import com.fearsoft.healthcenter.entidades.Paciente;
import com.fearsoft.healthcenter.entidades.Recepcionista;
import com.fearsoft.healthcenter.entidades.Triagem;
import com.fearsoft.healthcenter.entidades.Usuario;
import com.fearsoft.healthcenter.enums.Authority;
import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.MedicoEspecialidade;
import com.fearsoft.healthcenter.enums.Sexo;
import com.fearsoft.healthcenter.jpa.AdministradorDao;
import com.fearsoft.healthcenter.jpa.EnfermeiroDao;
import com.fearsoft.healthcenter.jpa.MedicoDao;
import com.fearsoft.healthcenter.jpa.PacienteDao;
import com.fearsoft.healthcenter.jpa.RecepcionistaDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eder Ferreira
 */
public class GerarBanco {
 
    public static void main(String[] args) throws ParseException {
        
        
        Administrador admin = new Administrador();
        
        admin.setCargo("Desenvolvedor");
        admin.setCpf("36693829848");
        admin.setEstadoCivil(EstadoCivil.CASADO);
        admin.setNaturalidade("Brasileiro");
        admin.setNome("Marlon Fernandes Antonio");
        admin.setRg("437310528");
        admin.setSexo(Sexo.MASCULINO);
        
        admin.setContato(new Contato());
        admin.getContato().setTelefone("4435251418");
        admin.getContato().setCelular("4498343609");
        admin.getContato().setEmail("marlonfa@gmail.com");
        
        
        Date data = null;
        data = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1987");
        admin.setDataNascimento(data);
        
        admin.setEndereco(new Endereco());
        admin.getEndereco().setBairro("Centro");
        admin.getEndereco().setCep("87302180");
        admin.getEndereco().setCidade("Campo Mourão");
        admin.getEndereco().setComplemento("Ap. 08");
        admin.getEndereco().setNomeEndereco("Rua Edmundo Mercer");
        admin.getEndereco().setNumero(1824);
                
        
        admin.setUsuario(new Usuario());
        admin.getUsuario().setAuthority(Authority.ROLE_ADMIN);
        admin.getUsuario().setName("Marlon Fernandes Antonio");
        admin.getUsuario().setPassword("123456");
        admin.getUsuario().setUsername("36693829848");
        
        AdministradorDao dao = new AdministradorDao();
        dao.saveOrUpdate(admin);
        
        ///////////////////////////////////////////
        
        
        Medico medico = new Medico();
        
        medico.setCrm("123456");
        medico.setCpf("36693829848");
        medico.setEstadoCivil(EstadoCivil.CASADO);
        medico.setNaturalidade("Brasileiro");
        medico.setNome("Marlon Fernandes Antonio");
        medico.setRg("437310528");
        medico.setSexo(Sexo.MASCULINO);
        medico.setEspecialidade(MedicoEspecialidade.ACUPUNTURISTA);
        
        medico.setContato(new Contato());
        medico.getContato().setTelefone("4435251418");
        medico.getContato().setCelular("4498343609");
        medico.getContato().setEmail("marlonfa@gmail.com");
        
        
        Date data1 = null;
        data1 = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1987");
        medico.setDataNascimento(data1);
        
        medico.setEndereco(new Endereco());
        medico.getEndereco().setBairro("Centro");
        medico.getEndereco().setCep("87302180");
        medico.getEndereco().setCidade("Campo Mourão");
        medico.getEndereco().setComplemento("Ap. 08");
        medico.getEndereco().setNomeEndereco("Rua Edmundo Mercer");
        medico.getEndereco().setNumero(1824);
                
        
        medico.setUsuario(new Usuario());
        medico.getUsuario().setAuthority(Authority.ROLE_ADMIN);
        medico.getUsuario().setName("Marlon Fernandes Antonio");
        medico.getUsuario().setPassword("123456");
        medico.getUsuario().setUsername("36693829848");
        
        MedicoDao dao1 = new MedicoDao();
        dao1.saveOrUpdate(medico);
        
        
        //////////////////////////////////
        
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setCoren("123456");
        enfermeiro.setCpf("36693829848");
        enfermeiro.setEstadoCivil(EstadoCivil.CASADO);
        enfermeiro.setNaturalidade("Brasileiro");
        enfermeiro.setNome("Marlon Fernandes Antonio");
        enfermeiro.setRg("437310528");
        enfermeiro.setSexo(Sexo.MASCULINO);
        
        enfermeiro.setContato(new Contato());
        enfermeiro.getContato().setTelefone("4435251418");
        enfermeiro.getContato().setCelular("4498343609");
        enfermeiro.getContato().setEmail("marlonfa@gmail.com");
        
        
        Date data2 = null;
        data2 = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1987");
        enfermeiro.setDataNascimento(data2);
        
        enfermeiro.setEndereco(new Endereco());
        enfermeiro.getEndereco().setBairro("Centro");
        enfermeiro.getEndereco().setCep("87302180");
        enfermeiro.getEndereco().setCidade("Campo Mourão");
        enfermeiro.getEndereco().setComplemento("Ap. 08");
        enfermeiro.getEndereco().setNomeEndereco("Rua Edmundo Mercer");
        enfermeiro.getEndereco().setNumero(1824);
                
        
        enfermeiro.setUsuario(new Usuario());
        enfermeiro.getUsuario().setAuthority(Authority.ROLE_ADMIN);
        enfermeiro.getUsuario().setName("Marlon Fernandes Antonio");
        enfermeiro.getUsuario().setPassword("123456");
        enfermeiro.getUsuario().setUsername("36693829848");
        
        EnfermeiroDao dao2 = new EnfermeiroDao();
        dao2.saveOrUpdate(enfermeiro);
        
        
        /////////////////////////////////
        
        
         Recepcionista recepcionista = new Recepcionista();
        
        recepcionista.setCpf("36693829848");
        recepcionista.setEstadoCivil(EstadoCivil.CASADO);
        recepcionista.setNaturalidade("Brasileiro");
        recepcionista.setNome("Marlon Fernandes Antonio");
        recepcionista.setRg("437310528");
        recepcionista.setSexo(Sexo.MASCULINO);
        
        recepcionista.setContato(new Contato());
        recepcionista.getContato().setTelefone("4435251418");
        recepcionista.getContato().setCelular("4498343609");
        recepcionista.getContato().setEmail("marlonfa@gmail.com");
        
        
        Date data3 = null;
        data3 = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1987");
        recepcionista.setDataNascimento(data3);
        
        recepcionista.setEndereco(new Endereco());
        recepcionista.getEndereco().setBairro("Centro");
        recepcionista.getEndereco().setCep("87302180");
        recepcionista.getEndereco().setCidade("Campo Mourão");
        recepcionista.getEndereco().setComplemento("Ap. 08");
        recepcionista.getEndereco().setNomeEndereco("Rua Edmundo Mercer");
        recepcionista.getEndereco().setNumero(1824);
                
        
        recepcionista.setUsuario(new Usuario());
        recepcionista.getUsuario().setAuthority(Authority.ROLE_ADMIN);
        recepcionista.getUsuario().setName("Marlon Fernandes Antonio");
        recepcionista.getUsuario().setPassword("123456");
        recepcionista.getUsuario().setUsername("36693829848");
        
        RecepcionistaDao dao3 = new RecepcionistaDao();
        dao3.saveOrUpdate(recepcionista);
        
        
        ///////////////////////////////////
        
        
        Paciente paciente = new Paciente();
        
        paciente.setCpf("01552477940");
        paciente.setEstadoCivil(EstadoCivil.CASADO);
        paciente.setNaturalidade("Brasileiro");
        paciente.setNome("Paciente paciente");
        paciente.setRg("324565678");
        paciente.setSexo(Sexo.MASCULINO);
        
        paciente.setContato(new Contato());
        paciente.getContato().setTelefone("4435251418");
        paciente.getContato().setCelular("4498343609");
        paciente.getContato().setEmail("marlonfa@gmail.com");
        
        
        Date data4 = null;
        data4 = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1987");
        paciente.setDataNascimento(data4);
        
        paciente.setEndereco(new Endereco());
        paciente.getEndereco().setBairro("Centro");
        paciente.getEndereco().setCep("87302180");
        paciente.getEndereco().setCidade("Campo Mourão");
        paciente.getEndereco().setComplemento("Ap. 08");
        paciente.getEndereco().setNomeEndereco("Rua Edmundo Mercer");
        paciente.getEndereco().setNumero(1824);
                
        
        paciente.setUsuario(new Usuario());
        paciente.getUsuario().setAuthority(Authority.ROLE_ADMIN);
        paciente.getUsuario().setName("Marlon Fernandes Antonio");
        paciente.getUsuario().setPassword("123456");
        paciente.getUsuario().setUsername("36693829848");
        
        PacienteDao dao4 = new PacienteDao();
        dao4.saveOrUpdate(paciente);
        
        
        //////////////////////////////
        
        
        Triagem triagem = new Triagem();
        triagem.setPaciente(paciente);
        triagem.setAltura(1.85);
        triagem.setPeso(86.2);
        triagem.setPressaoArterial("12/8");
        triagem.setTemperatura(36.0);
        
        
    }
    
}
