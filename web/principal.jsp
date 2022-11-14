<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.UsuariosDao, classes.Usuario, classes.Livro, dao.daoLivro, java.util.*"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Java Web</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="imagens/favicon.png" />
<link href="css/padrao.css" rel="stylesheet" type="text/css"/>
<style>
    .grafico {
    max-width: 450px;
    margin: 0 auto;
}

</style>
</head>
<body>
    <%@include file="acessocomum.jsp"%>
<div class="topnav">
    <%@include file="menu.jsp"%>
</div>

<div class="content">        
            <%
                
                List<Usuario> list = UsuariosDao.getRelatorio();
                request.setAttribute("list", list);
               
                int[] valores = UsuariosDao.getStatusUsuarios();
                request.setAttribute("valores", valores);
                
                int[] soma = daoLivro.getSomaLivros();
                request.setAttribute("soma",soma);
                
                int[] acesso = daoLivro.getAcessoLivros();
                request.setAttribute("acesso",acesso);

            %>
        
            <h1></h1>
 
            <div class="grafico">
                <canvas id="myChart1"></canvas>
            </div>
            
              <div class="grafico">
                <canvas id="myChart100"></canvas>
            </div>
            
            <div class="grafico">
                <canvas id="myChart2"></canvas>
            </div>
          
         
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>
            
            
            
         

    <script type="text/javascript">
        var ctx = document.getElementById("myChart1");
        var valores = [<%=valores[0]%>, <%=valores[1]%>, <%=valores[2]%>];
        var tipos = ["Ativo", "Inativo", "Aguardando"];

        var myChart = new Chart(ctx, {
          type: "pie",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "Usuarios",
                data: valores,
                backgroundColor: [
                  "rgba(255, 99, 132, 1)",
                  "rgba(54, 162, 235, 1)",
                  "rgba(255, 206, 86, 1)",
                  "rgba(75, 192, 192, 0.2)",
                  "rgba(153, 102, 255, 0.2)",
                ]
              }
            ]
          }
        }); 
        
    </script>   
    
    
    <script type="text/javascript">
        var ctx = document.getElementById("myChart100");
        var soma = [<%=soma[0]%>, <%=soma[1]%>, <%=soma[2]%>]
        var tipos = ["Ficção", "Não Ficção"];

        var myChart = new Chart(ctx, {
          type: "bar",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "livros",
                data: soma,
                backgroundColor: [
                  "rgba(255, 99, 132, 1)",
                  "rgba(54, 162, 235, 1)",
                  "rgba(255, 206, 86, 1)",
                  "rgba(75, 192, 192, 1)",
                  "rgba(153, 102, 255, 1)",
                ]
              }
            ]
          }
        }); 
    </script> 
    
    <script type="text/javascript">
        var ctx = document.getElementById("myChart2");
        var acesso = [<%=acesso[0]%>, <%=acesso[1]%>, <%=acesso[2]%>]
        var tipos = ["Ficção", "Não Ficção"];

        var myChart = new Chart(ctx, {
          type: "bar",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "livros",
                data: acesso,
                backgroundColor: [
                  "rgba(255, 99, 132, 1)",
                  "rgba(54, 162, 235, 1)",
                  "rgba(255, 206, 86, 1)",
                  "rgba(75, 192, 192, 1)",
                  "rgba(153, 102, 255, 1)",
                ]
              }
            ]
          }
        }); 
    </script>      
    
   

</div>

<div class="footer">
    <%@include file="rodape.jsp"%>
</div>

</body>
</html>

