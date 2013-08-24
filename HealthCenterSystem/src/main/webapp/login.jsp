<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css">
        <title>Health Center - Login</title>
    </head>
    <body>
        <div id="content">
            <div style="width: 240px; margin-left: auto; margin-right: auto; margin-top: 150px">
                <h1>Health Center</h1>

                <form id="frm" action="" method="post">
                    <table>
                        <tr>
                            <td>
                                <label>Usuário:</label>
                            </td>
                            <td>
                                <input type="text" value="" name="usuario" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Senha:</label>
                            </td>
                            <td>
                                <input type="password" value="" size="20"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input id="btnLogin" type="submit" value="Entrar"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
