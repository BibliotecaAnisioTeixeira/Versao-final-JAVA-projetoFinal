/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Autor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**Classe para consulta de objetos do tipo autor
 * @author Vinicius Serra
 * @version 1.0
 * @since 27/09/2022
 */
public class daoAutor {
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
    
     /** Método para encontrar o autor do livro
      * @param id - id do autor
      * @return autor - Autor do livro
      */
         
      public static Autor getAutorById(int id){
        Autor autor = null;      
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from autor where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            autor = new Autor();
            autor.setId(rs.getInt("id"));
            autor.setNome(rs.getString("nome"));
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return autor;
    }
      
       /** Método que lista o autor
        * @return  list - Lista do autor
        */ 
           
          public static List<Autor> getAutor() {
    List<Autor> list = new ArrayList<Autor>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM autor");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Autor autor = new Autor();
            autor.setId(rs.getInt("id"));
            autor.setNome(rs.getString("nome"));
            list.add(autor);
        }
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
          
    /**Método que edita o autor
     * @param autor - Autor da base de dados
     * @return status - Editar autor
     */
    
     public static int editarAutor(Autor autor){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE autor SET nome=? WHERE id=?");
        ps.setInt(2, autor.getId());
        ps.setString(1, autor.getNome());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
     
     /**Método para apagar o autor
      * @param autor - Apaga o autor da base de dados
      * @return status - Mostra se está apagado ou não
      */
     
    public static int excluirAutor(Autor autor){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM autor WHERE id=?");
        ps.setInt(1, autor.getId());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
    
    /**Método para cadastrar o autor
     * @param autor - Autor da base de dados
     * @return status - Cadastro do autor
     */
      
    public static int cadastrarAutor(Autor autor){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO AUTOR(NOME) VALUES(?)");
        ps.setString(1, autor.getNome());        
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
}
