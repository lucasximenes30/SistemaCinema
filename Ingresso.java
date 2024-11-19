import java.util.ArrayList;

public class Ingresso {
    private int idingresso;
    private double salaassento;
    private Sessao sessao;
    
    public int getIdingresso() {
        return idingresso;
    }
    public void setIdingresso(int idingresso) {
        this.idingresso = idingresso;
    }
    public double getSalaassento() {
        return salaassento;
    }
    public void setSalaassento(double salaassento) {
        this.salaassento = salaassento;
    }
    public Sessao getSessao() {
        return sessao;
    }
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    public Ingresso(int idingresso, double salaassento, Sessao sessao) {
        this.idingresso = idingresso;
        this.salaassento = salaassento;
        this.sessao = sessao;
    }
    

    
}
