<%-- 
    Document   : cadMedico
    Created on : 21/08/2013, 15:16:29
    Author     : marlon
--%>
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
            var medicoId;
            var pacienteId;

            var oTable;
            $(document).ready(function() {
                oTable = $('#tabela').dataTable({
                    "bScrollCollapse": true,
                    "bPaginate": true,
                    "bJQueryUI": true
                });
            });

            var oTable2;
            $(document).ready(function() {
                oTable2 = $('#tabela2').dataTable({
                    "bScrollCollapse": true,
                    "bPaginate": true,
                    "bJQueryUI": true
                });
            });

            function setMedico(id) {
                medicoId = id;
            }

            function setPaciente(id) {
                pacienteId = id;
            }

            function solicitarTriagem() {
                $.ajax({
                    url: "SolicitacaoTriagemServlet",
                    type: "POST",
                    data: 'medicoId=' + medicoId + '&pacienteId=' + pacienteId + '&tipoOperacao=' + 'solicitarTriagem',
                    complete: callDialog
                });
                reload;
            }
            ;

            function callDialog() {
                $("#dialog-confirm").dialog({
                    modal: true,
                    buttons: {
                        Ok: function() {
                            $(this).dialog("close");
                            callView();
                        }
                    }
                });
            }
             
            function reload(){
                location.reload();
            }


        </script>
    </head>
    <body>
        <h1>Pesquisa de Médico</h1>
        <div id="content">
            <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela">
                <thead>
                    <tr>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>CRM</th>
                        <th>Especialização</th>
                        <th>Selecionar</th>
                    </tr>
                    </tr>
                </thead>
                <tbody>
                    <jsp:useBean id="medicoControle" class="com.fearsoft.healthcenter.controladores.MedicoControle"/>  
                    <c:forEach var="medico" items="${medicoControle.findAll()}" step="1" varStatus="row">
                        <c:choose>
                            <c:when test="${row.count % 2 == 0}">
                                <c:set var="estiloLinha" value="even gradeA"  />
                            </c:when>
                            <c:otherwise>
                                <c:set var="estiloLinha" value="odd gradeX"  />
                            </c:otherwise>
                        </c:choose>
                        <tr class="${estiloLinha}">
                            <td >${medico.nome}</td>
                            <td >${medico.cpf}</td>
                            <td >${medico.crm}</td>
                            <td >${medico.especialidade}</td>
                            <td><input type="radio" id="medico" name="medico"  onclick="setMedico(${medico.id});"></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>CRM</th>
                        <th>Especialização</th>
                        <th>Selecionar</th>
                    </tr>
                </tfoot>
            </table>

        <h1>Pesquisa de Paciente</h1>

            <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela2">
                <thead>
                    <tr>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>SUS</th>
                        <th>Selecionar</th>
                    </tr>
                    </tr>
                </thead>
                <tbody>
                    <jsp:useBean id="pacienteControle" class="com.fearsoft.healthcenter.controladores.PacienteControle"/>  
                    <c:forEach var="paciente" items="${pacienteControle.findAll()}" step="1" varStatus="row">
                        <c:choose>
                            <c:when test="${row.count % 2 == 0}">
                                <c:set var="estiloLinha" value="even gradeA"  />
                            </c:when>
                            <c:otherwise>
                                <c:set var="estiloLinha" value="odd gradeX"  />
                            </c:otherwise>
                        </c:choose>
                        <tr class="${estiloLinha}">
                            <td >${paciente.nome}</td>
                            <td >${paciente.cpf}</td>
                            <td >${paciente.rg}</td>
                            <td >${paciente.sus}</td>

                            <td><input type="radio" id="paciente" name="paciente"  onclick="setPaciente(${paciente.id});"></td>

                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>SUS</th>
                        <th>Selecionar</th>
                    </tr>
                </tfoot>
            </table>

            <input class="submit" type="submit" value="Solicitar Triagem" onclick="solicitarTriagem();" >

        </div>
        <div id="dialog-confirm" title="Solicitação Efetuada com Sucesso!" hidden="true">
            <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Solicitação Efetuada com Sucesso!</p>
        </div>
    </body>
</html>
