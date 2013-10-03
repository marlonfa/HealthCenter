<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function edit(medicoId) {
                $.ajax({
                    url: "PacienteServlet",
                    type: "POST",
                    data: 'id=' + medicoId + '&tipoOperacao=' + 'editPaciente'
                });
                loading = new Image();
                loading.src = '../imagens/ajax-loader.gif';
                $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
                $('#div_content').load('editPaciente.jsp').delay(250).hide().fadeIn();
                parent.$.fn.colorbox.close();
            }
            ;

            function fechar() {
                parent.$.fn.colorbox.close();
                location.reload();
            }
        </script>
    </head>
    <body>
        <div id="content">
            <h1>Visualização de Paciente</h1>
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
                        ${paciente.nome}

                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Naturalidade:</label>
                    </td>
                    <td>
                        ${paciente.naturalidade}
                    </td>
                    <td>
                        <label>Data Nasc.:</label>
                    </td>
                    <td>
                        <fmt:formatDate value="${paciente.dataNascimento}" />
                    </td>
                    <td>
                        <label>Sexo:</label>
                    </td>
                    <td>
                        ${paciente.sexo}
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Estado Civil:</label>
                    </td>
                    <td>${paciente.estadoCivil}</td>
                    <td>
                        <label>CPF:</label>
                    </td>
                    <td>
                        ${paciente.cpf}
                    </td>
                    <td>
                        <label>RG:</label>
                    </td>
                    <td>
                        ${paciente.rg}
                    </td>
                    <td>
                        <label>SUS:</label>
                    </td>
                    <td>
                        ${paciente.sus}
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
                        ${paciente.endereco.nomeEndereco}
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Número:</label>
                    </td>
                    <td>
                        ${paciente.endereco.numero}
                    </td>
                    <td>
                        <label>Complemento:</label>
                    </td>
                    <td>
                        ${paciente.endereco.complemento}
                    </td>
                    <td>
                        <label>Bairro:</label>
                    </td>
                    <td colspan="3">
                        ${paciente.endereco.bairro}
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Cidade:</label>
                    </td>
                    <td colspan="3">
                        ${paciente.endereco.cidade}
                    </td>
                    <td>
                        <label>CEP:</label>
                    </td>
                    <td colspan="3">
                        ${paciente.endereco.cep}
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
                        ${paciente.contato.telefone}
                    </td>
                    <td>
                        <label>Celular:</label>
                    </td>
                    <td>
                        ${paciente.contato.celular}
                    </td>
                    <td>
                        <label>Email:</label>
                    </td>
                    <td colspan="3">
                        ${paciente.contato.email}
                    </td>
                </tr>
            </table>
            <button type="button" onclick="fechar();">Fechar</button>
            <button id="edit" onclick="edit(${paciente.id});">Editar</button>
        </div>
    </body>
</html>