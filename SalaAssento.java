import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalaAssento {
    private int idsalaAssento;
    private Assento assento;
    private Sala sala;

    // Getters e Setters
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

    // Construtor
    public SalaAssento(int idsalaAssento, Assento assento, Sala sala) {
        this.idsalaAssento = idsalaAssento;
        this.assento = assento;
        this.sala = sala;
    }
    @Override
    public String toString() {
        return "SalaAssento{" +
            "idsalaAssento=" + idsalaAssento +
            ", assento=" + (assento != null ? assento.toString() : "null") +
            ", sala=" + (sala != null ? sala.toString() : "null") +
            '}';
    }


    // Método para cadastrar
    public boolean cadastrar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\sala_assentos.txt", true))) {
            writer.write(this.getIdsalaAssento() + "; " +
                         this.getAssento().getIdassento() + "; " +
                         this.getSala().getIdsala());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para listar
    public ArrayList<SalaAssento> listar() {
        ArrayList<SalaAssento> salaAssentos = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\sala_assentos.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("; "); // Certifique-se de que o separador no arquivo é "; "
                int idsalaAssento = Integer.parseInt(dados[0]);
                int idAssento = Integer.parseInt(dados[1]);
                int idSala = Integer.parseInt(dados[2]);

                // Consultar o objeto Assento
                Assento assento = new Assento(idSala, null).consultar(idAssento); // Requer implementação no Assento

                // Consultar o objeto Sala
                Sala sala = new Sala(idSala, idSala, linha).consultar(idSala); // Requer implementação no Sala

                if (assento != null && sala != null) {
                    salaAssentos.add(new SalaAssento(idsalaAssento, assento, sala));
                } else {
                    System.out.println("Assento ou Sala não encontrados para IDs: " + idAssento + ", " + idSala);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salaAssentos;
    }

    // Método para consultar por ID de SalaAssento
    public SalaAssento consultar(int idsalaAssento) {
        for (SalaAssento salaAssento : listar()) {
            if (salaAssento.getIdsalaAssento() == idsalaAssento) {
                return salaAssento;
            }
        }
        return null;
    }

    // Método para editar
    public boolean editar(int idsalaAssento, Assento novoAssento, Sala novaSala) {
        ArrayList<SalaAssento> salaAssentos = listar();
        boolean encontrado = false;

        for (SalaAssento salaAssento : salaAssentos) {
            if (salaAssento.getIdsalaAssento() == idsalaAssento) {
                salaAssento.setAssento(novoAssento);
                salaAssento.setSala(novaSala);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\sala_assentos.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (SalaAssento salaAssento : salaAssentos) {
                    writer.write(salaAssento.getIdsalaAssento() + "; " +
                                 salaAssento.getAssento().getIdassento() + "; " +
                                 salaAssento.getSala().getIdsala());
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
