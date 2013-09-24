<%@page import="java.util.List"%>
<%@page import="com.fearsoft.healthcenter.controladores.MedicoControle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

            function setTriagem(id) {

                $.ajax({
                    url: "TriagemServlet",
                    type: "POST",
                    data: 'triagem=' + id + '&tipoOperacao=' +'filaTriagem',
                    complete: mudarPagina
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
        </script>
    </head>
    <body>
        <h1>Realizar Triagem</h1>
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
                    <jsp:useBean id="filaTriagemControle" class="com.fearsoft.healthcenter.controladores.FilaTriagemControle"/>  
                    <c:forEach var="triagem" items="${filaTriagemControle.findAll()}" step="1" varStatus="row">
                        <c:choose>
                            <c:when test="${row.count % 2 == 0}">
                                <c:set var="estiloLinha" value="even gradeA"  />
                            </c:when>
                            <c:otherwise>
                                <c:set var="estiloLinha" value="odd gradeX"  />
                            </c:otherwise>
                        </c:choose>
                        <tr class="${estiloLinha}">
                            <td >${row.count}</td>
                            <td >${triagem.paciente.nome}</td>
                            <td >${triagem.paciente.sexo}</td>
                            <td >${triagem.paciente.dataNascimento}</td>
                            <td><input type="submit" id="enviar" name="enviar" value="Realizar" onclick="setTriagem(${triagem.id});"></td>
                        </tr>
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