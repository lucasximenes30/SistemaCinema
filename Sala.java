import java.util.ArrayList;

public class Sala {
    private int idsala;
    private int capacidadesala;
    private String status;
    
    public int getIdsala() {
        return idsala;
    }
    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }
    public int getCapacidadesala() {
        return capacidadesala;
    }
    public void setCapacidadesala(int capacidadesala) {
        this.capacidadesala = capacidadesala;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Sala(int idsala, int capacidadesala, String status) {
        this.idsala = idsala;
        this.capacidadesala = capacidadesala;
        this.status = status;
    }
    

    
}
