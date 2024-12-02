import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FilmeAtor {
    private int idfilmeator;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;

    // Getters e Setters
    public int getIdfilmeator() {
        return idfilmeator;
    }

    public void setIdfilmeator(int idfilmeator) {
        this.idfilmeator = idfilmeator;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    @Override
    public String toString() {
    return "FilmeAtor{" +
            "idfilmeator=" + idfilmeator +
            ", ator=" + (ator != null ? ator.toString() : "null") +
            ", filme=" + (filme != null ? filme.toString() : "null") +
            ", personagem='" + personagem + '\'' +
            ", principal=" + principal +
            '}';
    }


    // Construtor
    public FilmeAtor(int idfilmeator, Ator ator, Filme filme, String personagem, boolean principal) {
        this.idfilmeator = idfilmeator;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
    }

    // Método para inserir
    public boolean inserir(FilmeAtor filmeAtor) {
        try (
            FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\filmeator.txt", true);
            BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(filmeAtor.getIdfilmeator() + ";" +
                         filmeAtor.getAtor().getRegistro() + ";" +  // Usando getRegistro() do Ator
                         filmeAtor.getFilme().getIdfilme() + ";" +
                         filmeAtor.getPersonagem() + ";" +
                         filmeAtor.getPrincipal());  // Usando isPrincipal() para o boolean
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para listar
    public ArrayList<FilmeAtor> listar() {
        ArrayList<FilmeAtor> filmeAtores = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\filmeator.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idfilmeator = Integer.parseInt(dados[0]);
                int idAtor = Integer.parseInt(dados[1]);
                int idFilme = Integer.parseInt(dados[2]);
                String personagem = dados[3];
                boolean principal = Boolean.parseBoolean(dados[4]);

                // Consultar o ator e filme com base nos IDs
                Ator ator = new Ator("", "", "", idAtor);  // Usando o idAtor para criar um ator (depois pode-se melhorar com consulta real)
                Filme filme = new Filme(idFilme, "", 0, null, "");  // Usando idFilme, que pode ser consultado depois

                filmeAtores.add(new FilmeAtor(idfilmeator, ator, filme, personagem, principal));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filmeAtores;
    }

    // Método para consultar
    public FilmeAtor consultar(int id) {
        for (FilmeAtor filmeAtor : listar()) {
            if (filmeAtor.getIdfilmeator() == id) {
                return filmeAtor;
            }
        }
        return null;
    }

    // Método para editar
    public boolean editar(int id, Ator novoAtor, Filme novoFilme, String novoPersonagem, boolean novoPrincipal) {
        ArrayList<FilmeAtor> filmeAtores = listar();
        boolean encontrado = false;

        for (FilmeAtor filmeAtor : filmeAtores) {
            if (filmeAtor.getIdfilmeator() == id) {
                filmeAtor.setAtor(novoAtor);
                filmeAtor.setFilme(novoFilme);
                filmeAtor.setPersonagem(novoPersonagem);
                filmeAtor.setPrincipal(novoPrincipal);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\filmeator.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (FilmeAtor filmeAtor : filmeAtores) {
                    writer.write(filmeAtor.getIdfilmeator() + ";" +
                                 filmeAtor.getAtor().getRegistro() + ";" +  // Usando getRegistro() do Ator
                                 filmeAtor.getFilme().getIdfilme() + ";" +
                                 filmeAtor.getPersonagem() + ";" +
                                 filmeAtor.getPrincipal());  // Usando isPrincipal() para o boolean
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
