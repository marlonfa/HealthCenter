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
//                    data: 'triagem=' + id,
                    data: 'tipoOperacao='+ 'realizarTriagem' +'&altura=' + $('#altura').val() + '&peso=' + $('#peso').val() +
                            '&temperatura=' + $('#temperatura').val() + '&pressaoArterial=' + $('#pressaoArterial').val(),
                    complete: mudarPagina
                });

            }

            function mudarPagina() {

                loading = new Image();
                loading.src = '../imagens/ajax-loader.gif';
                $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
                $('#div_content').load('filaTriagem.jsp').delay(250).hide().fadeIn();
                parent.$.fn.colorbox.close();
            }
            ;
        </script>
    </head>
    <body>
        <h1>Realizar Triagem</h1>
        <div id="content">

            <table>
                <tr>
                    <td>Nome:</td>
                    <td>${triagem.paciente.nome}</td>
                </tr>
                <tr>
                    <td>Sus:</td>
                    <td>${triagem.paciente.sus}</td>
                </tr>
                <tr>
                    <td>Altura:</td>
                    <td><input type="text" name="altura" id="altura" /></td>
                </tr>
                <tr>
                    <td>Peso:</td>
                    <td><input type="text" name="peso" id="peso" /></td>
                </tr>
                <tr>
                    <td>Temperatura:</td>
                    <td><input type="text" name="temperatura" id="temperatura" /></td>
                </tr>
                <tr>
                    <td>Pressão Arterial:</td>
                    <td><input type="text" name="pressaoArterial" id="pressaoArterial" /></td>
                </tr>
            </table>
            <input type="submit" name="salvar" id="salvar" onclick="setTriagem();" />


            <div id="dialog-confirm" title="Realização de Triagem" hidden="true">
                <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Realização de Triagem Efetuada com Sucesso!</p>
            </div>
    </body>
</html>