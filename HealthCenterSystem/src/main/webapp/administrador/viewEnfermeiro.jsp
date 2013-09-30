<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function edit(enfermeiroId){
            $.ajax({
                url: "EnfermeiroServlet",  
                type: "POST",
                data: 'id='+ enfermeiroId +'&tipoOperacao='+ 'editEnfermeiro'
            }); 
            loading = new Image();
            loading.src = '../imagens/ajax-loader.gif';
            $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
            $('#div_content').load('editEnfermeiro.jsp').delay(250).hide().fadeIn();
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
                <h1>Visualização de Enfermeiro</h1>
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
                                ${enfermeiro.nome}
                                
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td>
                                ${enfermeiro.naturalidade}
                            </td>
                            <td>
                                <label>Data Nasc.:</label>
                            </td>
                            <td>
                                <fmt:formatDate value="${enfermeiro.dataNascimento}" />
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td>
                                ${enfermeiro.sexo}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td>
                                ${enfermeiro.cpf}
                            </td>
                            <td>
                                <label>RG:</label>
                            </td>
                            <td>
                                ${enfermeiro.rg}
                            </td>
                            <td>
                                <label>COREN:</label>
                            </td>
                            <td colspan="3">
                                ${enfermeiro.coren}
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
                                ${enfermeiro.endereco.nomeEndereco}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Número:</label>
                            </td>
                            <td>
                                ${enfermeiro.endereco.numero}
                            </td>
                            <td>
                                <label>Complemento:</label>
                            </td>
                            <td>
                                ${enfermeiro.endereco.complemento}
                            </td>
                            <td>
                                <label>Bairro:</label>
                            </td>
                            <td colspan="3">
                                ${enfermeiro.endereco.bairro}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Cidade:</label>
                            </td>
                            <td colspan="3">
                                ${enfermeiro.endereco.cidade}
                            </td>
                            <td>
                                <label>CEP:</label>
                            </td>
                            <td colspan="3">
                                ${enfermeiro.endereco.cep}
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
                                ${enfermeiro.contato.telefone}
                            </td>
                            <td>
                                <label>Celular:</label>
                            </td>
                            <td>
                                ${enfermeiro.contato.celular}
                            </td>
                            <td>
                                <label>Email:</label>
                            </td>
                            <td colspan="3">
                                ${enfermeiro.contato.email}
                            </td>
                        </tr>
                    </table>
                    <button type="button" onclick="fechar();">Fechar</button>
                    <button id="edit" onclick="edit(${enfermeiro.id});">Editar</button>
            </div>
    </body>
</html>