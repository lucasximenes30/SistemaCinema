import java.util.ArrayList;

public class Genero {
    private int id;
    private String descricao;
    private String Status;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public Genero(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        Status = status;
    }
    
    
}
