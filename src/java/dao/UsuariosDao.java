
package dao;

import classes.Usuario;
import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** Classe para consulta de objetos do tipo usuário
 * @author Vinicius Serra
 * @version 1.0
 * @since 22/09/2022
 */
public class UsuariosDao {
    /** Método pra busca de usuário
     * @param id - id do usuário
     * @return usuario - objeto da classe usuario
     */
        public static Usuario getUsuarioById(int id){
        Usuario usuario = null;      
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from usuariossite where Id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));         
            usuario.setSenha(rs.getString("senha"));   
            usuario.setAcesso(rs.getString("acesso")); 
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return usuario;
    }
           
    /** Método para editar as informações do usuários
     * @param usuario - usuario da base de dados
     * @return status - Edição do usuário
     */
        
   public static int editarUsuario(Usuario usuario){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuariossite SET Nome=?, Email=?, Acesso=? WHERE id=?");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getAcesso()); 
        ps.setInt(4, usuario.getId());         
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
   
   /** Método que exibe os dados do usuário em lista
    * @param inicio int - Começo da lista
    * @param total int - Número de usuários
    * @return list - Lista de usuários
    */
    
    public static List<Usuario> getUsuarios(int inicio, int total) {
    List<Usuario> list = new ArrayList<Usuario>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuariossite ORDER BY id LIMIT " + (inicio - 1) + " ," + total);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));         
            usuario.setSenha(rs.getString("senha"));   
            usuario.setAcesso(rs.getString("acesso")); 
            usuario.setStatus(rs.getString("status"));
            list.add(usuario);
        }       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }

   /** Método de relatório de usuários
    * @return list - Lista de usuários
    */ 
   
    public static List<Usuario> getRelatorio() {
    List<Usuario> list = new ArrayList<Usuario>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuariossite");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));          
            usuario.setAcesso(rs.getString("acesso")); 
            list.add(usuario);
        }       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
    
    /** Método que demonstra o número de usuários
     * @return contagem - Conta o número de usuários
     */
    
    public static int getContagem() {
        int contagem = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM usuariossite");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                contagem = rs.getInt("contagem");
            }   
        }catch(Exception erro){
            System.out.println(erro);
        }
        return contagem;
    }
    
    /** Método que demonstra se o usuário é administrador ou comum
     * @return valores - Valores do usuários se ele é administrador ou comum
     */
    
        public static int[] getRelatorioUsuarios() {

        int[] valores = {0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS ADM FROM usuariossite where Acesso = 'Admin'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("ADM");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Comum FROM usuariossite where Acesso = 'Comum'");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("Comum");
            }            
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return valores;
    }
        
        /** Método para distinguir o status do usuário 
         * @return valores - Valores do usuário (Ativo ou inativo)
         */
        
    public static int[] getStatusUsuarios() {

        int[] valores = {0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS ativo FROM usuariossite where status = 'ativo'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("Ativo");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS inativo FROM usuariossite where status = 'inativo'");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("Inativo");
            }    
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS aguardando FROM usuariossite where status = 'aguardando'");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[2] = rs.getInt("Aguardando");
            }   
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return valores;
    }
        
    /** Método utilizado para remover usuários do banco de dados
     * @param usuario - Usuario é deletado do banco de dados
     * @return status - É a condição do usuário se ele foi excluído ou não
     */
    
    public static int excluirUsuario(Usuario usuario){
       int status = 0;  
        try{
             Connection con = getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuariossite WHERE id=?");
             ps.setInt(1, usuario.getId());         
             status = ps.executeUpdate();
         }catch(Exception erro){
             System.out.println(erro);
         }      
            return status;
   }
    
    /** Método para bloquear o usuário do banco de dados
     * @param usuario - Usuário é bloqueado ou desbloqueado do site 
     * @return status - É a condição do usuário se ele está ativo ou inativo
     */
    
    public static int bloquearUsuario(Usuario usuario){
       int status = 0;  
       String statusdousuario;
       
       if(usuario.getStatus().equals("ativo")){
        statusdousuario = "inativo";   
       }else{
        statusdousuario = "ativo";   
       }
        try{
             Connection con = getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuariossite SET Status=? WHERE id=?");
             ps.setString(1, statusdousuario);
             ps.setInt(2, usuario.getId());         
             status = ps.executeUpdate();
         }catch(Exception erro){
             System.out.println(erro);
         }      
            return status;
   }

    /** Método para cadastrar usuário no banco de dados
     * @param usuario - Usuário é cadastrado no site
     * @return status - Condição do usuário
     */
    
   public static int cadastrarUsuario(Usuario usuario){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO USUARIOSSITE(NOME,EMAIL,SENHA,ACESSO,STATUS) VALUES(?,?,?,?,'ativo')");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());        
        ps.setString(4, usuario.getAcesso());          
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }
    
   /** Método para o usuário logar no site
    * @param email String - Email do usuário
    * @param senha String - Senha do usuário
    * @return usuario - Objeto da classe usuário
    */
   
public static Usuario logar(String email, String senha){ 
Usuario usuario = new Usuario();    
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from usuariossite where Email=?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        //Verifica se a consulta retornou resultado
        if (rs.next()) {       
                if(rs.getString("status").equals("ativo")){
                    if(rs.getString("senha").equals(senha)){
                        usuario.setId(rs.getInt("id"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));         
                        usuario.setSenha(rs.getString("senha"));   
                        usuario.setAcesso(rs.getString("acesso"));     
                    }else{
                        //Senha errada
                        usuario = null;
                    }
                }else{
                   //Usuário Inativo
                   usuario = null;     
                }
        }else{
            // E-mail não existe
            usuario = null; 
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return usuario;
    }
   
}
