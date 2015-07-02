<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function addLine() {
                var table = document.getElementById("elenco");
                var row = table.insertRow(0);
                var cell1 = row.insertCell(0);
                cell1.innerHTML = "Nome ator:<input type=\"text\" name=\"elenco\">";

            }
        </script>
    </head>
    <body>
        <c:out value="${filme.elenco}" />
          <form method="post" action="Servlet?controller=filme&method=alterar">
              <input type="hidden" name="idFilme" value="${filme.id}">
              Titulo:<input type="text" name="titulo" value="${filme.titulo}"><br>
              Genero: <input type="text" name="genero" value="${filme.genero}"><br>
              Link do trailer:<input type="text" name="trailer" value="${filme.trailer}"><br>
              Faixa etaria: <input type="text" name="faixaEtaria" value="${filme.faixaEtaria}"><br>
              Diretor:<input type="text" name="diretor" value="${filme.diretor}"><br>
              Duracao(minutos): <input type="text" name="duracao" value="${filme.duracao}"><br>
              Sinopse:<input type="text" name="sinopse" value="${filme.sinopse}"><br>
              <table id="elenco">
                  <c:forEach items="${filme.elenco}" var="placeholder">
                        <tr><td>Nome ator:<input type="text" name="elenco" value="${placeholder.ator}"></td><tr>
                            <input type="hidden" name="idElenco" value="${placeholder.id}">
                  </c:forEach>
              </table>
              <input type="submit">
          </form>  
         <button onclick="addLine()">Adiciona novo ator</button>
    </body>
</html>
