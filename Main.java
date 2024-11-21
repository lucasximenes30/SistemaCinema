import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite o registro do ator: ");
        int registro = scanner.nextInt();

        Ator ator = new Ator(cpf, nome, email, registro);


        if (ator.cadastrar()) {
            System.out.println("Ator cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar o ator.");
        }


        scanner.close();
    }
}