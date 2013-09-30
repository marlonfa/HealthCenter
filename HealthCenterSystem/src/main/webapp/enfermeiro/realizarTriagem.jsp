<%@page import="com.fearsoft.healthcenter.util.CodeUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.fearsoft.healthcenter.entidades.Triagem"%>
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
        <script type="text/javascript" src="../resources/js/jquery.maskedinput.min.js"></script>


        <script type="text/javascript">

            //Função para Colocar Máscaras nos campos
            $(function() {
                $.mask.definitions['~'] = "[+-]";
                $("#altura").mask("9,99");
                $("#peso").mask("99?9,9");
                $("#temperatura").mask("99?,9");
                $("#pressaoArterial").mask("999/99?9");
            });


            function setTriagem(id) {
//                $("#dialog-confirm").dialog({
//                    modal: true,
//                    buttons: {
//                        Ok: function() {
//                            $(this).dialog("close");
//                        }
//                    }
//                });
                $.ajax({
                    url: "TriagemServlet",
                    type: "POST",
                    data: 'tipoOperacao=' + 'realizarTriagem' + '&altura=' + $('#altura').val() + '&peso=' + $('#peso').val() +
                            '&temperatura=' + $('#temperatura').val() + '&pressaoArterial=' + $('#pressaoArterial').val(),
//                    complete: mudarPagina
                    complete: callDialog
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

            function callDialog() {
                $("#dialog-confirm").dialog({
                    modal: true,
                    buttons: {
                        Ok: function() {
                            $(this).dialog("close");
                            $.ajax({
                                complete: mudarPagina
                            });
                        }
                    }
                });

            }

        </script>
    </head>
    <body>
        <h1>Realizar Triagem</h1>
        <div id="content">

            <table>
                <tr>
                    <td><label>Nome:</label></td>
                    <td>${triagem.paciente.nome}</td>
                    <td><label>Idade:</label></td>
                    <td>
                        <jsp:scriptlet>
                            Triagem t = (Triagem) request.getSession().getAttribute("triagem");
                            Date nascimento = t.getPaciente().getDataNascimento();
                            out.println(new CodeUtil().calcularIdade(nascimento) + "");
                        </jsp:scriptlet> anos
                    </td>
                </tr>
                <tr>
                    <td><label>Sexo:</label></td>
                    <td>${triagem.paciente.sexo}</td>
                    <td><label>Sus:</label></td>
                    <td>${triagem.paciente.sus}</td>
                </tr>
                <tr>
                    <td><label>Altura:</label></td>
                    <td><input type="text" name="altura" id="altura" placeholder="_,__"/>m</td>
                    <td><label>Peso:</label></td>
                    <td><input type="text" name="peso" id="peso" placeholder="___,_"/>Kg</td>
                </tr>
                <tr>
                    <td><label>Temperatura:</label></td>
                    <td><input type="text" name="temperatura" id="temperatura" placeholder="__,_"/>ºC</td>
                    <td><label>Pressão Arterial:</label></td>
                    <td><input type="text" name="pressaoArterial" id="pressaoArterial" placeholder="___/___"/></td>
                </tr>
            </table>
            <input type="submit" name="salvar" id="salvar" onclick="setTriagem();" value="Realizar"/>


            <div id="dialog-confirm" title="Realização de Triagem" hidden="true">
                <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Triagem Realizada com Sucesso!</p>
            </div>
    </body>
</html>