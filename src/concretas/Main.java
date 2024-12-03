package concretas;

import java.util.Scanner;
import abstratas.Pessoa;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BancoUsuarios bancoUsuarios = new BancoUsuarios(); // Instância para gerenciar usuários

        while (true) {
            System.out.println("== Bem-vindo ao Jaoboxd ==");
            System.out.println("1. Fazer registro");
            System.out.println("2. Fazer login");
            System.out.println("3. Sair");
            System.out.print("Selecione uma das opções: ");

            int opcao = scan.nextInt();
            scan.nextLine(); // Consumir quebra de linha residual

            switch (opcao) {
                case 1:
                    realizarCadastro(scan, bancoUsuarios);
                    break;
                case 2:
                    if (realizarLogin(scan, bancoUsuarios)) {
                        menuOpcoes(scan);
                        return; // Sai do loop principal após acessar o menu
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema... Até logo!");
                    scan.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para realizar cadastro
    private static void realizarCadastro(Scanner scan, BancoUsuarios bancoUsuarios) {
        System.out.println("\n--- Bem-vindo ao Cadastro ---");
        System.out.print("Digite seu nome: ");
        String nome = scan.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scan.nextLine();

        bancoUsuarios.registrar(nome, senha);
        System.out.println("Parabéns! Seu cadastro foi realizado com sucesso.");
    }

    // Método para realizar login
    private static boolean realizarLogin(Scanner scan, BancoUsuarios bancoUsuarios) {
        System.out.println("\n--- Bem-vindo ao Login ---");
        System.out.print("Digite seu nome: ");
        String nome = scan.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scan.nextLine();

        if (bancoUsuarios.login(nome, senha)) {
            System.out.println("Login realizado com sucesso! Bem-vindo(a), " + nome + "!");
            return true;
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
            return false;
        }
    }

    // Menu de opções do sistema
    public static void menuOpcoes(Scanner scan) {
        while (true) {
            System.out.println("\n=== Menu de Opções ===");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Listar filmes cadastrados");
            System.out.println("3. Avaliar filme");
            System.out.println("4. Listar avaliações");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");

            int opcao = scan.nextInt();
            scan.nextLine(); // Consumir quebra de linha residual

            try {
                switch (opcao) {
                    case 1:
                        SistemaFilmes.cadastrarFilme(scan);
                        break;
                    case 2:
                        SistemaFilmes.listarFilmes();
                        break;
                    case 3:
                        SistemaFilmes.avaliarFilme(scan);
                        break;
                    case 4:
                        SistemaFilmes.listarAvaliacoes();
                        break;
                    case 5:
                        SistemaFilmes.salvarFilmesEmArquivo();
                        System.out.println("Saindo do sistema...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

}
