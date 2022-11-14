package classes;
import java.sql.Blob;

/** Classe arquivo
 * @author Allan da Silva Fernandes
 * @version 1.0
 * @since 22/09/2022
 */
public class Arquivo {
    private int id;
    private String nome;
    private Blob documento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Blob getDocumento() {
        return documento;
    }

    public void setDocumento(Blob documento) {
        this.documento = documento;
    }
}
