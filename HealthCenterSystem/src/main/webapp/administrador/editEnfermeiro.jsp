<%-- 
    Document   : cadEnfermeiro
    Created on : 21/08/2013, 15:16:29
    Author     : marlon
--%>

<%@page import="com.fearsoft.healthcenter.controladores.EnfermeiroControle"%>
<%@page import="com.fearsoft.healthcenter.enums.EstadoCivil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
         <link href="../resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />
         
         <script type="text/javascript" src="../resources/js/jquery.min.js"></script>
         <script type="text/javascript" src="../resources/js/jquery-ui.js"></script>
         <script type="text/javascript" src="../resources/js/jQueryValidate.js"></script>
         <script type="text/javascript" src="../resources/js/jQueryValidaCPJeCNPJ.js"></script>
         <script type="text/javascript" src="../resources/js/jquery.maskedinput.min.js"></script>
        <script type="text/javascript" src="../resources/js/jquery.colorbox-min.js"></script>

<script>
    var validador;
    
    
    
    $.validator.setDefaults({
  submitHandler: function() { 
      cadEnfermeiro();
        }
}); 
    
    //Função para Colocar Máscaras nos campos
    $(function() {
        $.mask.definitions['~'] = "[+-]";
        $("#dataNascimento").mask("99/99/9999");
        $("#cpf").mask("999.999.999-99");
        $("#rg").mask("99.999.999-9");
        $("#cep").mask("99999-999");
        $("#telefone").mask("(99) 9999-9999");
        $("#celular").mask("(99) 9999-9999?9");
    });
    
    //Função para fazer validação nos campos
    $().ready(function(){
       
	validador = $("#form").validate({
            errorLabelContainer: $('#div_mensagens'),
		rules: {
                    nome: {required: true, minlength: 6, maxlength: 100},
                    naturalidade: {required: true, minlength: 6, maxlength: 30},
                    dataNascimento: {required: true, minlength: 10, maxlength: 10},
                    //CPF não precisa pois usa o plugin jQueryValidaCPFeCPNPJ
                    //cpf: {required: true, minlength: 14, maxlength: 14},
                    cpf: {cpf: 'both'},
                    rg: {required: true, minlength: 12, maxlength: 12},
                    coren: {required: true, minlength: 6, maxlength: 20},
                    nomeEndereco: {required: true, minlength: 6, maxlength: 60},
                    numeroEndereco: {required: true, minlength: 1, maxlength: 6, number: true},
                    //complemento: {required: false, minlngth: 3, maxlength: 30},
                    bairro: {required: true, minlength: 6, maxlength: 30},
                    cidade: {required: true, minlength: 6, maxlength: 50},
                    cep: {required: true, minlength: 9, maxlength: 9},
                    //telefone:{required: false, minlength: 10, maxlength: 10},
                    calular:{notEqual: "#telefone"},
                    //celular: {required: false, minlength: 10, maxlength: 11},
                    email: {required: false, minlength: 5, maxlength: 40, email: true},
                    senha: {required: true, minlength: 6, maxlength: 6},
                    repetirSenha: {required: true, minlength: 6, maxlength: 6, equalTo: "#senha"}                 
            },
            messages: {
                nome: {required: "Digite um nome. Ex: João da Silva", minlength: "O nome deve ter no mínimo 6 dígitos", maxlength: "O nome deve ter no máximo 100 dígitos"},
                naturalidade: {required: "Digite uma naturalidade. Ex: Brasileiro", minlength: "Naturalidade deve ter no mínimo 6 dígitos ", maxlength: "O nome deve ter no máximo 30 dígitos"},
                dataNascimento: {required: "Digite uma data de Nascimento. Ex: 18/10/1987", minlength: "Data ne nascimento deve ter no mínimo 8 dígitos ", maxlength: "Data ne nascimento deve ter no máximo 8 dígitos"},
                //CPF não precisa pois usa o plugin jQueryValidaCPFeCPNPJ
                //cpf: {required: "Digite um CPF. Ex: 123.456.789-10", minlength: "CPF deve ter no mínimo 11 dígitos ", maxlength: "CPF deve ter no máximo 11 dígitos"},
                rg: {required: "Digite um RG. Ex: 12.345.678-9", minlength: "RG deve ter no mínimo 9 dígitos ", maxlength: "RG deve ter no máximo 9 dígitos"},
                coren: {required: "Digite um COREN. Ex: 123456789", minlength: "COREN deve ter no mínimo 6 dígitos ", maxlength: "COREN deve ter no máximo 20 dígitos"},
                nomeEndereco: {required: "Digite um endereço. Ex: Rua Getúlio Vargas", minlength: "Endereço deve ter no mínimo 6 dígitos ", maxlength: "Endereço deve ter no máximo 50 dígitos"},
                numeroEndereco: {required: "Digite um número. Ex: 1234", minlength: "Número deve ter no mínimo 1 dígitos ", maxlength: "Número deve ter no máximo 6 dígitos", number: "Digite somente números"},
                //complemento: {required: "Opcional", minlength: "Complemento deve ter no mínimo 3 dígitos", maxlength: "Complemento deve ter no máximo 30 dígitos"},
                bairro: {required: "Digite um bairro. Ex: Vila Copacabana", minlength: "Bairro deve ter no mínimo 6 dígitos ", maxlength: "Bairro deve ter no máximo 30 dígitos"},
                cidade: {required: "Digite uma cidade. Ex: Campo Mourão", minlength: "Cidade deve ter no mínimo 6 dígitos ", maxlength: "Cidade deve ter no máximo 50 dígitos"},
                cep: {required: "Digite um CEP. Ex: 12345-678", minlength: "CEP deve ter no mínimo 8 dígitos ", maxlength: "CEP deve ter no máximo 8 dígitos"},
                //telefone:{minlength: "Telefone deve ter no mínimo 10 dígitos", maxlength: "Telefone deve ter no máximo 10 dígitos"},
                celular:{notEqual: "Opcional. Mas deve ser diferente do número do Telefone"},
                //celular: {minlength: "Celular deve ter no mínimo 10 dígitos", maxlength: "Celular deve ter no máximo 11 dígitos"},
                email: {email: "e-mail inválido", minlength: "O e-mail deve ter no mínimo 5 dígitos", maxlength: "O e-mail deve ter no máximo 40 dígitos"},
                senha: {required: "Digite uma senha", minlength: "Sua senha deve conter 6 caracteres no mínimo", maxlength: "Sua senha deve conter no máximo 6 caracteres"},
                repetirSenha: {required: "Confirme sua senha", minlength: "Sua senha deve conter 6 caracteres no mínimo.", maxlength: "Sua senha deve conter no máximo 6 caracteres", equalTo: "Senha digita é diferente da anterior"}
                
            }
            
             
        });
         $("#form").validate();
    });
 
