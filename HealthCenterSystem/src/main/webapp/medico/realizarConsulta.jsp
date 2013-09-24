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
            function setConsulta() {

                $.ajax({
                    url: "ConsultaServlet",
                    type: "POST",
//                    data: 'triagem=' + id,
                    data: 'tipoOperacao=' + 'realizarConsulta' + '&sintomas=' + $('#sintomas').val() + '&diagnostico=' + $('#diagnostico').val() +
                            '&prescricao=' + $('#prescricao').val(),
                    complete: mudarPagina
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
            
            function viewHistorico(id){
                 $.ajax({
                    url: "HistoricoClinicoServlet",
                    type: "POST",
                    data: 'historicoId=' + id,
                    complete: callView
                });
            };
            
            function callView(){
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
            <table>
                <tr>
                    <td>Nome:</td>
                    <td>${consulta.triagem.paciente.nome}</td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td>${consulta.triagem.paciente.sexo}</td>
                    <td>Data Nasc.:</td>
                    <td>${consulta.triagem.paciente.dataNascimento}</td>
                </tr>
            </table>

            <label>Triagem</label>

            <table>
                <tr>
                    <td>Altura</td>
                    <td>${consulta.triagem.altura}</td>
                    <td>Peso:</td>
                    <td>${consulta.triagem.peso}</td>
                </tr>
                <tr>
                    <td>Temperatura:</td>
                    <td>${consulta.triagem.temperatura}</td>
                    <td>Pressão Arterial:</td>
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
            
            <label>Histórico Clínico</label>

            <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela">
                <thead>
                    <tr>
                    <tr>
                        <th>Nº</th>
                        <th>Data de Nascimento</th>
                        <th>Sexo</th>
                        <th>Sintomas</th>
                        <th>Realizar Triagem</th>
                    </tr>
                    </tr>
                </thead>
                <tbody>
                    <jsp:useBean id="historicoControle" class="com.fearsoft.healthcenter.controladores.HistoricoClinicoControle"/>  
                    <c:forEach var="historico" items="${historicoControle.findAll()}" step="1" varStatus="row">
                        <c:choose>
                            <c:when test="${row.count % 2 == 0}">
                                <c:set var="estiloLinha" value="even gradeA"  />
                            </c:when>
                            <c:otherwise>
                                <c:set var="estiloLinha" value="odd gradeX"  />
                            </c:otherwise>
                        </c:choose>

                        <c:if test="${consulta.triagem.paciente.id eq historico.idPaciente}" >
                            <tr class="${estiloLinha}">
                                <td >${row.count}</td>
                                <td >${historico.consulta.triagem.dataConsulta}</td>
                                <td >${historico.consulta.triagem.paciente.sexo}</td>
                                <td >${historico.consulta.sintomas}</td>
                                <td><input type="submit" id="visualizar" name="visualizar" value="Visualizar" onclick="viewHistorico(${historico.id});"></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Nº</th>
                        <th>Data de Nascimento</th>
                        <th>Sexo</th>
                        <th>Sintomas</th>
                        <th>Realizar Triagem</th>
                    </tr>
                </tfoot>
            </table>

            <div id="dialog-confirm" title="Realização de Triagem" hidden="true">
                <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Realização de Triagem Efetuada com Sucesso!</p>
            </div>
    </body>
</html>