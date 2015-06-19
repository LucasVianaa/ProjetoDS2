<%@page import="model.Pessoa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            PessoaDAO pessoaDAO = new PessoaDAO();
            ArrayList<Pessoa> vetPessoa = pessoaDAO.listar();
        %>    
        <table>
            <% for (int i = 0; i < vetPessoa.size(); i++) {%>
            <tr>
                <td> <%= vetPessoa.get(i).getNome()%> </td>
                <td> <%= vetPessoa.get(i).getSobrenome()%> </td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
