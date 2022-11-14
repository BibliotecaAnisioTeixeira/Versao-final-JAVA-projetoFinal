<%@ page import="dao.daoGenero, classes.Genero, java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style>
        
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap');
    
     *{
        padding:0;
        margin:0;
        box-sizing: border-box;
    }
    
    body{
        background:#494949;
    }
    
    .cont{
        display:flex;
        flex-direction:column;
        width:100%;
        height:100vh;
        align-items:center;
        justify-content:center;
    }
    
    .form{
        display:flex;
        flex-direction:column;
        gap:30px;
        justify-content:center;
        align-items:center;
    }
    
    .btn{
        width:300px;
        border-radius:50px;
        height:45px;
        border:none;
        outline:center;
        background:#1e1e1e;
        color:#C7C7C7;
        transition:0.7s;
    }
    
    .btn:hover{
        background:#f0f0f0;
        color:#1e1e1e;
    }
    
    .input{
        border:none;
        outline:none;
        height:45px;
        border-radius:50px;
        padding:10px 15px;
        background:#C7C7C7;
        width: 300px;
        color:#494949;
        font-family: 'Roboto', sans-serif;
        font-weight:500;
    }
    
    </style>
        
        <title>Editar Genero</title>
    </head>
    <body>
        <div class="cont">
         <%
            String id = request.getParameter("id");
            Genero generos = daoGenero.getGeneroById(Integer.parseInt(id));
        %>
        <form action="generoeditar.jsp" method="post" class="form">
            <h3 style="color:#f0f0f0; text-transform: uppercase; font-family: 'Roboto', sans-serif;
 font-weight:500;">Editar Genero Id: <%=generos.getId()%></h3>
            <input type="hidden" name="id" value="<%=generos.getId()%>">
            <input class="input" type="text" name="nome" value="<%=generos.getNome()%>" placeholder="Novo nome" required>    
            <input class="btn" type="submit" value="Editar">
        </form>
            
        </div>
    </body>
</html>