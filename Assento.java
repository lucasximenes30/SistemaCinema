import java.util.ArrayList;

public class Assento {
    private int idassento;
    private TipoAssento tipoassento;
    
    public int getIdassento() {
        return idassento;
    }
    public void setIdassento(int idassento) {
        this.idassento = idassento;
    }
    public TipoAssento getTipoassento() {
        return tipoassento;
    }
    public void setTipoassento(TipoAssento tipoassento) {
        this.tipoassento = tipoassento;
    }
    public Assento(int idassento, TipoAssento tipoassento) {
        this.idassento = idassento;
        this.tipoassento = tipoassento;
    }
    

    
}
