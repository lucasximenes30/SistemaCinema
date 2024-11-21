import java.io.BufferedWriter;
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
            writer.write(this.getNome() + ", " + this.getCpf() + ", " + getEmail() + ", " + this.registro + ".");
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
