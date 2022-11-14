/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Arquivo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**Classe para consulta de objetos do tipo arquivo
 * @author Vinicius Serra
 * @version 1.0
 * @since 23/09/2022
 */
public class daoArquivo {
    /** Método para busca de arquivo dentro da tabela de arquivos
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
      /** Método de busca de arquivos na tabela arquivos
       * @param id - id do usuário
       * @return arquivo - Arquivo do documento
       */
      
      public static Arquivo getArquivoById(int id){
        Arquivo arquivo = null;      
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from arquivo where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            arquivo = new Arquivo();
            arquivo.setId(rs.getInt("id"));
            arquivo.setNome(rs.getString("nome"));
            arquivo.setDocumento(rs.getBlob("documento"));
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return arquivo;
    }
    
      /** Método para cadastrar o arquivo
       * @param arquivo - Arquivo da base de dados
       * @return status - Cadastro do arquivo
       */
      
       public static int cadastrarArquivo(Arquivo arquivo){
       int status = 0;
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO ARQUIVO(NOME,DOCUMENTO) VALUES(?,?)");
        ps.setString(1, arquivo.getNome());
        ps.setBlob(2, arquivo.getDocumento());          
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
    
}
