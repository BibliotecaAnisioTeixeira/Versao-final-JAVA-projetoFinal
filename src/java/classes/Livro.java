
package classes;

/** Classe livros
 * @author Allan da Silva Fernandes
 * @version 1.0
 * @since 23/09/2022
 */
public class Livro {
    private int id;
    private String paginas;
    private String nome_livro;
    private String isbn;
    private String autor;
    private int acesso;
    private int download;
    private int ano;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
}
