import java.util.ArrayList;

public class TipoAssento {
    private int idtipoassento;
    private String descricao;
    private String status;
    
    public int getIdtipoassento() {
        return idtipoassento;
    }
    public void setIdtipoassento(int idtipoassento) {
        this.idtipoassento = idtipoassento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public TipoAssento(int idtipoassento, String descricao, String status) {
        this.idtipoassento = idtipoassento;
        this.descricao = descricao;
        this.status = status;
    }
    
}
