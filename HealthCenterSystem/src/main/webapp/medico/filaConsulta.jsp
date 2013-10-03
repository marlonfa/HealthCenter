<%@page import="com.fearsoft.healthcenter.acoes.FilaConsulta"%>
<%@page import="java.util.List"%>
<%@page import="com.fearsoft.healthcenter.controladores.MedicoControle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
            function setConsulta(id) {

                $.ajax({
                    url: "ConsultaServlet",
                    type: "POST",
                    data: 'consulta=' + id + '&tipoOperacao=' + 'filaConsulta',
                    complete: mudarPagina
                });
            }

            function removeConsulta(id) {
                $("#dialog-remove").dialog({
                    resizable: false,
                    height: 140,
                    modal: true,
                    buttons: {
                        "Remover": function() {
                            $.ajax({
                                url: "ConsultaServlet",
                                type: "POST",
                                data: 'consulta=' + id + '&tipoOperacao=' + 'removerConsulta',
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
                $('#div_content').load('realizarConsulta.jsp').delay(250).hide().fadeIn();
                parent.$.fn.colorbox.close();
            }
            ;
            function reload() {
                location.reload();
            }
            
            function callDialogConfirmRemove(){
                $("#dialog-remove" ).dialog({
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

        <jsp:useBean id="filaConsultaControle" class="com.fearsoft.healthcenter.controladores.FilaConsultaControle"/>  
        <sec:authentication property="name" var="username" scope="session"/>

        <jsp:scriptlet>
            String username = request.getSession().getAttribute("username").toString();
            List list = filaConsultaControle.findFilter("usernameMedico", username);
            request.setAttribute("filaConsulta", list);
        </jsp:scriptlet>
        
        <c:choose>
            <c:when test="${filaConsulta.size() > 0}">
                <h1>Fila para Consultas</h1>
                <div id="content">
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela">
                        <thead>
                            <tr>
                            <tr>
                                <th>Nº</th>
                                <th>Nome</th>
                                <th>Sexo</th>
                                <th>Data de Nascimento</th>
                                <th>Realizar Consulta</th>
                                <th>Remover Consulta</th>
                            </tr>
                            </tr>
                        </thead>
                        <tbody>

                            <jsp:scriptlet>
                            int pos = 1;
                            </jsp:scriptlet>

                            <c:forEach var="fila" items="${filaConsulta}" step="1" varStatus="row">
                                <c:choose>
                                    <c:when test="${row.count % 2 == 0}">
                                        <c:set var="estiloLinha" value="even gradeA"  />
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="estiloLinha" value="even gradeC"  />
                                    </c:otherwise>
                                </c:choose>
                                <c:if test="${username eq fila.usernameMedico}" >
                                    <tr class="${estiloLinha}">
                                        <td class="realizarConsulta"><jsp:scriptlet>out.print(pos++);</jsp:scriptlet></td>
                                        <td class="realizarConsulta">${fila.triagem.paciente.nome}</td>
                                        <td class="realizarConsulta">${fila.triagem.paciente.sexo}</td>

                                        <td class="realizarConsulta">
                                            <fmt:formatDate value="${fila.triagem.paciente.dataNascimento}" />
                                        </td>

                                        <td class="realizarConsulta"><input type="submit" id="realizar" name="realizar" value="Realizar" onclick="setConsulta(${fila.id});"></td>
                                        <td class="realizarConsulta"><input type="submit" id="remover" name="remover" value="Remover" onclick="removeConsulta(${fila.id});"></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td class="realizarConsulta">Nº</td>
                                <td class="realizarConsulta">Nome</td>
                                <td class="realizarConsulta">Sexo</td>
                                <td class="realizarConsulta">Data de Nascimento</td>
                                <td class="realizarConsulta">Realizar Consulta</td>
                                <td class="realizarConsulta">Remover Consulta</td>
                            </tr>
                        </tfoot>
                    </table>

                    <div id="dialog-confirm" title="Realização de Consulta Efetuada com Sucesso!" hidden="true">
                        <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Realização de Consulta Efetuada com Sucesso!</p>
                    </div>

                    <div id="dialog-remove" title="Remoção de Consulta!" hidden="true">
                        <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Consulta Removida com Sucesso!</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <h2>Todas as Consultas foram realizadas</h2>
                </c:otherwise>
            </c:choose>
    </body>
</html>