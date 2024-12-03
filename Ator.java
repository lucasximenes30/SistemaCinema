import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ator extends Pessoa {
    private int registro;

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Ator{" +
            "registro=" + registro +
            ", " + super.toString() +
            '}';
    }

    public Ator(String cpf, String nome, String email, int registro) {
        super(cpf, nome, email);
        this.registro = registro;
    }

    public boolean cadastrar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\atores.txt", true))) {
            writer.write(this.getRegistro() + "; " +
                         this.getCpf() + "; " +
                         this.getNome() + "; " +
                         this.getEmail());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Ator> listar() {
        ArrayList<Ator> atores = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\atores.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int registro = Integer.parseInt(dados[0]);
                String cpf = dados[1];
                String nome = dados[2];
                String email = dados[3];
                atores.add(new Ator(cpf, nome, email, registro));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return atores;
    }

    public Ator consultar(String cpf) {
        for (Ator ator : listar()) {
            if (ator.getCpf().equals(cpf)) {
                return ator;
            }
        }
        return null;
    }

    public boolean editar(String cpf, String novoNome, String novoEmail, int novoRegistro) {
        ArrayList<Ator> atores = listar();
        boolean encontrado = false;

        for (Ator ator : atores) {
            if (ator.getCpf().equals(cpf)) {
                ator.setNome(novoNome);
                ator.setEmail(novoEmail);
                ator.setRegistro(novoRegistro);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\atores.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (Ator ator : atores) {
                    writer.write(ator.getRegistro() + ";" +
                                 ator.getCpf() + ";" +
                                 ator.getNome() + ";" +
                                 ator.getEmail());
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
