import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    @Override
    public String toString() {
        return "Ingresso{" +
            "idingresso=" + idingresso +
            ", salaassento=" + salaassento +
            ", sessao=" + (sessao != null ? sessao.toString() : "null") +
            '}';
    }

    public Ingresso(int idingresso, double salaassento, Sessao sessao) {
        this.idingresso = idingresso;
        this.salaassento = salaassento;
        this.sessao = sessao;
    }

    public boolean cadastrar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\ingressos.txt", true))) {
            writer.write(this.getIdingresso() + ";" +
                         this.getSalaassento() + ";" +
                         this.getSessao().getIdsessao());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Ingresso> listar() {
        ArrayList<Ingresso> ingressos = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\ingressos.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idingresso = Integer.parseInt(dados[0]);
                double salaassento = Double.parseDouble(dados[1]);
                int idSessao = Integer.parseInt(dados[2]);

                Sessao sessao = new Sessao(idSessao, null, null, null, linha);
                sessao = sessao.consultar(idSessao);

                if (sessao != null) {
                    ingressos.add(new Ingresso(idingresso, salaassento, sessao));
                } else {
                    System.out.println("Sessão não encontrada para o ID: " + idSessao);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingressos;
    }

    public Ingresso consultar(int id) {
        for (Ingresso ingresso : listar()) {
            if (ingresso.getIdingresso() == id) {
                return ingresso;
            }
        }
        return null;
    }

    public boolean editar(int id, double novoSalaassento, Sessao novaSessao) {
        ArrayList<Ingresso> ingressos = listar();
        boolean encontrado = false;

        for (Ingresso ingresso : ingressos) {
            if (ingresso.getIdingresso() == id) {
                ingresso.setSalaassento(novoSalaassento);
                ingresso.setSessao(novaSessao);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\ingressos.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (Ingresso ingresso : ingressos) {
                    writer.write(ingresso.getIdingresso() + ";" +
                                 ingresso.getSalaassento() + ";" +
                                 ingresso.getSessao().getIdsessao());
                    writer.newLine();
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
