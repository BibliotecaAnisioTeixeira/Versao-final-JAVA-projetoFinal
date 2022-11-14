<head>
<meta charset="utf-8">
<style>

    .topnav{
        
    }    
    
nav a::after {
  content: "";
  width: 0;
  height: 3px;
  background-color: #f04e23;
  margin: auto;
  display: block;
}

.menu-item{
    text-decoration: none;
    color: #f6550c;
    font-family: 'Roboto', sans-serif;
    -webkit-transform: translateY(0);
    -moz-transform: translateY(0);
    -ms-transform: translateY(0);
    -o-transform: translateY(0);
    transform: translateY(0);
    -webkit-transition: 0.5s;
    -o-transition: 0.5s;
    -moz-transition: 0.5s;
    transition: 0.5s;
    position: relative;
    font: 400;
    font-size: 20px;
    padding-bottom: 5px;
}

.menu-item::after{
    content: " ";
    width: 0%;
    height: 4px;
    background-color: #f6550c;
    position: absolute;
    bottom: 0;
    left: 0;
    transition: 0.5s ease-in-out;
}

.menu-item:hover{
    -webkit-transform: translateY(-8px);
    -moz-transform: translateY(-8px);
    -ms-transform: translateY(-8px);
    -o-transform: translateY(-8px);
    transform: translateY(-8px);
}

.menu-item:hover::after{
    width: 100%;
}

.logo {
  font-size: 34px;
  letter-spacing: 3px;
}

nav {
  z-index: 4;
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #fffafa;
  height: 8vh;
  width: 100vw;
}

.nav-list {
  font-size: 20px;
  list-style: none;
  display: flex;
  width:100%;
  justify-content: center;
}

.navbar-login {
  font-size: 20px;
}

.nav-list li {
  margin-left: 20px;
}

li a, .dropbtn {
  display: inline-block;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}


li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}

 </style>
</head>
<body>
<ul class="nav-list">
  <li><a class="menu-item" href="principal.jsp">Principal</a></li>
   <li><a class="menu-item" href="generocontrolar.jsp">Gêneros</a></li>
  <li><a class="menu-item" href="autorcontrolar.jsp">Autor</a></li>
  <li><a class="menu-item" href="arquivoscadastrarform.jsp">Arquivos</a></li>
  <li><a class="menu-item" href="escreveremail.jsp">Email</a></li>
  
    <%
      String adm = (String) request.getSession().getAttribute("acesso");
 
       if (adm.equals("admin")) {
          %>
            
<li class='dropdown'><a class="menu-item" href='javascript:void(0)' class='dropbtn'>Usuários</a>
<div class='dropdown-content'><a class="menu-item" href='usuariosrelatorio.jsp'>Relatório de Usuários</a><a href='usuarioscontrolar.jsp?pag=1'>Controlar Usuários</a><a href='usuariocadastrarform.jsp'>Cadastrar Usuário</a></div></li>
<li class='dropdown'><a class="menu-item" href='javascript:void(0)' class='dropbtn'>Livros</a>
<div class='dropdown-content'><a class="menu-item" href='livrosrelatorio.jsp'>Relatório de Livros</a></div>
            <%
          
        }
   %>  
  

 <li class="dropdown" style="float:right">
     <a class="menu-item" href="javascript:void(0)" class="dropbtn">Usuário: <%=request.getSession().getAttribute("usuario")%></a>
    <div class="dropdown-content">
      <a class="menu-item" href="#">Alterar Dados</a>
      <a class="menu-item" href="#">Alterar Senha</a>
      <a class="menu-item" href="deslogar.jsp">Deslogar</a>
    </div>
  </li>

</ul>

</body>