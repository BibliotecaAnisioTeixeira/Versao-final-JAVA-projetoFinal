<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<link href="css/form.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" type="image/x-icon" href="favicon.svg" />   
<script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
</head>
<body>
	<form action="login.jsp" method="post">
		<h3>Login</h3>
		<div class="input">
                <i id="icon" class="fas fa-user"></i>
                <input id="place" type="text" name="email" placeholder="E-mail" required>
                </div>
                
                <div class="input">
                    <i id="icon" class="fas fa-lock"></i>
		<input id="place" type="password" name="senha" placeholder="Senha" required>
                </div>
		<input id="place" class="btn" type="submit" value="Login">
	</form>
</body>
</html>
