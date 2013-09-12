$(document).ready(function() {
    var content = $('#div_content');

    //pre carregando o gif
    loading = new Image();
    loading.src = '../imagens/ajax-loader.gif';
    $('#menu a').click(function(e) {
        var arq = pega_arq($(this).attr('href'));
        abre(arq, content);
    });
    /* iniciando com a home */
    abre(pega_arq(document.location.href), content);
});
function abre(href, content) {
    content.html('<img id="loader" src="../imagens/ajax-loader.gif" />');

    $.ajax({
        url: href,
        success: function(response) {
            content.delay(250).hide().html(response).fadeIn();
        }
    });
}
function pega_arq(url) {
    var file = url.split('#');
    return (file[1]) ? file[1] + '.jsp' : 'welcome.jsp';
}

