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


    </head>
    <body>

        <table>
            <tr>
                <td colspan="4">
                    <h2>Dados Triagem</h2>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Data da Consulta</label>
                </td>
                <td> 
                    ${historicoClinico.consulta.triagem.dataConsulta}
                </td>
            </tr>
            <tr>
                <td>
                    <label>Altura:</label>
                </td>
                <td>
                    ${historicoClinico.consulta.triagem.altura}
                </td>
                <td>
                    <label>Peso:</label>
                </td>
                <td>
                    ${historicoClinico.consulta.triagem.peso}
                </td>
            </tr>
            <tr>
                <td>
                    <label>Temperatura:</label>
                </td>
                <td>
                    ${historicoClinico.consulta.triagem.temperatura}
                </td>
                <td>
                    <label>Pressão Arterial:</label>
                </td>
                <td>
                    ${historicoClinico.consulta.triagem.pressaoArterial}
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <h2>Dados Consulta</h2>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Medico:</label>
                </td>
                <td> 
                    ${historicoClinico.consulta.triagem.medico.nome}
                </td>
            </tr>

            <tr>
                <td>
                    <label>Sintomas:</label>
                </td>
                <td>
                    ${historicoClinico.consulta.sintomas}
                </td>
            </tr>
            <tr>
                <td>
                    <label>Diagnóstico:</label>
                </td>
                <td>
                    ${historicoClinico.consulta.diagnostico}
                </td>
            </tr>
            <tr>
                <td>
                    <label>Prescrição:</label>
                </td>
                <td>
                    ${historicoClinico.consulta.prescricao}
                </td>
            </tr>
        </table>

    </body>
</html>