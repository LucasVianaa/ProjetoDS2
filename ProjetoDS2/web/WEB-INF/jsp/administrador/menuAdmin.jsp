<%-- 
    Document   : menuAdmin
    Created on : 01/07/2015, 21:11:08
    Author     : Thiago
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <table class = "table">
               <c:forEach items="${vetSessoes}" var="sessao">
                   <tr>
                       <td>${sessao.sala}</td>
                       <td>${sessao.filme.titulo}</td>
                   </tr>            
               </c:forEach>
           </table>
            
            <br>
            
            <table class = "table">
               <c:forEach items="${vetFilmes}" var="filme">
                   <tr>
                       <td>${filme.sinopse}</td>
                       <td>${filme.titulo}</td>
                   </tr>            
               </c:forEach>
           </table>
        </div>
    </body>
</html>
