/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author marlon
 */
@WebServlet(name = "GerarReceitaMedicaServlet", urlPatterns = {"/medico/GerarReceitaMedicaServlet"})
public class GerarReceitaMedicaServlet extends HttpServlet {
    private String caminhoRelatorio;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Map parametros = new HashMap();
            parametros.put("nomeMedico", "Medico");
            parametros.put("nomePaciente", "Paciente");
            parametros.put("prescricao", "Dipironas");
        try {
            gerarReceita(request, response, parametros);
        } catch (SQLException ex) {
            Logger.getLogger(GerarReceitaMedicaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
     public void gerarReceita(HttpServletRequest request, HttpServletResponse response, Map parametros) throws ServletException, IOException, SQLException {
                     this.caminhoRelatorio = getServletContext().getRealPath("/relatorios") + "/receita.jasper";
                     File file = new File(this.caminhoRelatorio);
//                     InputStream receitaStream = this.getClass().getResourceAsStream(this.caminhoRelatorio);
                     InputStream receitaStream = new FileInputStream(file);
                    try {
                        JasperPrint print = JasperFillManager.fillReport(receitaStream, parametros, getConnection());
                        
                        JRExporter exportador = new JRPdfExporter();
                        exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                        exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);
                        response.setContentType("application/pdf");
                        
                        exportador.exportReport();
                    } catch (Exception ex) {
                        throw new SQLException("Erro relatório "+this.caminhoRelatorio, ex);
                    }
                     
        }
     public Connection getConnection() {
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String senha = "root";
        String endereco = "jdbc:mysql://localhost:3306/healthcenter";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(endereco, usuario, senha);
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
            return null;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return null;
        } catch (Exception erro) {
            erro.getMessage();
            System.out.println("Nao foi possivel efetuar a conexao!");
            return null;
        }
        return con;
    }
     
}
