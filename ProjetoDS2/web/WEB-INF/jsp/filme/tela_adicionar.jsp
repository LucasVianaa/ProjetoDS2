<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
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
        <div class="container">
            <form method="post" action="Servlet?controller=filme&method=adicionar" role="form">

                  Titulo:<input type="text" name="titulo" required><br>
                  Genero: <input type="text" name="genero" required><br>
                  Link do trailer:<input type="text" name="trailer" required><br>
                  Faixa etaria: <input type="number" name="faixaEtaria" min="0" required><br>
                  Diretor:<input type="text" name="diretor" required><br>
                  Duracao(minutos): <input type="number" name="duracao" min="0" required><br>
                  Sinopse:<input type="text" name="sinopse" required><br>
                  <table id="elenco">
                    <tr><td>Nome ator:<input type="text" name="elenco" required></td><tr>
                  </table>
                  <input type="submit">
              </form>  
             <button onclick="addLine()">Adiciona novo ator</button>
        </div>
    </body>
</html>