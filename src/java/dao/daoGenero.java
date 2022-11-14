/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Genero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** Classe para consulta de objetos do tipo genero
 * @author Allan da Silva
 * @version 1.0
 * @since 22/09/2022
 */

public class daoGenero {
    
    /** Método para conexão ao banco de dados
     * @return con - Objeto da classe genero
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
     
     /** Método que exibe o id do genero na base de dados
      * @param id - id do genero
      * @return genero - Genero do livro
      */
    
     
      public static Genero getGeneroById(int id){
        Genero genero = null;      
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from genero where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            genero = new Genero();
            genero.setId(rs.getInt("id"));
            genero.setNome(rs.getString("nome"));
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return genero;
    }
      
      /** Método para editar o genero do livro
       * @param generos - genero da base de dados
       * @return status - Edita o id do genero
       */
      
         public static int editarGenero(Genero generos){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE genero SET nome=? WHERE id=?");
        ps.setInt(2, generos.getId());
        ps.setString(1, generos.getNome());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
         
         /** Método que lista o genero na base de dados
          * @return list - Lista de Generos
          */
          public static List<Genero> getGeneros() {
    List<Genero> list = new ArrayList<Genero>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM genero");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Genero genero = new Genero();
            genero.setId(rs.getInt("id"));
            genero.setNome(rs.getString("nome"));
            list.add(genero);
        }
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
          
          /** Método que remove o genero da base de dados
           * @param generos - Genero é removido da base de dados
           * @return status - É a condição do genero que mostra se foi excluido ou não
           */
    
    
    public static int excluirGenero(Genero generos){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM genero WHERE id=?");
        ps.setInt(1, generos.getId());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
    
    /** Método para cadastrar o genero na base de dados
     * @param genero - Genero é cadastrado
     * @return status - Condição do genero
     */
    
      
   public static int cadastrarGenero(Genero genero){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO GENERO(NOME) VALUES(?)");
        ps.setString(1, genero.getNome());        
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
   
}

