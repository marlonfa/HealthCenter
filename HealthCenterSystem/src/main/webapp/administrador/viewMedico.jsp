<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
<div id="content">
                <h1>Visualização de Médico</h1>
                <form id="frmMedico" method="post">
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
                                $(medico.nome)
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td>
                                $(medico.naturalidade)
                            </td>
                            <td>
                                <label>Especialidade:</label>
                            </td>
                            <td>
                                $(medico.especialidade)
                            </td>
                            <td>
                                <label>Data Nasc.:</label>
                            </td>
                            <td>
                                $(medico.dataNascimento)
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td>
                                $(medico.sexo)
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td>
                                $(medico.cpf)
                            </td>
                            <td>
                                <label>RG:</label>
                            </td>
                            <td>
                                $(medico.rg)
                            </td>
                            <td>
                                <label>CRM:</label>
                            </td>
                            <td colspan="3">
                                $(medico.crm)
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
                                $(medico.nomeEndereco)
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Número:</label>
                            </td>
                            <td>
                                $(medico.numeroEndereco)
                            </td>
                            <td>
                                <label>Complemento:</label>
                            </td>
                            <td>
                                $(medico.complemento)
                            </td>
                            <td>
                                <label>Bairro:</label>
                            </td>
                            <td colspan="3">
                                $(medico.bairro)
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Cidade:</label>
                            </td>
                            <td colspan="3">
                                $(medico.cidade)
                            </td>
                            <td>
                                <label>CEP:</label>
                            </td>
                            <td colspan="3">
                                $(medico.cep)
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
                                $(medico.telefone)
                            </td>
                            <td>
                                <label>Celular:</label>
                            </td>
                            <td>
                                $(medico.celular)
                            </td>
                            <td>
                                <label>Email:</label>
                            </td>
                            <td colspan="3">
                                $(medico.email)
                            </td>
                        </tr>
                        
                        
                        <tr>
                            <td colspan="7">
                                <button type="button" onclick="abrirPagina('cadMedico.jsp');">Editar</button>
                            </td>
                        </tr>
                        
                    </table>
                </form>
            </div>
    </body>
</html>