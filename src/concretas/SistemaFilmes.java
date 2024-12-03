package concretas;

import abstratas.Filme;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaFilmes {

    private static List<Filme> filmes = new ArrayList<>(); // Lista para armazenar os filmes

    public static void cadastrarFilme(Scanner scan) throws IllegalArgumentException {
        System.out.println("\n--- Cadastro de Filme ---");
        System.out.print("Digite o nome do filme: ");
        String nome = scan.nextLine();

        System.out.print("Digite o gênero do filme: ");
        String genero = scan.nextLine();

        System.out.print("Digite o ano de lançamento do filme: ");
        int ano;
        try {
            ano = Integer.parseInt(scan.nextLine());
            if (ano <= 0) {
                throw new IllegalArgumentException("Ano de lançamento deve ser positivo!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ano inválido! Deve ser um número inteiro.");
        }

        filmes.add(new Filme(nome, genero, ano));
        System.out.println("Filme cadastrado com sucesso!");
    }

    public static void listarFilmes() {
        System.out.println("\n--- Lista de Filmes Cadastrados ---");

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado até o momento.");
            return;
        }

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            System.out.printf("%d. %s (%d) - Gênero: %s%n", i + 1, filme.getNome(), filme.getAno(), filme.getGenero());
        }
    }

    public static void avaliarFilme(Scanner scan) throws IndexOutOfBoundsException, IllegalArgumentException {
        System.out.println("\n--- Avaliar Filme ---");

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado para avaliação.");
            return;
        }

        listarFilmes();
        System.out.print("Digite o número do filme que deseja avaliar: ");

        int indice;
        try {
            indice = Integer.parseInt(scan.nextLine()) - 1;
            if (indice < 0 || indice >= filmes.size()) {
                throw new IndexOutOfBoundsException("Número fora do intervalo.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada inválida! Deve ser um número inteiro.");
        }

        System.out.print("Digite sua nota para o filme (0 a 10): ");
        double nota;
        try {
            nota = Double.parseDouble(scan.nextLine());
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nota inválida! Deve ser um número decimal.");
        }

        filmes.get(indice).adicionarNota(nota);
        System.out.println("Avaliação registrada com sucesso!");
    }

    public static void listarAvaliacoes() {
        System.out.println("\n--- Avaliações dos Filmes ---");

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado para listar avaliações.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.printf("%s (%d) - Gênero: %s%n", filme.getNome(), filme.getAno(), filme.getGenero());
            double media = filme.calcularMediaNotas();
            if (media > 0) {
                System.out.printf("Média de avaliações: %.2f%n", media);
            } else {
                System.out.println("Ainda não avaliado.");
            }
            System.out.println();
        }
    }

    // Método para salvar os filmes em um arquivo .txt
    public static void salvarFilmesEmArquivo() {
        try (FileWriter writer = new FileWriter("filmes.txt")) {
            for (Filme filme : filmes) {
                writer.write(filme.getNome() + ";" + filme.getGenero() + ";" + filme.getAno() + ";" + filme.calcularMediaNotas() + "\n");
            }
            System.out.println("Filmes salvos com sucesso no arquivo 'filmes.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os filmes: " + e.getMessage());
        }
    }
}
