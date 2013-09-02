function open(url){

	var mreq;
	// Procura o componente nativo do Mozilla/Safari para rodar o AJAX 
	if(window.XMLHttpRequest){
		// Inicializa o Componente XMLHTTP do Mozilla
		mreq = new XMLHttpRequest();
	// Caso ele nao encontre, procura por uma versao ActiveX do IE 
	}else if(window.ActiveXObject){ 
		// Inicializa o Componente ActiveX para o AJAX
		mreq = new ActiveXObject("Microsoft.XMLHTTP");
	}else{ 
		// Caso nao consiga inicializar nenhum dos componentes, exibe um erro
		alert("Seu navegador não tem suporte a AJAX.");
	}

	// Carrega a funcao de execucao do AJAX
	mreq.onreadystatechange = function() {
		if(mreq.readyState == 1){
			// Quando estiver "Carregando a pagina", exibe a mensagem
			document.getElementById('div_content').innerHTML = 'carregando';			
		}else if(mreq.readyState == 4){ 
			// Quando estiver completado o Carregamento
			// Procura pela DIV com o id="Content" e insere as informacoes 
			document.getElementById('div_content').innerHTML = mreq.responseText;
		}
	};
    // Envia via metodo GET as informacoes
    mreq.open("GET",url,true);
    mreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=iso-8859-1") 
    mreq.send(null);
}