function cadEnfermeiro(){
            $.ajax({
            url: "EnfermeiroServlet",  
            type: "POST",  
            data: 'nome='+ $('#nome').val() +'&naturalidade='+ $('#naturalidade').val() + 
                  '&dataNascimento='+ $('#dataNascimento').val() +'&sexo='+ $('#sexo').val() +'&estadoCivil='+ $('#estadoCivil').val() + 
                  '&cpf='+ $('#cpf').val() +'&rg='+ $('#rg').val() +'&coren='+ $('#coren').val() +'&nomeEndereco='+ $('#nomeEndereco').val() +
                  '&numeroEndereco='+ $('#numeroEndereco').val() +'&complemento='+ $('#complemento').val() +'&bairro='+ $('#bairro').val() +
                  '&cidade='+ $('#cidade').val() +'&cep='+ $('#cep').val() +'&telefone='+ $('#telefone').val() +'&celular='+ $('#celular').val() +
                  '&email='+ $('#email').val() +'&senha='+ $('#senha').val() +'&tipoOperacao='+ $('#operacao').val(),
          complete: callDialog
        }); 
}

function callDialog(){
$("#dialog-message" ).dialog({
      modal: true,
      buttons: {
        Ok: function() {
          $( this ).dialog( "close" );
          callView();
        }
      }
    });
} 
function callView(){
            $.colorbox({ 
                href: "viewEnfermeiro.jsp",
                overlayClose: false 
            });
        }
