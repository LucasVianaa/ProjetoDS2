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
                       <td> <a href="Servlet?controller=sessao&method=tela_alterar&id=${sessao.id}">Editar</a></td>
                       <td> <a href="Servlet?controller=sessao&method=excluir&id=${sessao.id}">Remover</a></td>
                   </tr>            
               </c:forEach>
           </table>
            <a href="Servlet?controller=sessao&method=tela_adicionar">Adicionar sessao</a>
            <br>
            
            <table class = "table">
               <c:forEach items="${vetFilmes}" var="filme">
                   <tr>
                       <td>${filme.sinopse}</td>
                       <td>${filme.titulo}</td>
                       <td> <a href="Servlet?controller=filme&method=tela_alterar&id=${filme.id}">Editar</a></td>
                       <td> <a href="Servlet?controller=filme&method=excluir&id=${filme.id}">Remover</a></td>
                   </tr>            
               </c:forEach>
           </table>
            <a href="Servlet?controller=filme&method=tela_adicionar">Adicionar filme</a>
        </div>
    </body>
</html>
