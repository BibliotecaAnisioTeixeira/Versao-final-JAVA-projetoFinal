<html>
<head>
<title>G�nero Cadastrar</title>
<meta charset="UTF-8">
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
	<form action="generocadastrar.jsp" method="post" class="form">
	<h3 style="color:#f0f0f0; text-transform: uppercase; font-family: 'Roboto', sans-serif;
 font-weight:500;">Cadastrar G�neros</h3>
	<input class="input" type="text" name="nome" placeholder="Nome do G�nero" required>		
	<input class="btn" type="submit" value="Enviar">
	</form>
    </div>    
</body>
</html>
