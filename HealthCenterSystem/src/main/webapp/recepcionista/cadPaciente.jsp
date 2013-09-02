<%-- 
    Document   : cadMedico
    Created on : 21/08/2013, 15:16:29
    Author     : marlon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/css/style.css" rel="stylesheet" type="text/css">
        <title>Health Center - Cadastro de Paciente</title>
    </head>
    <body>
        <div id="content">
                <h1>Cadastro de Paciente</h1>

                <form id="frmMedico" action="" method="post">
                    <table>
                        <tr>
                            <td colspan="8">
                                <h2>Dados Pessoais</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Nome:</label>
                            </td>
                            <td colspan="7"> 
                                <input type="text" name="nome" placeholder="Digite aqui o nome do Médico" size="150" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td>
                                <input type="text" value="" size="20" placeholder="Digite a naturalidade"/>
                            </td>
                            <td>
                                <label>Especialidade:</label>
                            </td>
                            <td>
                                <input type="text" value="" size="20" placeholder="Digite a especialidade"/>
                            </td>
                            <td>
                                <label>Data Nasc.:</label>
                            </td>
                            <td>
                                <input type="text" value="" size="20" placeholder="__/__/____"/>
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td>
                                <input type="radio" name="sex" value="masculino" checked="">Masc.
                                <input type="radio" name="sex" value="feminino">Fem.
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td>
                                <input type="text" value="" size="20" placeholder="___.___.___-__"/>
                            </td>
                            <td>
                                <label>RG:</label>
                            </td>
                            <td>
                                <input type="text" value="" size="20" placeholder="__.___.___-_"/>
                            </td>
                            <td>
                                <label>CRM:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" value="" size="20" placeholder="Digite a CRM"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="8">
                                <h2>Endereço</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Endereço:</label>
                            </td>
                            <td colspan="7"> 
                                <input type="text" name="nome" placeholder="Digite aqui o endereço do Médico" size="140" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Número:</label>
                            </td>
                            <td>
                                <input type="text" name="numeroEndereco" placeholder="Número" size="20" />
                            </td>
                            <td>
                                <label>Complemento:</label>
                            </td>
                            <td>
                                <input type="text" name="numeroEndereco" placeholder="Complemento" size="20" />
                            </td>
                            <td>
                                <label>CEP:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" name="numeroEndereco" placeholder="_____-___" size="20" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="8">
                                <h2>Contato</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Tel. Residencial:</label>
                            </td>
                            <td>
                                <input type="text" name="numeroEndereco" placeholder="(__)____-____" size="20" />
                            </td>
                            <td>
                                <label>Celular:</label>
                            </td>
                            <td>
                                <input type="text" name="numeroEndereco" placeholder="(__)____-____" size="20" />
                            </td>
                            <td>
                                <label>Email:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" name="numeroEndereco" placeholder="email@email.com" size="40" />
                            </td>
                        </tr>
                        
                        <tr>
                            <td colspan="8">
                                <h2>Cadastro de Senha para Acesso do Sistema</h2>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <label>Senha:</label>
                            </td>
                            <td colspan="7">
                                <input type="password" name="numeroEndereco" placeholder="******" size="20" />
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <label>Repetir:</label>
                            </td>
                            <td colspan="7">
                                <input type="password" name="numeroEndereco" placeholder="******" size="20" />
                            </td>
                        </tr>
                        
                    </table>
                </form>
            </div>
    </body>
</html>
