<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Cadastrar Usuários</title>
<meta charset="UTF-8">

<style>
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
    
    .select{
        display: flex;
        gap:25px;
    }
    
</style>

</head>
<body>
    <div class="cont">
        <%@include file="acessoadm.jsp"%>
    
	<form action="usuariocadastrar.jsp" method="post" class="form">
	<h3 style="color:#f0f0f0; text-transform: uppercase; font-family: 'Roboto', sans-serif;
 font-weight:500;">Cadastrar Usuários</h3>
	<input class="input" type="text" name="nome" placeholder="Seu nome..." required>		
	<input class="input" type="email" name="email" placeholder="Seu e-mail..." required>
	<input class="input" type="password" name="senha" placeholder="Sua senha..." pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="A senha deve conter pelo menos um caracter maiúsculo, um minúsculo, um número e no mínimo oito caracteres" required>	
        <div class="select">
            <input type="radio" name="acesso" value="Comum" required><label>Comum</label>
            <input type="radio" name="acesso" value="Admin"><label>Admin</label>	
        </div>    
	<input class="btn" type="submit" value="Enviar">
	</form>
    </div>>
</body>
</html>
