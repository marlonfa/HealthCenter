<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function edit(administradorId){
            $.ajax({
                url: "AdministradorServlet",  
                type: "POST",
                data: 'id='+ administradorId +'&tipoOperacao='+ 'editAdministrador'
            }); 
            loading = new Image();
            loading.src = '../imagens/ajax-loader.gif';
            $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
            $('#div_content').load('editAdministrador.jsp').delay(250).hide().fadeIn();
            parent.$.fn.colorbox.close();
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
                                ${administrador.nome}
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td>
                                ${administrador.naturalidade}
                            </td>
                            <td>
                                <label>Data Nasc.:</label>
                            </td>
                            <td>
                                ${administrador.dataNascimento}
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td>
                                ${administrador.sexo}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td>
                                ${administrador.cpf}
                            </td>
                            <td>
                                <label>RG:</label>
                            </td>
                            <td>
                                ${administrador.rg}
                            </td>
                            <td>
                                <label>Cargo:</label>
                            </td>
                            <td colspan="3">
                                ${administrador.cargo}
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
                                ${administrador.endereco.nomeEndereco}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Número:</label>
                            </td>
                            <td>
                                ${administrador.endereco.numero}
                            </td>
                            <td>
                                <label>Complemento:</label>
                            </td>
                            <td>
                                ${administrador.endereco.complemento}
                            </td>
                            <td>
                                <label>Bairro:</label>
                            </td>
                            <td colspan="3">
                                ${administrador.endereco.bairro}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Cidade:</label>
                            </td>
                            <td colspan="3">
                                ${administrador.endereco.cidade}
                            </td>
                            <td>
                                <label>CEP:</label>
                            </td>
                            <td colspan="3">
                                ${administrador.endereco.cep}
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
                                ${administrador.contato.telefone}
                            </td>
                            <td>
                                <label>Celular:</label>
                            </td>
                            <td>
                                ${administrador.contato.celular}
                            </td>
                            <td>
                                <label>Email:</label>
                            </td>
                            <td colspan="3">
                                ${administrador.contato.email}
                            </td>
                        </tr>
                    </table>
                    <button type="button" onclick="fechar();">Fechar</button>
                    <button id="edit" onclick="edit(${administrador.id});">Editar</button>
            </div>
    </body>
</html>