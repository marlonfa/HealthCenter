<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function edit(medicoId){
            $.ajax({
                url: "MedicoServlet",  
                type: "POST",
                data: 'id='+ medicoId +'&tipoOperacao='+ 'editMedico'
            }); 
            
            $.colorbox({ 
            href: "editMedico.jsp",
                    overlayClose: false 
            });
        };
        
        function fechar(){
            parent.$.fn.colorbox.close();
            location.reload();
        }
        </script>
    </head>
    <body>
<div id="content">
                <h1>Visualização de Médico</h1>
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
                                ${medico.nome}
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td>
                                ${medico.naturalidade}
                            </td>
                            <td>
                                <label>Especialidade:</label>
                            </td>
                            <td>
                                ${medico.especialidade}
                            </td>
                            <td>
                                <label>Data Nasc.:</label>
                            </td>
                            <td>
                                ${medico.dataNascimento}
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td>
                                ${medico.sexo}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td>
                                ${medico.cpf}
                            </td>
                            <td>
                                <label>RG:</label>
                            </td>
                            <td>
                                ${medico.rg}
                            </td>
                            <td>
                                <label>CRM:</label>
                            </td>
                            <td colspan="3">
                                ${medico.crm}
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
                                ${medico.endereco.nomeEndereco}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Número:</label>
                            </td>
                            <td>
                                ${medico.endereco.numero}
                            </td>
                            <td>
                                <label>Complemento:</label>
                            </td>
                            <td>
                                ${medico.endereco.complemento}
                            </td>
                            <td>
                                <label>Bairro:</label>
                            </td>
                            <td colspan="3">
                                ${medico.endereco.bairro}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Cidade:</label>
                            </td>
                            <td colspan="3">
                                ${medico.endereco.cidade}
                            </td>
                            <td>
                                <label>CEP:</label>
                            </td>
                            <td colspan="3">
                                ${medico.endereco.cep}
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
                                ${medico.contato.telefone}
                            </td>
                            <td>
                                <label>Celular:</label>
                            </td>
                            <td>
                                ${medico.contato.celular}
                            </td>
                            <td>
                                <label>Email:</label>
                            </td>
                            <td colspan="3">
                                ${medico.contato.email}
                            </td>
                        </tr>
                    </table>
                    <button type="button" onclick="fechar();">Fechar</button>
                    <button id="edit" onclick="edit(${medico.id});">Editar</button>
            </div>
    </body>
</html>