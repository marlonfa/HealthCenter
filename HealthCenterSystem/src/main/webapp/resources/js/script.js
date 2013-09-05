function abrirPagina(url) {
    window.open(url,"_blank","toolbar=no, location=yes, directories=no, status=no, scrollbars=yes, resizable=yes, width=800, height=600, top=30, left=50");
}

function open(url){

/*Essa funÁ„o Carrega uma p·gina HTML "dentro" de uma div da p·gina HTML. Ela utiliza recursos AJAX para isso.
  Para altera-la, basta substituir o par‚metro na chamada da funÁ„o
  getElementById('ID DA DIV QUE DEVE RECEBER O CONTE⁄DO')*/

	var mreq;
	// Procura o componente nativo do Mozilla/Safari para rodar o AJAX 
	if(window.XMLHttpRequest){
		// Inicializa o Componente XMLHTTP do Mozilla
		mreq = new XMLHttpRequest();
	// Caso ele n„o encontre, procura por uma vers„o ActiveX do IE 
	}else if(window.ActiveXObject){ 
		// Inicializa o Componente ActiveX para o AJAX
		mreq = new ActiveXObject("Microsoft.XMLHTTP");
	}else{ 
		// Caso n„o consiga inicializar nenhum dos componentes, exibe um erro
		alert("Seu navegador n„o tem suporte a AJAX.");
	}

	// Carrega a funÁ„o de execuÁ„o do AJAX
	mreq.onreadystatechange = function() {
		if(mreq.readyState == 1){
			// Quando estiver "Carregando a p·gina", exibe a mensagem
			document.getElementById('div_content').innerHTML = 'carregando';			
		}else if(mreq.readyState == 4){ 
			// Quando estiver completado o Carregamento
			// Procura pela DIV com o id="Content" e insere as informaÁıes 
			document.getElementById('div_content').innerHTML = mreq.responseText;
		}
	};
    // Envia via mÈtodo GET as informaÁıes
    mreq.open("GET",url,true);
    mreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=iso-8859-1") 
    mreq.send(null);
}

