<?php
$Down = $_GET['file']; ?>

< html >
  < head >
  < meta http - equiv = "refresh"
content = "0;url=<?php echo $Down; ?>" >
  < /head>
   <body>

      <?php
      $filePath = $Down.".txt";

      /*Se o arquivo existe, leia o contador que ele possui sen�o inicialize com 0*/
$count = file_exists($filePath) ? file_get_contents($filePath) : 0;

// Incrementa o novo valor e subscreve com o novo n�mero
file_put_contents($filePath, ++$count);

// Mostra o contador atual
echo "Downloads:".$count; ?>

< /body>
</html >