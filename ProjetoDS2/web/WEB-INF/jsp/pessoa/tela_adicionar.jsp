<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form method="post" action="Servlet?controller=pessoa&method=adicionar">
              Nome:<input type="text" name="nome">
              Sobrenome: <input type="text" name="sobrenome">
              <input type="submit">
          </form>  
    </body>
</html>
