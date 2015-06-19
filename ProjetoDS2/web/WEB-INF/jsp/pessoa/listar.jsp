<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Importar CSS e JS -->
        <link href="${pageContext.request.contextPath}/css/css_example.css" rel="stylesheet"/> 
        <script src="${pageContext.request.contextPath}/js/js_example.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <!-- Exemplo - Chamada Ajax -->
        <script>
            $(document).ready(function () {
                $('#submit').click(function (event) {
                    var username = $('#user').val();
                    $.post('Servlet?controller=pessoa&method=search', {user: username}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>
    </head>
    <body>
        <!-- exemplo de imgs -->
        <img src="${pageContext.request.contextPath}/imgs/pesquisar-gifs-google-imagem.gif" width="200px" height="100px">
        <!-- Exemplo Ajax -->
        <h1>AJAX Demo (usando Jquery / JSP e Servlet) </h1>
        <h2>Busque Pessoas: </h2>
        Entre o nome de uma pessoa: 
        <input type="text" id="user"/>
        <input type="button" id="submit" value="Ajax Submit"/>
        <br/>
        <div id="welcometext">  </div>
        <hr>
        <!-- Exemplo de Listagem -->
        <table>
            <c:forEach items="${vetPessoa}" var="pessoa">
                <tr>
                    <td> <a href="Servlet?controller=pessoa&method=tela_editar&id=${pessoa.id}">Editar</a></td>
                    <td> <a href="Servlet?controller=pessoa&method=excluir&id=${pessoa.id}">Remover</a></td>
                    <td>${pessoa.nome}</td> 
                    <td>${pessoa.sobrenome}</td>              
                </tr>            
            </c:forEach>
        </table>     
    </body>
</html>
