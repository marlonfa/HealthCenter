<%@page import="com.fearsoft.healthcenter.acoes.FilaTriagem"%>
<%@page import="com.fearsoft.healthcenter.util.CodeUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.fearsoft.healthcenter.controladores.MedicoControle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<META http-equiv="REFRESH" content="30">-->
        <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
        <link href="../resources/css/table_jui.css" rel="stylesheet" type="text/css" />
        <!--<link href="../resources/css/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css" />-->
        <link href="../resources/css/colorbox.css" rel="stylesheet" type="text/css" />
        <link href="../resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="../resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="../resources/js/jquery.dataTables.min.js"></script>
        <!--<script type="text/javascript" src="../resources/js/jquery.jeditable.js"></script>-->
        <script type="text/javascript" src="../resources/js/jquery-ui.js"></script>
        <script type="text/javascript" src="../resources/js/jQueryValidate.js"></script>
        <!--<script type="text/javascript" src="../resources/js/jquery.dataTables.editable.js"></script>-->
        <script type="text/javascript" src="../resources/js/jquery.colorbox-min.js"></script>
        <!--<script type="text/javascript" src="../resources/js/fnReloadAjax.js"></script>-->


        <script type="text/javascript">

            function setTriagem(id) {

                $.ajax({
                    url: "TriagemServlet",
                    type: "POST",
                    data: 'triagem=' + id + '&tipoOperacao=' + 'filaTriagem',
                    complete: mudarPagina
                });

            }


            function removeTriagem(id) {
                $("#dialog-remove").dialog({
                    resizable: false,
                    height: 140,
                    modal: true,
                    buttons: {
                        "Remover": function() {
                            $.ajax({
                                url: "TriagemServlet",
                                type: "POST",
                                data: 'triagem=' + id + '&tipoOperacao=' + 'removerTriagem',
                                complete: callDialogConfirmRemove
                            });
                            $(this).dialog("close");
                        },
                        "Cancelar": function() {
                            $(this).dialog("close");
                        }
                    }
                });
            }

            function mudarPagina() {

                loading = new Image();
                loading.src = '../imagens/ajax-loader.gif';
                $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
                $('#div_content').load('realizarTriagem.jsp').delay(250).hide().fadeIn();
                parent.$.fn.colorbox.close();
            }
            ;

            function reload() {
                location.reload();
            }
            
            function callDialogConfirmRemove(){
                $("#remove-confirm").dialog({
                      modal: true,
                      buttons: {
                        Ok: function() {
                          $( this ).dialog( "close" );
                          reload();
                        }
                      }
                    });
                } 
        </script>
    </head>
    <body>

        <jsp:useBean id="filaTriagemControle" class="com.fearsoft.healthcenter.controladores.FilaTriagemControle"/>  

        <c:choose>
            <c:when test="${filaTriagemControle.findAll().size() > 0}">
                <c:set var="filaTriagem" value="${filaTriagemControle.findAll()}" />

                <h1>Fila para Triagem</h1>
                <div id="content">
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela">
                        <thead>
                            <tr>
                            <tr>
                                <th>Nº</th>
                                <th>Nome</th>
                                <th>SUS</th>
                                <th>Sexo</th>
                                <th>Idade</th>
                                <th>Realizar Triagem</th>
                                <th>Remover Triagem</th>
                            </tr>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="triagem" items="${filaTriagem}" step="1" varStatus="row">
                                <c:choose>
                                    <c:when test="${row.count % 2 == 0}">
                                        <c:set var="estiloLinha" value="even gradeA"  />
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="estiloLinha" value="even gradeC"  />
                                    </c:otherwise>
                                </c:choose>
                                <c:set var="triagemList" value="${triagem}" scope="session" />
                                <tr class="${estiloLinha}">
                                    <td class="realizarConsulta">${row.count}</td>
                                    <td class="realizarConsulta">${triagem.paciente.nome}</td>
                                    <td class="realizarConsulta">${triagem.paciente.sus}</td>
                                    <td class="realizarConsulta">${triagem.paciente.sexo}</td>
                                    <td class="realizarConsulta">
                                        <jsp:scriptlet>
                                            FilaTriagem t = (FilaTriagem) request.getSession().getAttribute("triagemList");
                                            Date nascimento = t.getPaciente().getDataNascimento();
                                            out.println(new CodeUtil().calcularIdade(nascimento) + "");
                                        </jsp:scriptlet> anos
                                    </td>
                                    <td class="realizarConsulta"><input type="submit" id="enviar" name="enviar" value="Realizar" onclick="setTriagem(${triagem.id});"></td>
                                    <td class="realizarConsulta"><input type="submit" id="remover" name="remover" value="Remover" onclick="removeTriagem(${triagem.id});"></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td class="realizarConsulta">Nº</td>
                                <td class="realizarConsulta">Nome</td>
                                <td class="realizarConsulta">SUS</td>
                                <td class="realizarConsulta">Sexo</td>
                                <td class="realizarConsulta">Idade</td>
                                <td class="realizarConsulta">Realizar Triagem</td>
                                <td class="realizarConsulta">Remover Triagem</td>
                            </tr>
                        </tfoot>
                    </table>


                    <div id="dialog-confirm" title="Realização de Triagem Efetuada com Sucesso!" hidden="true">
                        <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Realização de Triagem Efetuada com Sucesso!</p>
                    </div>

                    <div id="dialog-remove" title="Remoção de Triagem!" hidden="true">
                        <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Deseja Remover Triagem!</p>
                    </div>
                    <div id="remove-confirm" title="Confirmação de Remoção de Fila de Triagem!" hidden="true">
                        <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Removido com Sucesso!</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <h2>Todas às Triagens foram realizadas</h2>
                </c:otherwise>
            </c:choose>
    </body>
</html>