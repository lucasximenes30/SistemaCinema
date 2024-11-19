import java.util.ArrayList;

public class SalaAssento {
    private int idsalaAssento;
    private Assento assento;
    private Sala sala;
    
    public int getIdsalaAssento() {
        return idsalaAssento;
    }
    public void setIdsalaAssento(int idsalaAssento) {
        this.idsalaAssento = idsalaAssento;
    }
    public Assento getAssento() {
        return assento;
    }
    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public SalaAssento(int idsalaAssento, Assento assento, Sala sala) {
        this.idsalaAssento = idsalaAssento;
        this.assento = assento;
        this.sala = sala;
    }
    

    
}
