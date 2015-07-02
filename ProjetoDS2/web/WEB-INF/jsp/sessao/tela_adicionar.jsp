<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--
            id serial NOT NULL,
            hora_inicio timestamp without time zone,
            hora_fim timestamp without time zone,
            id_filme integer,
            preco_adulto numeric,
            preco_estudante numeric,
            preco_idoso numeric,
            sala integer,
            its3d boolean,
            itslegendado boolean,
        
        --%>
        
        <form method="post" action="Servlet?controller=sessao&method=adicionar">
              Hora inicio:<input type="date" name="data"><input type="time" name="hora"> <br>
              
              Filme:<select name ="filme">
                <c:forEach items="${filmes}" var="filme">
                    <option value="${filme.id}">${filme.titulo}</option> 
                </c:forEach>
              </select><br>
              Preco para adulto:<input type="number" name="precoAdulto" step="0.01" min="0"><br>
              Preco para estudante:<input type="number" name="precoEstudante" step="0.01" min="0"><br>
              Preco para idoso:<input type="number" name="precoIdoso" step="0.01" min="0"><br>
              Sala:<input type="number" name="sala" min="1"><br>
              3D:<input type="radio" name="3d" value="true" checked>Sim<br>
                 <input type="radio" name="3d" value="false">Nao<br>
              Legendado:<input type="radio" name="legendado" value="true" checked>Sim<br>
                        <input type="radio" name="legendado" value="false">Nao<br>
              
              <input type="submit">
        </form>  
    </body>
</html>
