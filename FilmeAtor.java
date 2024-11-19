import java.util.ArrayList;

public class FilmeAtor {
    private int idfilmeator;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;
    
    public int getIdfilmeator() {
        return idfilmeator;
    }
    public void setIdfilmeator(int idfilmeator) {
        this.idfilmeator = idfilmeator;
    }
    public Ator getAtor() {
        return ator;
    }
    public void setAtor(Ator ator) {
        this.ator = ator;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public String getPersonagem() {
        return personagem;
    }
    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }
    public boolean isPrincipal() {
        return principal;
    }
    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    public FilmeAtor(int idfilmeator, Ator ator, Filme filme, String personagem, boolean principal) {
        this.idfilmeator = idfilmeator;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
    }
    
    
}
