import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    @Override
    public String toString() {
        return "Sala{" +
            "idsala=" + idsala +
            ", capacidadesala=" + capacidadesala +
            ", status='" + status + '\'' +
            '}';
    }

    public Sala(int idsala, int capacidadesala, String status) {
        this.idsala = idsala;
        this.capacidadesala = capacidadesala;
        this.status = status;
    }

    public boolean cadastrar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\salas.txt", true))) {
            writer.write(this.getIdsala() + "; " +
                         this.getCapacidadesala() + "; " +
                         this.getStatus());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Sala> listar() {
        ArrayList<Sala> salas = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\salas.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("; ");
                int idsala = Integer.parseInt(dados[0]);
                int capacidadesala = Integer.parseInt(dados[1]);
                String status = dados[2];
                salas.add(new Sala(idsala, capacidadesala, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salas;
    }

    public Sala consultar(int idsala) {
        for (Sala sala : listar()) {
            if (sala.getIdsala() == idsala) {
                return sala;
            }
        }
        return null;
    }

    public boolean editar(int idsala, int novaCapacidade, String novoStatus) {
        ArrayList<Sala> salas = listar();
        boolean encontrado = false;

        for (Sala sala : salas) {
            if (sala.getIdsala() == idsala) {
                sala.setCapacidadesala(novaCapacidade);
                sala.setStatus(novoStatus);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\salas.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (Sala sala : salas) {
                    writer.write(sala.getIdsala() + "; " +
                                 sala.getCapacidadesala() + "; " +
                                 sala.getStatus());
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
