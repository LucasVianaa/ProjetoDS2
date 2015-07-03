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
    
                <div class="row">
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
                            <th>Editar</th>
                            <th>Remover</th>
                        </tr>
                       <c:forEach items="${vetSessoes}" var="sessao">
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
                               <td> <a href="Servlet?controller=sessao&method=tela_alterar&id=${sessao.id}">Editar</a></td>
                               <td> <a href="Servlet?controller=sessao&method=excluir&id=${sessao.id}">Remover</a></td>
                           </tr>            
                       </c:forEach>
                   </table>
                
                    <a href="Servlet?controller=sessao&method=tela_adicionar">Adicionar sessao</a>
                </div>
            
            <br>
                <div class="row">

                        <table class = "table">
                            <tr>
                                <th>Sinopse</th>
                                <th>Titulo</th>
                                <th>Faixa etaria</th>
                                <th>Trailer</th>
                                <th>Duracao</th>
                                <th>Diretor</th>
                                <th>Genero</th>
                                <th>Editar</th>
                                <th>Remover</th>
                            </tr>
                            <c:forEach items="${vetFilmes}" var="filme">
                                <tr>
                                    <td>${filme.sinopse}</td>
                                    <td>${filme.titulo}</td>
                                    <td>${filme.faixaEtaria}+</td>
                                    <td>${filme.trailer}</td>
                                    <td>${filme.duracao}</td>
                                    <td>${filme.diretor}</td>
                                    <td>${filme.genero}</td>
                                    <td> <a href="Servlet?controller=filme&method=tela_alterar&id=${filme.id}">Editar</a></td>
                                    <td> <a href="Servlet?controller=filme&method=excluir&id=${filme.id}">Remover</a></td>
                                </tr>            
                            </c:forEach>
                        </table>

                         <a href="Servlet?controller=filme&method=tela_adicionar">Adicionar filme</a>
                </div>
            
                <a href="Servlet?controller=administrador&method=logout">Logout</a>
        </div>
    </body>
</html>
