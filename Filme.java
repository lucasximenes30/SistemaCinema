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

    // Construtor
    public Filme(int idfilme, String titulo, int classificacao, Genero genero, String status) {
        this.idfilme = idfilme;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = status;
    }

    // Método para inserir um filme no arquivo
    public boolean inserir(Filme filme) {
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
                Genero genero = new Genero(idGenero, "Descrição padrão", "Ativo"); // Ajustar conforme necessário
                filmes.add(new Filme(idfilme, titulo, classificacao, genero, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filmes;
    }

    // Método para consultar um filme por ID
    public Filme consultar(int id) {
        for (Filme filme : listar()) {
            if (filme.getIdfilme() == id) {
                return filme;
            }
        }
        return null;
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
