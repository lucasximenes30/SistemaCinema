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

    public Ator(String cpf, String nome, String email, int registro) {
        super(cpf, nome, email);
        this.registro = registro;
    }
    public boolean cadastrar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\alunot5\\Documents\\AV3\\SistemaCinema\\BD\\atores.txt", true))) {
            writer.write(this.getNome() + "; " + this.getCpf() + "; " + getEmail() + "; " + this.registro);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Ator> listar() {
        ArrayList<Ator> atores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\alunot5\\Documents\\AV3\\SistemaCinema\\BD\\atores.txt"))) {
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

    
}
