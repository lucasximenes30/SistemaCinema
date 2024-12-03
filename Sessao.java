import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sessao {
    private int idsessao;
    private DateTimeFormatter datahorasessao;
    private Filme filme;
    private Funcionario funcionario;
    private String status;

    public int getIdsessao() {
        return idsessao;
    }

    public void setIdsessao(int idsessao) {
        this.idsessao = idsessao;
    }

    public DateTimeFormatter getDatahorasessao() {
        return datahorasessao;
    }

    public void setDatahorasessao(DateTimeFormatter datahorasessao) {
        this.datahorasessao = datahorasessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sessao{" +
            "idsessao=" + idsessao +
            ", datahorasessao=" + (datahorasessao != null ? datahorasessao.toString() : "null") +
            ", filme=" + (filme != null ? filme.toString() : "null") +
            ", funcionario=" + (funcionario != null ? funcionario.toString() : "null") +
            ", status='" + status + '\'' +
            '}';
    }

    public Sessao(int idsessao, DateTimeFormatter datahorasessao, Filme filme, Funcionario funcionario, String status) {
        this.idsessao = idsessao;
        this.datahorasessao = datahorasessao;
        this.filme = filme;
        this.funcionario = funcionario;
        this.status = status;
    }

    public boolean cadastrar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\sessoes.txt", true))) {
            writer.write(this.getIdsessao() + ";" +
                         this.getDatahorasessao() + ";" +
                         this.getFilme().getIdfilme() + ";" +  
                         this.getFuncionario().getMatricula() + ";" +  
                         this.getStatus());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Sessao> listar() {
        ArrayList<Sessao> sessoes = new ArrayList<>();
        try (
            FileReader fr = new FileReader("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\sessoes.txt");
            BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idsessao = Integer.parseInt(dados[0]);
                DateTimeFormatter datahorasessao = DateTimeFormatter.ofPattern(dados[1]);
                int idFilme = Integer.parseInt(dados[2]);
                int matriculaFuncionario = Integer.parseInt(dados[3]);
                String status = dados[4];

                Filme filme = new Filme(idFilme, "Título Filme", 0, null, "Ativo");  
                Funcionario funcionario = new Funcionario("cpf", "nome", "email", matriculaFuncionario, null);

                sessoes.add(new Sessao(idsessao, datahorasessao, filme, funcionario, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessoes;
    }

    public Sessao consultar(int id) {
        for (Sessao sessao : listar()) {
            if (sessao.getIdsessao() == id) {
                return sessao;
            }
        }
        return null;
    }

    public boolean editar(int id, DateTimeFormatter novaDataHora, Filme novoFilme, Funcionario novoFuncionario, String novoStatus) {
        ArrayList<Sessao> sessoes = listar();
        boolean encontrado = false;

        for (Sessao sessao : sessoes) {
            if (sessao.getIdsessao() == id) {
                sessao.setDatahorasessao(novaDataHora);
                sessao.setFilme(novoFilme);
                sessao.setFuncionario(novoFuncionario);
                sessao.setStatus(novoStatus);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (
                FileWriter fw = new FileWriter("C:\\Users\\Lucas\\Desktop\\Cinema\\SistemaCinema\\BD\\sessoes.txt");
                BufferedWriter writer = new BufferedWriter(fw)) {
                for (Sessao sessao : sessoes) {
                    writer.write(sessao.getIdsessao() + ";" +
                                 sessao.getDatahorasessao() + ";" +
                                 sessao.getFilme().getIdfilme() + ";" +
                                 sessao.getFuncionario().getMatricula() + ";" +
                                 sessao.getStatus());
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
