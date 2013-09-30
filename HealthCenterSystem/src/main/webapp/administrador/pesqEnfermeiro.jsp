<%-- 
    Document   : cadEnfermeiro
    Created on : 21/08/2013, 15:16:29
    Author     : marlon
--%>
<%@page import="java.util.List"%>
<%@page import="com.fearsoft.healthcenter.controladores.EnfermeiroControle"%>
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
        
        function removeEnfermeiro(enfermeiroId){
            $( "#dialog-confirm" ).dialog({
                resizable: false,
                height:140,
                modal: true,
                buttons: {
                  "Remover": function() {
                    $.ajax({
                        url: "EnfermeiroServlet",  
                        type: "POST",
                        data: 'id='+ enfermeiroId +'&tipoOperacao='+ 'removeEnfermeiro',
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
        
        function edit(enfermeiroId){
            $.ajax({
                url: "EnfermeiroServlet",  
                type: "POST",
                data: 'id='+ enfermeiroId +'&tipoOperacao='+ 'editEnfermeiro'
//                complete: callEdit
            }); 
            callEdit();           
        };
        
        function view(enfermeiroId){
            $.ajax({
                url: "EnfermeiroServlet",  
                type: "POST",
                data: 'id='+ enfermeiroId +'&tipoOperacao='+ 'viewEnfermeiro',
                complete: callView 
            }); 
            
        };
        function callView(){
            $.colorbox({ 
                href: "viewEnfermeiro.jsp",
                overlayClose: false 
            });
        }
        
        function callEdit(){
            $('#div_content').load('editEnfermeiro.jsp').delay(250).hide().fadeIn();
        }
        
        function refreshTable(){
            location.reload();
        }
</script>
    </head>
    <body>
        <h1>Pesquisa de Enfermeiro</h1>
        <div id="content">
            <table cellpadding="0" cellspacing="0" border="0" class="display" id="tabela">
	<thead>
		<tr>
			<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>COREN</th>
                        <th>Visualizar</th>
                        <th>Editar</th>
                        <th>Remover</th>
		</tr>
		</tr>
	</thead>
	<tbody>
             <jsp:useBean id="enfermeiroControle" class="com.fearsoft.healthcenter.controladores.EnfermeiroControle"/>  
             <c:forEach var="enfermeiro" items="${enfermeiroControle.findAll()}" step="1" varStatus="row">
                <c:choose>
                    <c:when test="${row.count % 2 == 0}">
                            <c:set var="estiloLinha" value="even gradeA"  />
                        </c:when>
                        <c:otherwise>
                            <c:set var="estiloLinha" value="even gradeC"  />
                        </c:otherwise>
                </c:choose>
		<tr class="${estiloLinha}">
			<td >${enfermeiro.nome}</td>
			<td class="realizarConsulta">${enfermeiro.cpf}</td>
			<td class="realizarConsulta">${enfermeiro.coren}</td>
                        <td class="realizarConsulta" id="remove" ><button id="view" onclick="view(${enfermeiro.id});">Visualizar</button></td>
                        <td class="realizarConsulta" id="remove" ><button id="edit" class="edit" onclick="edit(${enfermeiro.id});" abrir="#editEnfermeiro">Editar</button></td>
                        <td class="realizarConsulta" id="remove" ><button id="removeEnfermeiro" onclick="removeEnfermeiro(${enfermeiro.id});">Remover</button></td>
		</tr>
                </c:forEach>
                </tbody>
	<tfoot>
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>COREN</th>
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
