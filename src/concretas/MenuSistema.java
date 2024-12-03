package concretas;

import abstratas.Filme; // Importa a classe Filme do pacote abstratas
import java.util.List;
import java.util.Scanner;

public class MenuSistema {
    private List<Filme> filmes;

    public MenuSistema(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void exibirMenu(Scanner scan) {
        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Listar filmes cadastrados");
            System.out.println("3. Avaliar filme");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scan.nextInt();
            scan.nextLine(); // Consumir quebra de linha residual

            switch (opcao) {
                case 1:
                    cadastrarFilme(scan);
                    break;
                case 2:
                    listarFilmes();
                    break;
                case 3:
                    avaliarFilme(scan);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarFilme(Scanner scan) {
        System.out.println("Digite o nome do filme:");
        String nome = scan.nextLine();
        System.out.println("Digite o gênero do filme:");
        String genero = scan.nextLine();
        System.out.println("Digite o ano de lançamento do filme:");
        int ano = scan.nextInt();
        scan.nextLine(); // Consumir quebra de linha residual

        filmes.add(new Filme(nome, genero, ano));
        System.out.println("Filme cadastrado com sucesso!");
    }

    private void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        System.out.println("\nFilmes cadastrados:");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, filmes.get(i));
        }
    }

    private void avaliarFilme(Scanner scan) {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado para avaliar.");
            return;
        }

        listarFilmes();
        System.out.println("Digite o número do filme que deseja avaliar:");
        int indice = scan.nextInt() - 1;

        if (indice < 0 || indice >= filmes.size()) {
            System.out.println("Número inválido.");
            return;
        }

        System.out.println("Digite sua nota para o filme (0 a 10):");
        double nota = scan.nextDouble();
        scan.nextLine(); // Consumir quebra de linha residual

        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida. A avaliação deve estar entre 0 e 10.");
            return;
        }

        filmes.get(indice).adicionarNota(nota);
        System.out.println("Avaliação registrada com sucesso!");
    }
}
