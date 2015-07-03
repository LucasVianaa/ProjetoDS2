
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    </head>
    <body>
         <div class="container">
            <table class = "table">
                <tr>
                    <th>Sala</th>
                    <th>Filme</th>
                    <th>Data Inicio</th>
                    <th>Fim</th>
                    <th>Preco adulto</th>
                    <th>Preco estudante</th>
                    <th>Preco idoso</th>
                    <th>3d</th>
                    <th>Legendado/dublado</th>
                    
                </tr>
               <c:forEach items="${vetSessoes}" var="sessao" varStatus="i">
                   <tr>
                       <td>${sessao.sala}</td>
                       <td>${sessao.filme.titulo}</td>
                       <td>${dataInicio.get(i.index)}<br>${horaInicio.get(i.index)}</td>
                       <td>${dataFim.get(i.index)}<br>${horaFim.get(i.index)}</td>
                       <td>${sessao.precoAdulto}</td>
                       <td>${sessao.precoEstudante}</td>
                       <td>${sessao.precoIdoso}</td>
                        <c:choose>    
                            <c:when test="${sessao.its3d==true}">
                             <td>Sim</td>
                            </c:when>
                             <c:otherwise>
                             <td>Nao</td>
                             </c:otherwise>
                       </c:choose>
                      <c:choose>    
                            <c:when test="${sessao.itsLegendado==true}">
                             <td>Legendado</td>
                            </c:when>
                             <c:otherwise>
                             <td>Dublado</td>
                             </c:otherwise>
                       </c:choose>
                   </tr>            
               </c:forEach>
           </table>
        </div>   
    </body>
</html>
