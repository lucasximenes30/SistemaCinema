import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo ao Sistema de Cinema!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Ator");
            System.out.println("2. Cadastrar Gênero");
            System.out.println("3. Cadastrar Filme");
            System.out.println("4. Cadastrar Funcionario");
            System.out.println("5. Cadastrar Sala");
            System.out.println("6. Cadastrar Assento");
            System.out.println("7. Cadastrar Sessao");
            System.out.println("8. Cadastrar Tipo de Assento");
            System.out.println("9. Listar Filmes");
            System.out.println("10. Listar Funcionários");
            System.out.println("11. Listar Salas");
            System.out.println("12. Listar Sessões");
            System.out.println("13. Listar Tipos de Assento");
            System.out.println("14. Editar Filme");
            System.out.println("15. Editar Funcionario");
            System.out.println("16. Editar Sala");
            System.out.println("17. Editar Sessao");
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
                    scanner.nextLine();  // Limpar buffer
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
                    scanner.nextLine();  // Limpar buffer
                    System.out.println("Digite o título do Filme:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a classificação do filme:");
                    int classificacao = scanner.nextInt();
                    scanner.nextLine();  // Limpar buffer
                    System.out.println("Digite o gênero do Filme (descrição):");
                    String generoInput = scanner.nextLine();
                    
                    // Buscar o gênero pelo nome (descrição) usando o método consultar da classe Genero
                    Genero genero = new Genero(0, "", ""); // Instanciando um objeto Genero apenas para usar o método consultar
                    Genero generoEncontrado = genero.consultar(generoInput); // Consulta o gênero no banco de dados
                
                    if (generoEncontrado == null) {
                        System.out.println("Gênero não encontrado. Certifique-se de que o gênero está cadastrado.");
                        break;
                    }
                    
                    System.out.println("Digite o status do Filme:");
                    String status = scanner.nextLine();
                
                    // Criar o objeto Filme com o gênero encontrado
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
                    scanner.nextLine();  // Limpar buffer
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
                    scanner.nextLine();  // Limpar buffer
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
                    TipoAssento tipoAssento = new TipoAssento(0, null, null);
                    tipoAssento.listar().forEach(t -> System.out.println("Tipo de Assento: " + t.getDescricao()));
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
                    System.out.println("Digite o ID do Filme a ser editado:");
                    int idfilme = scanner.nextInt();
                    // Processar a edição conforme necessário
                    break;
                }
                case 14: {
                    System.out.println("Digite o ID do Funcionário a ser editado:");
                    int matricula = scanner.nextInt();
                    // Processar a edição conforme necessário
                    break;
                }
                case 15: {
                    System.out.println("Digite o ID da Sala a ser editada:");
                    int idsala = scanner.nextInt();
                    // Processar a edição conforme necessário
                    break;
                }
                case 16: {
                    System.out.println("Digite o ID da Sessão a ser editada:");
                    int idsessao = scanner.nextInt();
                    // Processar a edição conforme necessário
                    break;
                }
                case 17: {
                    System.out.println("Digite o ID do Tipo de Assento a ser editado:");
                    int idtipoassento = scanner.nextInt();
                    // Processar a edição conforme necessário
                    break;
                }
                case 18:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}