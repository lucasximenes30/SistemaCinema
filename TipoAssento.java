import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TipoAssento {
    private int idtipoassento;
    private String descricao;
    private String status;

    // Getters e Setters
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

    // Construtor
    public TipoAssento(int idtipoassento, String descricao, String status) {
        this.idtipoassento = idtipoassento;
        this.descricao = descricao;
        this.status = status;
    }
    @Override
    public String toString() {
        return "TipoAssento{" +
            "idtipoassento=" + idtipoassento +
            ", descricao='" + descricao + '\'' +
            ", status='" + status + '\'' +
            '}';
    }


    // Método para inserir um tipo de assento no arquivo
    public boolean cadastrar(TipoAssento tipoAssento) {
        try (
            FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\tipoassentos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(tipoAssento.getIdtipoassento() + ";" + tipoAssento.getDescricao() + ";" + tipoAssento.getStatus());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para listar todos os tipos de assento
    public ArrayList<TipoAssento> listar() {
        ArrayList<TipoAssento> tipoAssentos = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\tipoassentos.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idtipoassento = Integer.parseInt(dados[0]);
                String descricao = dados[1];
                String status = dados[2];
                tipoAssentos.add(new TipoAssento(idtipoassento, descricao, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tipoAssentos;
    }

    // Método para consultar um tipo de assento por ID
    public TipoAssento consultar(int id) {
        for (TipoAssento tipoAssento : listar()) {
            if (tipoAssento.getIdtipoassento() == id) {
                return tipoAssento;
            }
        }
        return null;
    }

    // Método para editar um tipo de assento existente
    public boolean editar(int id, String novaDescricao, String novoStatus) {
        ArrayList<TipoAssento> tipoAssentos = listar();
        boolean encontrado = false;

        for (TipoAssento tipoAssento : tipoAssentos) {
            if (tipoAssento.getIdtipoassento() == id) {
                tipoAssento.setDescricao(novaDescricao);
                tipoAssento.setStatus(novoStatus);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\tipoassentos.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (TipoAssento tipoAssento : tipoAssentos) {
                    writer.write(tipoAssento.getIdtipoassento() + ";" + tipoAssento.getDescricao() + ";" + tipoAssento.getStatus());
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
