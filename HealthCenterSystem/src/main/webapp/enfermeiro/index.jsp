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
        <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
        <link href="../resources/css/colorbox.css" rel="stylesheet" type="text/css" />
        
        <script type="text/javascript" src="../resources/js/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../resources/js/jQueryDynamicContent.js"></script>
        <script type="text/javascript" src="../resources/js/jquery.colorbox-min.js"></script>
        
    </head>
    <body>
        
        <div id="div_header">
            <jsp:include page="../template/header.jsp" />
        </div>
        <div id="div_logo">
            
        </div>
        <div id="div_menu">
            <jsp:include page="../template/menuenf.jsp" />
        </div>
        
        <div id="div_content">
           
            
        </div>
        <div id="div_footer">
            <jsp:include page="../template/footer.jsp" />
        </div>
    </body>
</html>