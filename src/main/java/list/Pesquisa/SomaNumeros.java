package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numerosList;

    public SomaNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numerosList.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        for (Integer i : numerosList) {
            soma += i;
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maior = 0;
        for (Integer i : numerosList) {
            if (i > maior) {
                maior = i;
            }
        }
        return maior;
    }

    public int encontrarMenorNumero() {
        int menor = 0;
        if (!numerosList.isEmpty()) {
            menor = numerosList.getFirst();
            for (Integer i : numerosList) {
                if (i < menor) {
                    menor = i;
                }
            }
        }
        return menor;
    }

    public List<Integer> exibirNumeros() {
        return numerosList;
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.exibirNumeros());

        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(100);

        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.exibirNumeros());
    }
}
