<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
          <form method="post" action="Servlet?controller=filme&method=adicionar">
              Titulo:<input type="text" name="titulo"><br>
              Genero: <input type="text" name="genero"><br>
              Link do trailer:<input type="text" name="trailer"><br>
              Faixa etaria: <input type="text" name="faixaEtaria"><br>
              Diretor:<input type="text" name="diretor"><br>
              Duracao(minutos): <input type="text" name="duracao"><br>
              Sinopse:<input type="text" name="sinopse"><br>
              <table id="elenco">
                <tr><td>Nome ator:<input type="text" name="elenco"></td><tr>
              </table>
              <input type="submit">
          </form>  
         <button onclick="addLine()">Adiciona novo ator</button>
    </body>
</html>
