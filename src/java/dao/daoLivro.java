/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Livro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** Classe para consulta de objetos do tipo livro
 * @author Allan da Silva
 * @version 1.0
 * @since 22/09/2022
 */

public class daoLivro {
    /**Método para busca de livros dentro da tabela de livros
     * @return con - objeto do tipo conexão
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
    /** Método de busca de livros na tabela livros
     * @param id - id do livro
     * @return livro - Objeto da classe livro
     */ 
    
     
      public static Livro getLivroById(int id){
        Livro livro = null;      
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from livros where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            livro = new Livro();
            livro.setId(rs.getInt("id"));
            livro.setNome_livro(rs.getString("nome_livro"));
            livro.setAutor(rs.getString("autor"));      
            livro.setPaginas(rs.getString("paginas")); 
            livro.setIsbn(rs.getString("isbn"));  
            livro.setAcesso(rs.getInt("acesso")); 
            livro.setDownload(rs.getInt("download")); 
            livro.setAno(rs.getInt("ano"));
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return livro;
    }
      
      /** Método que edita o livro na base de dados
       * @param livros - Livro da base de dados
       * @return status - Editar o livro
       */
      
         public static int editarLivro(Livro livros){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE livros SET nome_livro=?, autor=?, paginas=?, isbn=?, acesso=?, download=?, ano=?,  WHERE id=?");
        ps.setString(1, livros.getNome_livro());
        ps.setString(2, livros.getAutor());
        ps.setString(3, livros.getPaginas());
        ps.setString(4, livros.getIsbn());
        ps.setInt(5, livros.getAcesso());
        ps.setInt(6, livros.getDownload());
        ps.setInt(7, livros.getAno());
        ps.setInt(8, livros.getId());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
         
         /** Método que lista o livro na base de dados
          * @return list - Listagem do livro
          */
          public static List<Livro> getLivros() {
    List<Livro> list = new ArrayList<Livro>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM livros");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Livro livro = new Livro();
            livro.setId(rs.getInt("id"));
            livro.setNome_livro(rs.getString("nome_livro"));
            livro.setAutor(rs.getString("autor"));      
            livro.setPaginas(rs.getString("paginas")); 
            livro.setIsbn(rs.getString("isbn"));  
            livro.setAcesso(rs.getInt("acesso")); 
            livro.setDownload(rs.getInt("download")); 
            livro.setAno(rs.getInt("ano")); 
            list.add(livro);
        }
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
          
          /** Método para remover o livro do base de dados
           * @param livros - Livro é apagado da base de dados
           * @return status - Condição do livro que mostra se o status foi removido ou não
           */
    
    
    public static int excluirLivro(Livro livros){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM livros WHERE id=?");
        ps.setInt(1, livros.getId());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
    
    /** Método que cadastra os livros na base de dados
     * @param livro - Livro no banco de dados
     * @return status - Condição do livro
     */
    
      
   public static int cadastrarLivro(Livro livro){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO LIVROS(NOME_LIVRO,AUTOR,PAGINAS,ISBN,ACESSO,DOWNLOAD,ANO) VALUES(?,?,?,?,?,?,?)");
        ps.setString(1, livro.getNome_livro());
        ps.setString(2, livro.getAutor());
        ps.setString(3, livro.getPaginas());
        ps.setString(4, livro.getIsbn());
        ps.setInt(5, livro.getAcesso());
        ps.setInt(6, livro.getDownload());
        ps.setInt(7, livro.getAno());        
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
   
   /** Método relatorio do livro 
    * @return list - Listagem do relatorio do livro
    */
       public static List<Livro> getRelatorio() {
    List<Livro> list = new ArrayList<Livro>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM livros");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Livro livro = new Livro();
             livro.setId(rs.getInt("id"));
            livro.setNome_livro(rs.getString("nome_livro"));
            livro.setAutor(rs.getString("autor"));      
            livro.setPaginas(rs.getString("paginas")); 
            livro.setIsbn(rs.getString("isbn"));  
            livro.setAcesso(rs.getInt("acesso")); 
            livro.setDownload(rs.getInt("download")); 
            livro.setAno(rs.getInt("ano")); 
            list.add(livro);
        }       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
       
       /** Método que demonstra o numero de livros
        * @return contagem - Conta os livros
        */
    
    public static int getContagem() {
        int contagem = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM livros");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                contagem = rs.getInt("contagem");
            }   
        }catch(Exception erro){
            System.out.println(erro);
        }
        return contagem;
    }
    
    /** Método que irá mostrar ao administrador o relatório com a quantidade de generos existentes e quantos downloads existem por .
     * @return valores - Mostra ao administrador os valores dos generos 
     */
    
    
    public static int[] getSomaLivros() {

        int[] soma = {0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT sum(download) AS Ficção FROM livros where genero_id = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                soma[0] = rs.getInt("Ficção");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT sum(download) AS naoficcao FROM livros where genero_id = 2");
            rs = ps.executeQuery();
            while(rs.next()){
                soma[1] = rs.getInt("naoficcao");
            }            
            
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return soma;
    }
    
    
        public static int[] getRelatorioLivros() {

        int[] valores = {0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Ficção FROM livros where genero_id = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("Ficção");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS naoficcao FROM livros where genero_id = 2");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("naoficcao");
            }            
            
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return valores;
    }
       
        public static int[] getAcessoLivros() {

        int[] acesso = {0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT sum(acesso) AS Ficção FROM livros where genero_id = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                acesso[0] = rs.getInt("Ficção");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT sum(acesso) AS naoficcao FROM livros where genero_id = 2");
            rs = ps.executeQuery();
            while(rs.next()){
                acesso[1] = rs.getInt("naoficcao");
            }            
            
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return acesso;
    }
         
     

        
}

