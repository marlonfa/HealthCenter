<%@page import="java.util.List"%>
<%@page import="com.fearsoft.healthcenter.controladores.MedicoControle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

            function mudarPagina() {

                loading = new Image();
                loading.src = '../imagens/ajax-loader.gif';
                $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
                $('#div_content').load('realizarConsulta.jsp').delay(250).hide().fadeIn();
                parent.$.fn.colorbox.close();
            }
            ;
        </script>
    </head>
    <body>

        <sec:authentication property="name" var="username"/>



        <h1>Consultas</h1>
        <div id="content">
            <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela">
                <thead>
                    <tr>
                    <tr>
                        <th>Nº</th>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Data de Nascimento</th>
                        <th>Realizar Triagem</th>
                    </tr>
                    </tr>
                </thead>
                <tbody>
                    
                    <jsp:useBean id="filaConsultaControle" class="com.fearsoft.healthcenter.controladores.FilaConsultaControle"/>  
                    
                    <c:forEach var="fila" items="${filaConsultaControle.findConsultas()}" step="1" varStatus="row">
                        <c:choose>
                            <c:when test="${row.count % 2 == 0}">
                                <c:set var="estiloLinha" value="even gradeA"  />
                            </c:when>
                            <c:otherwise>
                                <c:set var="estiloLinha" value="odd gradeX"  />
                            </c:otherwise>
                        </c:choose>
                        <c:if test="${username eq fila.usernameMedico}" >
                            <tr class="${estiloLinha}">
                                <td >${row.count}</td>
                                <td >${fila.triagem.paciente.nome}</td>
                                <td >${fila.triagem.paciente.sexo}</td>
                                <td >${fila.triagem.paciente.dataNascimento}</td>
                                <td><input type="submit" id="realizar" name="realizar" value="Realizar" onclick="setConsulta(${fila.id});"></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Nº</th>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Data de Nascimento</th>
                        <th>Realizar Triagem</th>
                    </tr>
                </tfoot>
            </table>

            <div id="dialog-confirm" title="Realização de Triagem Efetuada com Sucesso!" hidden="true">
                <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Realização de Triagem Efetuada com Sucesso!</p>
            </div>
    </body>
</html>