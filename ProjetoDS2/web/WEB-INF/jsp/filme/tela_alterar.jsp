<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
    </head>
    <body>
        <div class="container">
          <form method="post" action="Servlet?controller=filme&method=alterar">
              <input type="hidden" name="idFilme" value="${filme.id}">
              Titulo:<input type="text" name="titulo" value="${filme.titulo}" required><br>
              Genero: <input type="text" name="genero" value="${filme.genero}" required><br>
              Link do trailer:<input type="text" name="trailer" value="${filme.trailer}" required><br>
              Faixa etaria: <input type="number" name="faixaEtaria" value="${filme.faixaEtaria}" min="0" required><br>
              Diretor:<input type="text" name="diretor" value="${filme.diretor}" required><br>
              Duracao(minutos): <input type="number" name="duracao" value="${filme.duracao}" min="0" required><br>
              Sinopse:<input type="text" name="sinopse" value="${filme.sinopse}" required><br>
              <table class="table">
                  <c:forEach items="${filme.elenco}" var="placeholder">
                        <tr><td>Nome ator:<input type="text" name="elenco" value="${placeholder.ator}" required></td><tr>
                            <input type="hidden" name="idElenco" value="${placeholder.id}">
                  </c:forEach>
              </table>
              <input type="submit">
          </form>  
        </div>
         
    </body>
</html>
