<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function edit(recepcionistaId){
            $.ajax({
                url: "RecepcionistaServlet",  
                type: "POST",
                data: 'id='+ recepcionistaId +'&tipoOperacao='+ 'editRecepcionista'
            }); 
            loading = new Image();
            loading.src = '../imagens/ajax-loader.gif';
            $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
            $('#div_content').load('editRecepcionista.jsp').delay(250).hide().fadeIn();
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
                                ${recepcionista.nome}
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td>
                                ${recepcionista.naturalidade}
                            </td>
                            <td>
                                <label>Data Nasc.:</label>
                            </td>
                            <td>
                                ${recepcionista.dataNascimento}
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td>
                                ${recepcionista.sexo}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td>
                                ${recepcionista.cpf}
                            </td>
                            <td>
                                <label>RG:</label>
                            </td>
                            <td>
                                ${recepcionista.rg}
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
                                ${recepcionista.endereco.nomeEndereco}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Número:</label>
                            </td>
                            <td>
                                ${recepcionista.endereco.numero}
                            </td>
                            <td>
                                <label>Complemento:</label>
                            </td>
                            <td>
                                ${recepcionista.endereco.complemento}
                            </td>
                            <td>
                                <label>Bairro:</label>
                            </td>
                            <td colspan="3">
                                ${recepcionista.endereco.bairro}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Cidade:</label>
                            </td>
                            <td colspan="3">
                                ${recepcionista.endereco.cidade}
                            </td>
                            <td>
                                <label>CEP:</label>
                            </td>
                            <td colspan="3">
                                ${recepcionista.endereco.cep}
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
                                ${recepcionista.contato.telefone}
                            </td>
                            <td>
                                <label>Celular:</label>
                            </td>
                            <td>
                                ${recepcionista.contato.celular}
                            </td>
                            <td>
                                <label>Email:</label>
                            </td>
                            <td colspan="3">
                                ${recepcionista.contato.email}
                            </td>
                        </tr>
                    </table>
                    <button type="button" onclick="fechar();">Fechar</button>
                    <button id="edit" onclick="edit(${recepcionista.id});">Editar</button>
            </div>
    </body>
</html>