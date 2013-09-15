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
    var oTable;
            $(document).ready( function () {
              oTable  = $('#tabela').dataTable( {
                        "bScrollCollapse": true,
                        "bPaginate": true,
                        "bJQueryUI": true
                });
        } );
        
        function removeMedico(medicoId){
            $( "#dialog-confirm" ).dialog({
                resizable: false,
                height:140,
                modal: true,
                buttons: {
                  "Remover": function() {
                    $.ajax({
                        url: "MedicoServlet",  
                        type: "POST",
                        data: 'id='+ medicoId +'&tipoOperacao='+ 'removeMedico',
                        complete: refreshTable
                    });
                     $( this ).dialog( "close" );
                  },
                  "Cancelar": function() {
                    $( this ).dialog( "close" );
                  }
                }
            });
        };
        
        function edit(medicoId){
            $.ajax({
                url: "MedicoServlet",  
                type: "POST",
                data: 'id='+ medicoId +'&tipoOperacao='+ 'editMedico'
//                complete: callEdit
            }); 
            callEdit();           
        };
        
        function view(medicoId){
            $.ajax({
                url: "MedicoServlet",  
                type: "POST",
                data: 'id='+ medicoId +'&tipoOperacao='+ 'viewMedico',
                complete: callView 
            }); 
            
        };
        function callView(){
            $.colorbox({ 
                href: "viewMedico.jsp",
                overlayClose: false 
            });
        }
        
        function callEdit(){
            $('#div_content').load('editMedico.jsp').delay(250).hide().fadeIn();
        }
        
        function refreshTable(){
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
                        <th>Visualizar</th>
                        <th>Editar</th>
                        <th>Remover</th>
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
                        <td id="remove" ><button id="view" onclick="view(${medico.id});">Visualizar</button></td>
                        <td id="remove" ><button id="edit" class="edit" onclick="edit(${medico.id});" abrir="#editMedico">Editar</button></td>
                        <td id="remove" ><button id="removeMedico" onclick="removeMedico(${medico.id});">Remover</button></td>
		</tr>
                </c:forEach>
                </tbody>
	<tfoot>
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>CRM</th>
			<th>Especialização</th>
                        <th>Visualizar</th>
                        <th>Editar</th>
                        <th>Remover</th>
		</tr>
	</tfoot>
</table>
                   
        </div>
             <div id="dialog-confirm" title="Deseja Realmente Excluir este Registro?" hidden="true">
            <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Se você clicar em Remover, o Registro Selecionado Será Removido Permanentemente.</p>
        </div>
    </body>
</html>
