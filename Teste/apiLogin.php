<?php

    // verificando metodo de entrada
    if ($_SERVER['REQUEST_METHOD'] == 'GET') {

          //Se metodo valido

          require_once('conexao.php');

          Conexao_database();

          // pegando os dados necessario
          $usuario=$_GET['usuario'];
          $senha=$_GET['senha'];

          // $usuario='teste';
          // $senha='123';

          $sql="select * from tbl_cadastro where usuario='$usuario' and senha='$senha'";

          //echo $sql;
          $select =mysql_query($sql);
          // verificando resultados

          if (mysql_num_rows($select) > 0) {

            // se resultado valido
            echo json_encode(array(
              "status1" => true
            ));

            // se resultado invalido
          }else {
            echo json_encode(array(
              "status1" => false
            ));
          }


    }else { // se metodo invalido
      echo json_encode(array(
        "status" => false
      ));
    }

 ?>
