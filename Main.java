import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo ao Sistema de Cinema!");
            System.out.println("1. Cadastrar Ator");
            System.out.println("2. Cadastrar Gênero");
            System.out.println("3. Cadastrar Filme");
            System.out.println("4. Cadastrar Funcionário");
            System.out.println("5. Cadastrar Sala");
            System.out.println("6. Cadastrar Assento");
            System.out.println("7. Cadastrar Sessão");
            System.out.println("8. Cadastrar Tipo de Assento");
            System.out.println("9. Listar Filmes");
            System.out.println("10. Listar Funcionários");
            System.out.println("11. Listar Salas");
            System.out.println("12. Listar Sessões");
            System.out.println("13. Listar Tipos de Assento");
            System.out.println("14. Editar Filme");
            System.out.println("15. Editar Funcionário");
            System.out.println("16. Editar Sala");
            System.out.println("17. Editar Sessão");
            System.out.println("18. Editar Tipo de Assento");
            System.out.println("19. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: {
                    System.out.println("Digite o CPF do Ator:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o nome do Ator:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email do Ator:");
                    String email = scanner.nextLine();
                    System.out.println("Digite o registro do Ator:");
                    int registro = scanner.nextInt();
                    Ator ator = new Ator(cpf, nome, email, registro);
                    if (ator.cadastrar()) {
                        System.out.println("Ator cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o ator.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Digite o ID do Gênero:");
                    int idGenero = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite a descrição do Gênero:");
                    String descricaoGenero = scanner.nextLine();
                    System.out.println("Digite o status do Gênero:");
                    String statusGenero = scanner.nextLine();

                    Genero novoGenero = new Genero(idGenero, descricaoGenero, statusGenero);
                    if (novoGenero.cadastrar(novoGenero)) {
                        System.out.println("Gênero cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o gênero.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Digite o ID do Filme:");
                    int idfilme = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite o título do Filme:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a classificação do filme:");
                    int classificacao = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite o gênero do Filme (descrição):");
                    String generoInput = scanner.nextLine();

                    Genero genero = new Genero(0, "", "");
                    Genero generoEncontrado = genero.consultar(generoInput);

                    if (generoEncontrado == null) {
                        System.out.println("Gênero não encontrado. Certifique-se de que o gênero está cadastrado.");
                        break;
                    }

                    System.out.println("Digite o status do Filme:");
                    String status = scanner.nextLine();

                    Filme filme = new Filme(idfilme, titulo, classificacao, generoEncontrado, status);

                    if (filme.cadastrar(filme)) {
                        System.out.println("Filme cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o filme.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Digite o CPF do Funcionário:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o nome do Funcionário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email do Funcionário:");
                    String email = scanner.nextLine();
                    System.out.println("Digite a matrícula do Funcionário:");
                    int matricula = scanner.nextInt();
                    Funcionario funcionario = new Funcionario(cpf, nome, email, matricula, null);
                    if (funcionario.cadastrar()) {
                        System.out.println("Funcionário cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o funcionário.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Digite o ID da Sala:");
                    int idsala = scanner.nextInt();
                    System.out.println("Digite a capacidade da Sala:");
                    int capacidadesala = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite o status da Sala:");
                    String status = scanner.nextLine();
                    Sala sala = new Sala(idsala, capacidadesala, status);
                    if (sala.cadastrar()) {
                        System.out.println("Sala cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar a sala.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Digite o ID do Assento:");
                    int idassento = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite a descrição do Assento:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o status do Assento:");
                    String status = scanner.nextLine();
                    Assento assento = new Assento(idassento, descricao, status);
                    if (assento.cadastrar(assento)) {
                        System.out.println("Assento cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o assento.");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Digite o ID da Sessão:");
                    int idsessao = scanner.nextInt();
                    scanner.nextLine();  // Limpar buffer
                    System.out.println("Digite a data e hora da Sessão (formato: yyyy-MM-dd HH:mm):");
                    String datahora = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime localDateTime = LocalDateTime.parse(datahora, formatter);
                    System.out.println("Digite o ID do Filme para a Sessão:");
                    int idfilme = scanner.nextInt();
                    System.out.println("Digite o ID do Funcionário que agendou a Sessão:");
                    int matriculaFuncionario = scanner.nextInt();
                    scanner.nextLine();  // Limpar buffer
                    System.out.println("Digite o status da Sessão:");
                    String status = scanner.nextLine();
                    // Instanciar os objetos Filme e Funcionario
                    Filme filme = new Filme(idfilme, null, 0, null, null); // Ajustar conforme necessário
                    Funcionario funcionario = new Funcionario(null, null, null, matriculaFuncionario, null); // Ajustar conforme necessário
                    Sessao sessao = new Sessao(idsessao, formatter, filme, funcionario, status);
                    if (sessao.cadastrar()) {
                        System.out.println("Sessão cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar a sessão.");
                    }
                    break;
                }

                case 8: {
                    System.out.println("Digite o ID do Tipo de Assento:");
                    int idTipoAssento = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite a descrição do Tipo de Assento:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o status do Tipo de Assento:");
                    String status = scanner.nextLine();
                    TipoAssento tipoAssento = new TipoAssento(idTipoAssento, descricao, status);
                    if (tipoAssento.cadastrar(tipoAssento)) {
                        System.out.println("Tipo de Assento cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o Tipo de Assento.");
                    }
                    break;
                }
                case 9: {
                    Filme filme = new Filme(0, null, 0, null, null);
                    filme.listar().forEach(f -> System.out.println(f.getTitulo()));
                    break;
                }

                case 10: {
                    Funcionario funcionario = new Funcionario(null, null, null, 0, null);
                    funcionario.listar().forEach(f -> System.out.println(f.getNome()));
                    break;
                }
                case 11: {
                    Sala sala = new Sala(0, 0, null);
                    sala.listar().forEach(s -> System.out.println("Sala ID: " + s.getIdsala()));
                    break;
                }

                case 12: {
                    Sessao sessao = new Sessao(0, null, null, null, null);
                    sessao.listar().forEach(s -> System.out.println("Sessao ID: " + s.getIdsessao()));
                    break;
                }
                case 13: {
                    System.out.println("Listando os Tipos de Assento:");
                    TipoAssento tipoAssento = new TipoAssento(0, null, null); // Instância da classe TipoAssento
                    var tiposDeAssento = tipoAssento.listar(); // Método para listar todos os tipos de assento
                
                    if (tiposDeAssento.isEmpty()) {
                        System.out.println("Nenhum tipo de assento encontrado.");
                    } else {
                        tiposDeAssento.forEach(t -> {
                            System.out.println("ID: " + t.getIdtipoassento() +
                                               " | Descrição: " + t.getDescricao() +
                                               " | Status: " + t.getStatus());
                        });
                    }
                    break;
                }
                
                case 14: {
                    System.out.println("Digite o ID do Filme a ser editado:");
                    int idFilme = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    Filme filme = new Filme(0, null, 0, null, null);
                    ArrayList<Filme> filmes = filme.listar(); // Listar todos os filmes para buscar o filme pelo ID

                    Filme filmeExistente = null;
                    for (Filme f : filmes) {
                        if (f.getIdfilme() == idFilme) {
                            filmeExistente = f;
                            break;
                        }
                    }

                    if (filmeExistente == null) {
                        System.out.println("Filme não encontrado!");
                        break;
                    }

                    System.out.println("Filme encontrado: " + filmeExistente.getTitulo());
                    System.out.println("Digite o novo título do Filme (ou pressione Enter para manter: " + filmeExistente.getTitulo() + "):");
                    String novoTitulo = scanner.nextLine();
                    if (novoTitulo.isEmpty()) {
                        novoTitulo = filmeExistente.getTitulo();
                    }

                    System.out.println("Digite a nova classificação (ou digite -1 para manter: " + filmeExistente.getClassificacao() + "):");
                    int novaClassificacao = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    if (novaClassificacao == -1) {
                        novaClassificacao = filmeExistente.getClassificacao();
                    }

                    System.out.println("Digite a nova descrição do Gênero (ou pressione Enter para manter: " + filmeExistente.getGenero().getDescricao() + "):");
                    String novaDescricaoGenero = scanner.nextLine();
                    Genero novoGenero = filmeExistente.getGenero(); // Manter o gênero atual por padrão
                    if (!novaDescricaoGenero.isEmpty()) {
                        Genero genero = new Genero(0, novaDescricaoGenero, "");
                        Genero generoEncontrado = genero.consultar(novaDescricaoGenero); // Consultar o gênero
                        if (generoEncontrado != null) {
                            novoGenero = generoEncontrado;
                        } else {
                            System.out.println("Gênero não encontrado. Mantendo gênero atual.");
                        }
                    }

                    System.out.println("Digite o novo status (ou pressione Enter para manter: " + filmeExistente.getStatus() + "):");
                    String novoStatus = scanner.nextLine();
                    if (novoStatus.isEmpty()) {
                        novoStatus = filmeExistente.getStatus();
                    }

                    // Chamar o método de edição
                    if (filme.editar(idFilme, novoTitulo, novaClassificacao, novoGenero, novoStatus)) {
                        System.out.println("Filme editado com sucesso!");
                    } else {
                        System.out.println("Erro ao editar o filme.");
                    }
                    break;
                }

                case 15: {
                    System.out.println("Digite a matrícula do funcionário a ser editado:");
                    int matricula = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                
                    Funcionario funcionario = new Funcionario(null, null, null, 0, null);
                    Funcionario funcionarioExistente = funcionario.consultar(matricula);
                
                    if (funcionarioExistente == null) {
                        System.out.println("Funcionário não encontrado!");
                        break;
                    }
                
                    System.out.println("Funcionário encontrado: " + funcionarioExistente.getNome());
                    System.out.println("Digite o novo nome (ou pressione Enter para manter: " + funcionarioExistente.getNome() + "):");
                    String novoNome = scanner.nextLine();
                    if (novoNome.isEmpty()) {
                        novoNome = funcionarioExistente.getNome();
                    }
                
                    System.out.println("Digite o novo e-mail (ou pressione Enter para manter: " + funcionarioExistente.getEmail() + "):");
                    String novoEmail = scanner.nextLine();
                    if (novoEmail.isEmpty()) {
                        novoEmail = funcionarioExistente.getEmail();
                    }
                
                    System.out.println("Digite o novo horário de trabalho (YYYY-MM-DD, ou pressione Enter para manter: " + funcionarioExistente.getHorarioTrabalho() + "):");
                    String novoHorario = scanner.nextLine();
                    Date novoHorarioTrabalho = novoHorario.isEmpty() ? funcionarioExistente.getHorarioTrabalho() : Date.valueOf(novoHorario);
                
                    if (funcionario.editar(matricula, novoNome, novoEmail, novoHorarioTrabalho)) {
                        System.out.println("Funcionário editado com sucesso!");
                    } else {
                        System.out.println("Erro ao editar o funcionário.");
                    }
                    break;
                }
                
                case 16: {
                    System.out.println("Digite o ID da sala a ser editada:");
                    int idsala = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                
                    Sala sala = new Sala(0, 0, null);
                    Sala salaExistente = sala.consultar(idsala);
                
                    if (salaExistente == null) {
                        System.out.println("Sala não encontrada!");
                        break;
                    }
                
                    System.out.println("Sala encontrada: Capacidade = " + salaExistente.getCapacidadesala() + ", Status = " + salaExistente.getStatus());
                    System.out.println("Digite a nova capacidade (ou -1 para manter: " + salaExistente.getCapacidadesala() + "):");
                    int novaCapacidade = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    novaCapacidade = (novaCapacidade == -1) ? salaExistente.getCapacidadesala() : novaCapacidade;
                
                    System.out.println("Digite o novo status (ou pressione Enter para manter: " + salaExistente.getStatus() + "):");
                    String novoStatus = scanner.nextLine();
                    novoStatus = novoStatus.isEmpty() ? salaExistente.getStatus() : novoStatus;
                
                    if (sala.editar(idsala, novaCapacidade, novoStatus)) {
                        System.out.println("Sala editada com sucesso!");
                    } else {
                        System.out.println("Erro ao editar a sala.");
                    }
                    break;
                }
                
                case 17: {
                    System.out.println("Digite o ID da sessão a ser editada:");
                    int idsessao = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                
                    Sessao sessao = new Sessao(0, null, null, null, null);
                    Sessao sessaoExistente = sessao.consultar(idsessao);
                
                    if (sessaoExistente == null) {
                        System.out.println("Sessão não encontrada!");
                        break;
                    }
                
                    System.out.println("Sessão encontrada: Data e Hora = " + sessaoExistente.getDatahorasessao() + ", Status = " + sessaoExistente.getStatus());
                    System.out.println("Digite a nova data e hora (ou pressione Enter para manter: " + sessaoExistente.getDatahorasessao() + "):");
                    String novaDataHoraStr = scanner.nextLine();
                    DateTimeFormatter novaDataHora = novaDataHoraStr.isEmpty() ? sessaoExistente.getDatahorasessao() : DateTimeFormatter.ofPattern(novaDataHoraStr);
                
                    System.out.println("Digite o novo status (ou pressione Enter para manter: " + sessaoExistente.getStatus() + "):");
                    String novoStatus = scanner.nextLine();
                    novoStatus = novoStatus.isEmpty() ? sessaoExistente.getStatus() : novoStatus;
                
                    // Para selecionar o novo filme e o novo funcionário, você pode criar opções para isso, mas vou simplificar:
                    Filme novoFilme = new Filme(1, "Novo Filme", 0, null, "Ativo"); // Exemplo, você pode fazer uma consulta para escolher um filme real.
                    Funcionario novoFuncionario = new Funcionario("cpf", "Funcionario Nome", "email", 123, null); // Exemplo.
                
                    if (sessao.editar(idsessao, novaDataHora, novoFilme, novoFuncionario, novoStatus)) {
                        System.out.println("Sessão editada com sucesso!");
                    } else {
                        System.out.println("Erro ao editar a sessão.");
                    }
                    break;
                }
                
                case 18: {
                    System.out.println("Digite o ID do assento a ser editado:");
                    int idassento = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                
                    Assento assento = new Assento(0, null); // Cria um objeto para usar os métodos da classe
                    Assento assentoExistente = assento.consultar(idassento);
                
                    if (assentoExistente == null) {
                        System.out.println("Assento não encontrado!");
                        break;
                    }
                
                    System.out.println("Assento encontrado: Tipo = " + assentoExistente.getTipoassento().getDescricao());
                    System.out.println("Digite o novo tipo de assento (ou pressione Enter para manter: " + assentoExistente.getTipoassento().getDescricao() + "):");
                    String novoTipoAssentoDesc = scanner.nextLine();
                    TipoAssento novoTipoAssento = novoTipoAssentoDesc.isEmpty() ? assentoExistente.getTipoassento() : new TipoAssento(1, novoTipoAssentoDesc, "Ativo");
                
                    if (assento.editar(idassento, novoTipoAssento)) {
                        System.out.println("Assento editado com sucesso!");
                    } else {
                        System.out.println("Erro ao editar o assento.");
                    }
                    break;
                }
                
                
                case 19: {
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
                }
            }
        }

        scanner.close();
    }

}