<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form method="post" action="Servlet?controller=sessao&method=alterar">
           

             Hora inicio:<input type="date" name="data" value="${data}"><input type="time" name="hora" value="${hora}"> <br>
             <input type="hidden" name="id" value="${sessao.id}">
             Filme:<select name ="filme">
                <c:forEach items="${filmes}" var="placeholder">
                    <c:choose> 
                        <c:when test="${sessao.filme.id==placeholder.id}">
                            <option value="${placeholder.id}" selected>${placeholder.titulo}</option> 
                        </c:when>
                        <c:otherwise>
                            <option value="${placeholder.id}">${placeholder.titulo}</option> 
                        </c:otherwise>
                    </c:choose>
                    
                </c:forEach>
              </select><br>
              Preco para adulto:<input type="number" name="precoAdulto" step="0.01" min="0" value="${sessao.precoAdulto}"><br>
              Preco para estudante:<input type="number" name="precoEstudante" step="0.01" min="0" value="${sessao.precoEstudante}"><br>
              Preco para idoso:<input type="number" name="precoIdoso" step="0.01" min="0" value="${sessao.precoIdoso}"><br>
              Sala:<input type="number" name="sala" min="1" value="${sessao.sala}"><br>
              
              3D: 
              <c:choose>    
                   <c:when test="${sessao.its3d==true}">
                    <input type="radio" name="3d" value="true" checked>Sim
                    <input type="radio" name="3d" value="false">Nao<br>
                   </c:when>
                    <c:otherwise>
                        <input type="radio" name="3d" value="true">Sim
                        <input type="radio" name="3d" value="false" checked>Nao<br>
                    </c:otherwise>
              </c:choose>
                    
              Legendado:
              <c:choose>    
                   <c:when test="${sessao.itsLegendado==true}">
                    <input type="radio" name="legendado" value="true" checked>Sim
                    <input type="radio" name="legendado" value="false">Nao<br>
                   </c:when>
                    <c:otherwise>
                        <input type="radio" name="legendado" value="true">Sim
                        <input type="radio" name="legendado" value="false" checked>Nao<br>
                    </c:otherwise>
              </c:choose>
              
              <input type="submit">
        </form>  
    </body>
</html>
