import java.util.ArrayList;

public class Filme {
    private int idfilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;
    
    public int getIdfilme() {
        return idfilme;
    }
    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Filme(int idfilme, String titulo, int classificacao, Genero genero, String status) {
        this.idfilme = idfilme;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = status;
    }

    
}
