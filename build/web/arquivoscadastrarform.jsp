<html>
<head>
<title>Cadastro dos Arquivos</title>
<meta charset="UTF-8">

<style>
    
    *{
        padding:0;
        margin:0;
        box-sizing: border-box;
    }
    
    body{
        background:#1e1e1e;
    }
    
    .container{
        width:100%;
        display:flex;
        flex-direction:column;
        height:100vh;
        align-items: center;
        justify-content:center;
    }
    
    .form{
        display:flex;
        flex-direction: column;
        justify-content:center;
        gap:25px;
        align-items: center;
    }
    
    .btn{
        border: none;
        outline:none;
        background:#c7c7c7;
        color:#444;
        height:45px;
        border-radius:35px;
        width:250px;
    }
    
    input[type="file"] {
    display: none;
}

 label {
    padding: 20px 10px;
    width: 200px;
    background-color: #c7c7c7;
    color: #444;
    text-transform: uppercase;
    text-align: center;
    display: block;
    margin-top: 10px;
    cursor: pointer;
}
    
</style>

</head>
<body>
    <div class="container">
        <form method="post" class="form" action="fileuploadservlet" enctype="multipart/form-data">
            <label for="file">Enviar arquivo</label>
        <input type="file" id="file" name="file" />
        <input class="btn" type="submit" value="Upload" />
        </form>
    </div>
</body>
</html>

