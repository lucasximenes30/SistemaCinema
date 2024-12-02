import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filme {
    private int idfilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;

    // Getters e Setters
    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Filme{" +
            "idfilme=" + idfilme +
            ", titulo='" + titulo + '\'' +
            ", classificacao=" + classificacao +
            ", genero=" + (genero != null ? genero.toString() : "null") +
            ", status='" + status + '\'' +
            '}';
    }


    // Construtor
    public Filme(int idfilme, String titulo, int classificacao, Genero genero, String status) {
        this.idfilme = idfilme;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = status;
    }

    // Método para inserir um filme no arquivo
    public boolean cadastrar(Filme filme) {
        try (
            FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\filmes.txt", true);
            BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(filme.getIdfilme() + ";" + filme.getTitulo() + ";" +
                         filme.getClassificacao() + ";" + filme.getGenero().getId() + ";" +
                         filme.getStatus());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para listar todos os filmes
    public ArrayList<Filme> listar() {
        ArrayList<Filme> filmes = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\filmes.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idfilme = Integer.parseInt(dados[0]);
                String titulo = dados[1];
                int classificacao = Integer.parseInt(dados[2]);
                int idGenero = Integer.parseInt(dados[3]);
                String status = dados[4];
    
                // Aqui você precisa consultar o gênero com base no ID
                // Agora vamos usar uma consulta ou instanciar o Genero com dados reais
                Genero genero = consultarGenero(idGenero); // Método que consulta o Gênero real
    
                filmes.add(new Filme(idfilme, titulo, classificacao, genero, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filmes;
    }
    
    // Método para consultar o Gênero baseado no ID (ajuste conforme seu banco de dados)
    private Genero consultarGenero(int idGenero) {
        // Aqui você deve procurar o Gênero real, seja em um banco ou arquivo
        // Para fins de exemplo, criaremos um Gênero genérico
        return new Genero(idGenero, "Gênero padrão", "Ativo"); // Ajuste conforme a lógica do seu sistema
    }
    

    // Método para editar um filme existente
    public boolean editar(int id, String novoTitulo, int novaClassificacao, Genero novoGenero, String novoStatus) {
        ArrayList<Filme> filmes = listar();
        boolean encontrado = false;

        for (Filme filme : filmes) {
            if (filme.getIdfilme() == id) {
                filme.setTitulo(novoTitulo);
                filme.setClassificacao(novaClassificacao);
                filme.setGenero(novoGenero);
                filme.setStatus(novoStatus);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\filmes.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (Filme filme : filmes) {
                    writer.write(filme.getIdfilme() + ";" + filme.getTitulo() + ";" +
                                 filme.getClassificacao() + ";" + filme.getGenero().getId() + ";" +
                                 filme.getStatus());
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
