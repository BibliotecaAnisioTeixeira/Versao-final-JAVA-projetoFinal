/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** Classe para consulta de objetos
 * @author Vinicius Serra
 * @version 1.0
 * @since 22/09/2022
 */


public class Dao {
    /** Método para consulta de tabelas
    * @return con - Objeto do tipo conexão
    */
    public static Connection getConnection(){
    Connection con = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");       
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca1305","root","");
    }catch(Exception erro){
        System.out.println(erro);
    }
        return con;
    
    }
    

    
}