</script>
        <title>Health Center - Cadastro de Enfermeiro</title>
    </head>
    <body>
        <h1>Edição de Enfermeiro</h1>
           <div id="div_mensagens" ></div>
        <div id="content">
            <form id="form">
              
                    <table>
                        <tr>
                            <td colspan="8">
                                <h2>Dados Pessoais</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Nome:</label>
                            </td>
                            <td colspan="7"> 
                                <input type="text" id="nome" name="nome" placeholder="Digite aqui o nome do Enfermeiro" size="150" value="${enfermeiro.nome}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td>
                                <input type="text" id="naturalidade" name="naturalidade" size="20" placeholder="Digite a naturalidade" value="${enfermeiro.naturalidade}" />
                            </td>
                            <td>
                                <label>Data Nasc.:</label>
                            </td>
                            <td>
                                <input type="text" id="dataNascimento" name="dataNascimento" size="20" placeholder="__/__/____" value="${enfermeiro.dataNascimento}" />
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td>
                                <input type="radio" name="sex" value="masculino" checked="">Masc.
                                <input type="radio" name="sex" value="feminino">Fem.
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Estado Civil:</label>
                            </td>
                            <td>
                                <c:set var="estadoCivilValues" value="<%=EstadoCivil.values()%>"/>
                                <select id="estadoCivil" name="estadoCivil">
                                    <option value="${enfermeiro.estadoCivil}">${enfermeiro.estadoCivil}</option>
                                    <c:forEach items="${estadoCivilValues}" var="estadoCivil">
                                        <option value="${estadoCivil}" >${estadoCivil.getEstadoCivil()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td>
                                <input type="text" id="cpf" name="cpf" size="20" placeholder="___.___.___-__" value="${enfermeiro.cpf}" />
                            </td>
                            <td>
                                <label>RG:</label>
                            </td>
                            <td>
                                <input type="text" id="rg" name="rg" size="20" placeholder="__.___.___-_" value="${enfermeiro.rg}" />
                            </td>
                            <td>
                                <label>COREN:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" id="coren" name="coren" size="20" placeholder="Digite a COREN" value="${enfermeiro.coren}" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="8">
                                <h2>Endereço</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Endereço:</label>
                            </td>
                            <td colspan="7"> 
                                <input type="text" id="nomeEndereco" name="nomeEndereco" placeholder="Digite aqui o endereço do Enfermeiro" size="140" value="${enfermeiro.endereco.nomeEndereco}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Número:</label>
                            </td>
                            <td>
                                <input type="text" id="numeroEndereco" name="numeroEndereco" placeholder="Número" size="20" value="${enfermeiro.endereco.numero}" />
                            </td>
                            <td>
                                <label>Complemento:</label>
                            </td>
                            <td>
                                <input type="text" id="complemento" name="complemento" placeholder="Complemento" size="20" maxlength="30" value="${enfermeiro.endereco.complemento}" />
                            </td>
                            <td>
                                <label>Bairro:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" id="bairro" name="bairro" placeholder="Digite o nome do Bairro" size="20" value="${enfermeiro.endereco.bairro}"  />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Cidade:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" id="cidade" name="cidade" placeholder="Digite o nome da cidade" size="70" value="${enfermeiro.endereco.cidade}" />
                            </td>
                            <td>
                                <label>CEP:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" id="cep" name="cep" placeholder="_____-___" size="20" value="${enfermeiro.endereco.cep}" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="8">
                                <h2>Contato</h2>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Tel. Residencial:</label>
                            </td>
                            <td>
                                <input type="text" id="telefone" name="telefone" placeholder="(__)____-____" size="20" value="${enfermeiro.contato.telefone}" />
                            </td>
                            <td>
                                <label>Celular:</label>
                            </td>
                            <td>
                                <input type="text" id="celular" name="celular" placeholder="(__)____-____" size="20" value="${enfermeiro.contato.celular}" />
                            </td>
                            <td>
                                <label>Email:</label>
                            </td>
                            <td colspan="3">
                                <input type="text" id="email" name="email" placeholder="email@email.com" size="40" value="${enfermeiro.contato.email}" />
                            </td>
                        </tr>
                        
                        <tr>
                            <td colspan="8">
                                <h2>Cadastro de Senha para Acesso do Sistema</h2>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <label>Senha:</label>
                            </td>
                            <td colspan="7">
                                <input type="password" id="senha" name="senha" placeholder="******" size="20" value="${enfermeiro.usuario.password}" />
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <label>Repetir:</label>
                            </td>
                            <td colspan="7">
                                <input type="password" id="repetirSenha" name="repetirSenha" placeholder="******" size="20" value="${enfermeiro.usuario.password}" />
                            </td>
                        </tr>
                        <input type="hidden" name="tipoOperacao" value="editEnfermeiro2" id="operacao">
                    </table>
                            <input class="submit" type="submit" value="Salvar" >
                            </form>
            </div>
                            </div>
                                <div id="dialog-message" title="Edição" hidden="true">
                <p>
                    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
                        Edição Efetuada com Sucesso!!!
                </p>
              </div>
    </body>
</html>
