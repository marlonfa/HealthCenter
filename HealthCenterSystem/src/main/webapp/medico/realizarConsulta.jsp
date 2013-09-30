<%@page import="com.fearsoft.healthcenter.util.CodeUtil"%>
<%@page import="com.fearsoft.healthcenter.entidades.Consulta"%>
<%@page import="java.lang.String"%>
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


        <script type="text/javascript">
            function setConsulta() {

                $.ajax({
                    url: "ConsultaServlet",
                    type: "POST",
//                    data: 'triagem=' + id,
                    data: 'tipoOperacao=' + 'realizarConsulta' + '&sintomas=' + $('#sintomas').val() + '&diagnostico=' + $('#diagnostico').val() +
                            '&prescricao=' + $('#prescricao').val(),
//                    complete: mudarPagina
                    complete: callDialog
                });
            }

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

            function mudarPagina() {

                loading = new Image();
                loading.src = '../imagens/ajax-loader.gif';
                $('#div_content').html('<img id="loader" src="../imagens/ajax-loader.gif" />');
                $('#div_content').load('filaConsulta.jsp').delay(250).hide().fadeIn();
                parent.$.fn.colorbox.close();
            }
            ;

            function viewHistorico(id) {
                $.ajax({
                    url: "HistoricoClinicoServlet",
                    type: "POST",
                    data: 'historicoId=' + id,
                    complete: callView
                });
            }
            ;

            function callView() {
                $.colorbox({
                    href: "viewHistorico.jsp",
                    overlayClose: false
                });
            }
        </script>
    </head>
    <body>
        <h1>Realizar Consulta</h1>
        <div id="content">

            <label>Paciente</label>
            <table style="width: 320px">
                <tr>
                    <td><label>Nome:</label></td>
                    <td>${consulta.triagem.paciente.nome}</td>
                </tr>
                <tr>
                    <td><label>Sexo:</label></td>
                    <td>${consulta.triagem.paciente.sexo}</td>
                    <td><label>Idade:</label></td>
                    <td>
                        <jsp:scriptlet>
                            Consulta c = (Consulta) request.getSession().getAttribute("consulta");
                            Date nascimento = c.getTriagem().getPaciente().getDataNascimento();
                            out.println(new CodeUtil().calcularIdade(nascimento) + "");
                        </jsp:scriptlet> anos
                    </td>
                </tr>
            </table>

            <label>
                Triagem
            </label>

            <table style="width: 320px">
                <tr>
                    <td><label>Altura:</label></td>
                    <td>${consulta.triagem.altura}</td>
                    <td><label>Peso:</label></td>
                    <td>${consulta.triagem.peso}</td>
                </tr>
                <tr>
                    <td><label>Temperatura:</label></td>
                    <td>${consulta.triagem.temperatura}</td>
                    <td><label>Pressão Arterial:</label></td>
                    <td>${consulta.triagem.pressaoArterial}</td>
                </tr>
            </table>    

            <label>Dados da Consulta</label>

            <table>
                <tr>
                    <td>Sintomas:</td>
                    <td> <textarea id="sintomas" name="sintomas" cols="60" rows="8" placeholder="Sintomas apresentados pelo paciente"> </textarea></td>
                </tr>
                <tr>
                    <td>Diagnóstico:</td>
                    <td> <textarea id="diagnostico" name="diagnostico" cols="60" rows="8" placeholder="Diagnóstico do paciente"> </textarea></td>
                </tr>
                <tr>
                    <td>Prescrição:</td>
                    <td> <textarea id="prescricao" name="prescicao" cols="60" rows="8" placeholder="Prescrição de medicamentos"> </textarea></td>
                </tr>
            </table>

            <input type="submit" value="Realizar" id="realizar" name="realizar" onclick="setConsulta();" style="margin-right: auto"/>
            <input type="submit" value="Voltar" id="voltar" name="voltar" onclick="mudarPagina();" style="margin-right: auto"/>

            <br />
            <br />

            <jsp:useBean id="historicoControle" class="com.fearsoft.healthcenter.controladores.HistoricoClinicoControle"/>  

            <jsp:scriptlet>
                Long id = ((Consulta) request.getSession().getAttribute("consulta")).getTriagem().getPaciente().getId();
                List list = historicoControle.findCustom(id);
                request.setAttribute("historicoClinico", list);
            </jsp:scriptlet>

            <c:choose>
                <c:when test="${historicoClinico.size() > 0}">
                    <label>Histórico Clínico</label>

                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela">
                        <thead>
                            <tr>
                                <th>Data da Consulta</th>
                                <th>Sexo</th>
                                <th>Sintomas</th>
                                <th>Visualizar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="historico" items="${historicoClinico}" step="1" varStatus="row">
                                <c:choose>
                                    <c:when test="${row.count % 2 == 0}">
                                        <c:set var="estiloLinha" value="even gradeA"  />
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="estiloLinha" value="even gradeC"  />
                                    </c:otherwise>
                                </c:choose>

                                <%--<c:if test="{consulta.triagem.paciente.id eq historico.idPaciente}" >--%>
                                    <tr class="${estiloLinha}">
                                        <td class="realizarConsulta">
                                            <fmt:formatDate value="${historico.consulta.triagem.dataConsulta}" />
                                        </td>
                                        <td class="realizarConsulta">${historico.consulta.triagem.paciente.sexo}</td>
                                        <td>${historico.consulta.sintomas}</td>
                                        <td class="realizarConsulta"><input type="submit" id="visualizar" name="visualizar" value="Visualizar" onclick="viewHistorico(${historico.id});"></td>
                                    </tr>
                                <%--</c:if>--%>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td class="realizarConsulta">Data da Consulta</td>
                                <td class="realizarConsulta">Sexo</td>
                                <td class="realizarConsulta">Sintomas</td>
                                <td class="realizarConsulta">Visualizar</td>
                            </tr>
                        </tfoot>
                    </table>

                    <div id="dialog-confirm" title="Realização de Triagem" hidden="true">
                        <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Realização de Triagem Efetuada com Sucesso!</p>
                    </div>
                </c:when>
                <c:otherwise>
                    Não existe histórico registrado.
                </c:otherwise>
            </c:choose>
    </body>
</html>