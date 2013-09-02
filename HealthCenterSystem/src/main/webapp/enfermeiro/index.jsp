<%-- 
    Document   : home
    Created on : 23/08/2013, 20:42:41
    Author     : marlon
--%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="../resources/js/ajax.js"></script>
        <title>Health Center</title>
    </head>
    <body>
        
        <div id="div_header">
            <jsp:include page="../template/header.jsp" />
        </div>
        <div id="div_out">
        <div id="div_menu">
            <jsp:include page="../template/menuenf.jsp" />
        </div>
        <div id="div_content">
            INDEX DO USUÁRIO ENFERMEIRO
        </div>
        </div>
        <div id="div_footer">
            <jsp:include page="../template/footer.jsp" />
        </div>
        
    </body>
</html>