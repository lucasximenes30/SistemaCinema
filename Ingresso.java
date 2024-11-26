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
    
    // Getters e Setters
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

    // Construtor
    public Ingresso(int idingresso, double salaassento, Sessao sessao) {
        this.idingresso = idingresso;
        this.salaassento = salaassento;
        this.sessao = sessao;
    }

    // Método para cadastrar
    public boolean cadastrar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\ingressos.txt", true))) {
            writer.write(this.getIdingresso() + ";" +
                         this.getSalaassento() + ";" +
                         this.getSessao().getIdsessao());  // Assuming Sessao has a getIdSessao() method
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para listar
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
    
                // Aqui é necessário chamar um método que retorne a Sessao com base no ID.
                Sessao sessao = new Sessao(idSessao, null, null, null, linha); // Ajuste a Sessao para pegar a partir de uma consulta
                sessao = sessao.consultar(idSessao);  // Supondo que exista esse método na classe Sessao
    
                // Verifique se a sessão foi encontrada (se for null, você pode lançar uma exceção ou continuar)
                if (sessao != null) {
                    ingressos.add(new Ingresso(idingresso, salaassento, sessao));
                } else {
                    // Aqui você pode decidir o que fazer se a sessão não for encontrada (exemplo: lançar uma exceção)
                    System.out.println("Sessão não encontrada para o ID: " + idSessao);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingressos;
    }
    

    // Método para consultar por ID
    public Ingresso consultar(int id) {
        for (Ingresso ingresso : listar()) {
            if (ingresso.getIdingresso() == id) {
                return ingresso;
            }
        }
        return null;
    }

    // Método para editar
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
                                 ingresso.getSessao().getIdsessao());  // Again, assuming getIdSessao() exists
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
