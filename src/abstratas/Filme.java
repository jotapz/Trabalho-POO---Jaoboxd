package abstratas;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String nome;
    private String genero;
    private int ano;
    private List<Double> notas;

    public Filme(String nome, String genero, int ano) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.notas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getAno() {
        return ano;
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public double calcularMediaNotas() {
        if (notas.isEmpty()) {
            return 0; // Retorna 0 caso não existam notas
        }
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    @Override
    public String toString() {
        return String.format(
                "%s (%d) - Gênero: %s - Média de Notas: %.2f",
                nome, ano, genero, calcularMediaNotas()
        );
    }
}
