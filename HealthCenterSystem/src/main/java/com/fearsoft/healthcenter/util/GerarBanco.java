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
import com.fearsoft.healthcenter.entidades.Consulta;
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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class GerarBanco {
 
    public static void main(String[] args) throws ParseException {
        
        
//        Administrador admin = new Administrador();
//        
//        admin.setCargo("Desenvolvedor");
//        admin.setCpf("36693829848");
//        admin.setEstadoCivil(EstadoCivil.CASADO);
//        admin.setNaturalidade("Fenixense");
//        admin.setNome("Eder dos Santos Ferreira");
//        admin.setRg("437310528");
//        admin.setSexo(Sexo.MASCULINO);
//        
//        admin.setContato(new Contato());
//        admin.getContato().setTelefone("4435251418");
//        admin.getContato().setCelular("4498343609");
//        admin.getContato().setEmail("eder.esf92@gmail.com");
//        
//        
//        Date data = null;
//        data = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1992");
//        admin.setDataNascimento(data);
//        
//        admin.setEndereco(new Endereco());
//        admin.getEndereco().setBairro("Centro");
//        admin.getEndereco().setCep("87302180");
//        admin.getEndereco().setCidade("Fenix");
//        admin.getEndereco().setComplemento("Proximo a Capela Mortuaria");
//        admin.getEndereco().setNomeEndereco("Rua Rui Barbosa");
//        admin.getEndereco().setNumero(1824);
//                
//        
//        admin.setUsuario(new Usuario());
//        admin.getUsuario().setAuthority(Authority.ROLE_ADMIN);
//        admin.getUsuario().setName("Eder dos Santos Ferreira");
//        admin.getUsuario().setPassword("123");
//        admin.getUsuario().setUsername("12345678909");
//        
//        AdministradorDao dao = new AdministradorDao();
//        dao.saveOrUpdate(admin);
        
        ///////////////////////////////////////////
        
        
//        Enfermeiro enfermeiro = new Enfermeiro();
//        
//        enfermeiro.setCoren("123456");
//        enfermeiro.setCpf("36693829848");
//        enfermeiro.setEstadoCivil(EstadoCivil.CASADO);
//        enfermeiro.setNaturalidade("Jandaiense");
//        enfermeiro.setNome("João Batista");
//        enfermeiro.setRg("437310528");
//        enfermeiro.setSexo(Sexo.MASCULINO);
//        
//        enfermeiro.setContato(new Contato());
//        enfermeiro.getContato().setTelefone("4435251418");
//        enfermeiro.getContato().setCelular("4498343609");
//        enfermeiro.getContato().setEmail("joao@gmail.com");
//        
//        
//        Date data2 = null;
//        data2 = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1990");
//        enfermeiro.setDataNascimento(data2);
//        
//        enfermeiro.setEndereco(new Endereco());
//        enfermeiro.getEndereco().setBairro("Centro");
//        enfermeiro.getEndereco().setCep("87302180");
//        enfermeiro.getEndereco().setCidade("Jandaia do Sul");
//        enfermeiro.getEndereco().setComplemento("Ap. 08");
//        enfermeiro.getEndereco().setNomeEndereco("Rua das Ruas");
//        enfermeiro.getEndereco().setNumero(1824);
//                
//        
//        enfermeiro.setUsuario(new Usuario());
//        enfermeiro.getUsuario().setAuthority(Authority.ROLE_ENF);
//        enfermeiro.getUsuario().setName("joao");
//        enfermeiro.getUsuario().setPassword("123");
//        enfermeiro.getUsuario().setUsername("37288237400");
//        
//        EnfermeiroDao dao2 = new EnfermeiroDao();
//        dao2.saveOrUpdate(enfermeiro);
//        
        
        /////////////////////////////////
        
//         Recepcionista recepcionista = new Recepcionista();
//        
//        recepcionista.setCpf("36693829848");
//        recepcionista.setEstadoCivil(EstadoCivil.CASADO);
//        recepcionista.setNaturalidade("Beltraoense");
//        recepcionista.setNome("Maria");
//        recepcionista.setRg("437310528");
//        recepcionista.setSexo(Sexo.MASCULINO);
//        
//        recepcionista.setContato(new Contato());
//        recepcionista.getContato().setTelefone("4435251418");
//        recepcionista.getContato().setCelular("4498343609");
//        recepcionista.getContato().setEmail("maria@gmail.com");
//        
//        
//        Date data3 = null;
//        data3 = new SimpleDateFormat("dd/MM/yyyy").parse("18/10/1984");
//        recepcionista.setDataNascimento(data3);
//        
//        recepcionista.setEndereco(new Endereco());
//        recepcionista.getEndereco().setBairro("Centro");
//        recepcionista.getEndereco().setCep("87302180");
//        recepcionista.getEndereco().setCidade("Engenheiro Beltrao");
//        recepcionista.getEndereco().setComplemento("Ap. 08");
//        recepcionista.getEndereco().setNomeEndereco("Rua das Ruas");
//        recepcionista.getEndereco().setNumero(1824);
//                
//        
//        recepcionista.setUsuario(new Usuario());
//        recepcionista.getUsuario().setAuthority(Authority.ROLE_REC);
//        recepcionista.getUsuario().setName("Maria");
//        recepcionista.getUsuario().setPassword("123");
//        recepcionista.getUsuario().setUsername("10477656404");
//        
//        RecepcionistaDao dao3 = new RecepcionistaDao();
//        dao3.saveOrUpdate(recepcionista);
//        
//        
//        ///////////////////////////////////
//        
        
//        Medico medico = new Medico();
//        
//        medico.setCrm("121212");
//        medico.setCpf("37773829848");
//        medico.setEstadoCivil(EstadoCivil.CASADO);
//        medico.setNaturalidade("Fenixense");
//        medico.setNome("Eder Ferreira");
//        medico.setRg("437310528");
//        medico.setSexo(Sexo.MASCULINO);
//        medico.setEspecialidade(MedicoEspecialidade.ACUPUNTURISTA);
//        
//        medico.setContato(new Contato());
//        medico.getContato().setTelefone("4435251418");
//        medico.getContato().setCelular("4498343609");
//        medico.getContato().setEmail("eder@gmail.com");
//        
//        
//        Date data1 = null;
//        data1 = new SimpleDateFormat("dd/MM/yyyy").parse("04/08/1992");
//        medico.setDataNascimento(data1);
//        
//        medico.setEndereco(new Endereco());
//        medico.getEndereco().setBairro("Centro");
//        medico.getEndereco().setCep("87302180");
//        medico.getEndereco().setCidade("Fenix");
//        medico.getEndereco().setComplemento("Ap. 10");
//        medico.getEndereco().setNomeEndereco("Rua Rui Barbosa");
//        medico.getEndereco().setNumero(1824);
//                
//        
//        medico.setUsuario(new Usuario());
//        medico.getUsuario().setAuthority(Authority.ROLE_MED);
//        medico.getUsuario().setName("Eder");
//        medico.getUsuario().setPassword("123");
//        medico.getUsuario().setUsername("85851257644");
//        
//        MedicoDao dao1 = new MedicoDao();
//        dao1.saveOrUpdate(medico);
        
        
        /////////////////////////////////////
        
//        Paciente paciente = new Paciente();
//        
//        paciente.setCpf("36693829848");
//        paciente.setEstadoCivil(EstadoCivil.CASADO);
//        paciente.setNaturalidade("Mouraoense");
//        paciente.setNome("Marlon Super Viadinho");
//        paciente.setRg("333534578");
//        paciente.setSexo(Sexo.MASCULINO);
//        paciente.setSus("333111122224444");
//        
//        paciente.setContato(new Contato());
//        paciente.getContato().setTelefone("4435251418");
//        paciente.getContato().setCelular("4498343609");
//        paciente.getContato().setEmail("marlonfa@gmail.com");
//        
//        
//        Date data4 = null;
//        data4 = new SimpleDateFormat("dd/MM/yyyy").parse("03/04/2001");
//        paciente.setDataNascimento(data4);
//        
//        paciente.setEndereco(new Endereco());
//        paciente.getEndereco().setBairro("Centro");
//        paciente.getEndereco().setCep("87302180");
//        paciente.getEndereco().setCidade("Campo Mourao");
//        paciente.getEndereco().setComplemento("Ap. 09");
//        paciente.getEndereco().setNomeEndereco("Rua Rui Dias");
//        paciente.getEndereco().setNumero(1824);
//                
//        
//        paciente.setUsuario(new Usuario());
//        paciente.getUsuario().setAuthority(null);
//        paciente.getUsuario().setName("Marlon");
//        paciente.getUsuario().setPassword("123");
//        paciente.getUsuario().setUsername("84743912105");
//        
//        PacienteDao dao4 = new PacienteDao();
//        dao4.saveOrUpdate(paciente);
////        
//        
//        //////////////////////////////
//        
//        
//        Consulta triagem = new Consulta();
//        triagem.setPaciente(paciente);
//        triagem.setAltura(1.85);
//        triagem.setPeso(86.2);
//        triagem.setPressaoArterial("12/8");
//        triagem.setTemperatura(36.0);
        
        
        List <Administrador> lista = new AdministradorDao().findFilter("nome", "");
        
        for (Iterator<Administrador> it = lista.iterator(); it.hasNext();) {
            Administrador administrador = it.next();
            System.out.println(administrador.getNome());
        }
        

        
    }
    
}
