<%@ page import="dao.daoAutor, classes.Autor, java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Autor</title>
        
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
        
    </head>
    <body>
        <div class="cont">
            <%
                String id = request.getParameter("id");
                Autor autor = daoAutor.getAutorById(Integer.parseInt(id));
            %>
            <form action="autoreditar.jsp" method="post" class="form">
                <h3 style="color:#f0f0f0; text-transform: uppercase; font-family: 'Roboto', sans-serif;
 font-weight:500;">Editar Autor<br>Id: <%=autor.getId()%></h3>
                <input type="hidden" name="id" value="<%=autor.getId()%>">
                <input class="input" type="text" name="nome" value="<%=autor.getNome()%>" placeholder="Novo nome" required>    
                <input class="btn" type="submit" value="Editar">
            </form>
        </div>
    </body>
</html>
