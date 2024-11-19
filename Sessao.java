import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sessao {
    private int idsessao;
    private  DateTimeFormatter datahorasessao;
    private Filme filme;
    private Funcionario funcionario;
    private String status;
    
    public int getIdsessao() {
        return idsessao;
    }
    public void setIdsessao(int idsessao) {
        this.idsessao = idsessao;
    }
    public DateTimeFormatter getDatahorasessao() {
        return datahorasessao;
    }
    public void setDatahorasessao(DateTimeFormatter datahorasessao) {
        this.datahorasessao = datahorasessao;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Sessao(int idsessao, DateTimeFormatter datahorasessao, Filme filme, Funcionario funcionario, String status) {
        this.idsessao = idsessao;
        this.datahorasessao = datahorasessao;
        this.filme = filme;
        this.funcionario = funcionario;
        this.status = status;
    }
}
