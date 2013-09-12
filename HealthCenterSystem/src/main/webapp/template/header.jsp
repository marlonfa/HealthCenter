<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<label>Usuário logado:</label><sec:authentication property="name" /><a href="../j_spring_security_logout"><img src="../imagens/exit.png"></a>