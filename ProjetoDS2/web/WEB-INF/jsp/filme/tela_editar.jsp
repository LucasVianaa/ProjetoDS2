<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form method="post" action="Servlet?controller=filme&method=editar">
              Nome:<input type="text" name="nome" value="${pessoa.nome}">
              Sobrenome: <input type="text" name="sobrenome" value="${pessoa.sobrenome}">
              <input type="hidden" name="id" value="${pessoa.id}">
              <input type="submit">
          </form>  
    </body>
</html>
