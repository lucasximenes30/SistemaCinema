import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Genero {
    private int id;
    private String descricao;
    private String Status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public Genero(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.Status = status;
    }
    @Override
    public String toString() {
        return "Genero{" +
            "id=" + id +
            ", descricao='" + descricao + '\'' +
            ", status='" + Status + '\'' +
            '}';
    }



    public boolean cadastrar(Genero genero) {
        try (
            FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\genero.txt", true);
            BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(genero.getId() + ";" + genero.getDescricao() + ";" + genero.getStatus());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ArrayList<Genero> listar() {
        ArrayList<Genero> generos = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\genero.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String desc = dados[1];
                String status = dados[2];
                generos.add(new Genero(id, desc, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return generos;
    }


    public Genero consultar(String desc) {
        for (Genero genero : listar()) {
            if (genero.getDescricao().equalsIgnoreCase(desc)) {
                return genero;
            }
        }
        return null;
    }


    public boolean editar(int id, String novaDesc, String novoStatus) {
        ArrayList<Genero> generos = listar();
        boolean encontrado = false;

        for (Genero genero : generos) {
            if (genero.getId() == id) {
                genero.setDescricao(novaDesc);
                genero.setStatus(novoStatus);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\genero.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (Genero genero : generos) {
                    writer.write(genero.getId() + ";" + genero.getDescricao() + ";" + genero.getStatus());
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
