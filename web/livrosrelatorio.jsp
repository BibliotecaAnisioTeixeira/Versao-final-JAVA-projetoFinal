<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.daoLivro, classes.Livro, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <script src="./scripts/filtrar.js"></script>
        <title>Relatório de Livros</title>
    </head>
    <body>
        
            <%@include file="acessoadm.jsp"%>
        
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
            <%
                
                List<Livro> list = daoLivro.getRelatorio();
                request.setAttribute("list", list);
               
                int[] valores = daoLivro.getRelatorioLivros();
                request.setAttribute("valores", valores);
                
                int[] soma = daoLivro.getSomaLivros();
                request.setAttribute("soma", soma);
                
                

            %>
        
            <h1 style="color:#F6550C;">Relatório de Livros</h1>
            
            		<input type="text" id="filtrarnomes" onkeyup="filtrar('filtrarnomes', 1)" placeholder="Busca de nomes">
			<input type="text" id="filtrarisbn" onkeyup="filtrar('filtrarisbn', 2)" placeholder="Busca de isbn">

            <table id="myTable">
            <tr><th>Id</th><th>Nome</th><th>Autor</th><th>Paginas</th><th>Isbn</th><th>Acesso</th><th>Download</th><th>Ano</th></tr>
                <c:forEach items="${list}" var="livro">
                <tr>
                    <td>${livro.getId()}</td>
                    <td>${livro.getNome_livro()}</td>
                    <td>${livro.getAutor()}</td>
                    <td>${livro.getPaginas()}</td>
                    <td>${livro.getIsbn()}</td>               
                    <td>${livro.getAcesso()}</td>
                    <td>${livro.getDownload()}</td>
                    <td>${livro.getAno()}</td>
                    
                </tr>
                </c:forEach>
            </table>
 
            <div class="grafico">
                <canvas id="myChart"></canvas>
                <p style="color:#F6550C;">Distribuição de Livros:</p>
                <p style="color:#F6550C;">Ficção: <%=valores[0]%></p>
                <p style="color:#F6550C;">Não Ficção: <%=valores[1]%></p>
                 <p style="color:#F6550C; font-weight: 500;">Misterio: <%=valores[2]%></p>
            </div>
            
            <div class="grafico">
                <canvas id="myChart100"></canvas>
                
            </div>

            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>

    <script type="text/javascript">
        var ctx = document.getElementById("myChart");
        var valores = [<%=valores[0]%>, <%=valores[1]%>, <%=valores[2]%>]
        var tipos = ["Ficção", "Não Ficção", "Mistério"];

        var myChart = new Chart(ctx, {
          type: "pie",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "livros",
                data: valores,
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
        var acesso = [<%=soma[0]%>, <%=soma[1]%>, <%=soma[2]%>]
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

