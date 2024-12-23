import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    @Override
    public String toString() {
        return "Assento{" +
                "idassento=" + idassento +
                ", tipoassento=" + (tipoassento != null ? tipoassento.toString() : "null") +
                '}';
    }

    public Assento(int idassento2, String descricao, String status) {
    }

    public boolean cadastrar(Assento assento) {
        try (
            FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\assentos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(assento.getIdassento() + ";" + assento.getTipoassento().getIdtipoassento());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Assento> listar() {
        ArrayList<Assento> assentos = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\assentos.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idassento = Integer.parseInt(dados[0]);
                int idtipoassento = Integer.parseInt(dados[1]);
                TipoAssento tipoassento = new TipoAssento(idtipoassento, "Descrição padrão", "Ativo");
                assentos.add(new Assento(idassento, tipoassento));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assentos;
    }

    public Assento consultar(int id) {
        for (Assento assento : listar()) {
            if (assento.getIdassento() == id) {
                return assento;
            }
        }
        return null;
    }

    public boolean editar(int id, TipoAssento novoTipoAssento) {
        ArrayList<Assento> assentos = listar();
        boolean encontrado = false;

        for (Assento assento : assentos) {
            if (assento.getIdassento() == id) {
                assento.setTipoassento(novoTipoAssento);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\assentos.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (Assento assento : assentos) {
                    writer.write(assento.getIdassento() + ";" + assento.getTipoassento().getIdtipoassento());
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
