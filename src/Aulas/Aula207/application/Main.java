package Aulas.Aula207.application;

import Aulas.Aula207.entities.Produto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(new Produto("Tv", 900),
                new Produto("Mouse", 50),
                new Produto("Tablet", 350.5),
                new Produto("HD Case", 80.90));

        System.out.println(somaFiltrada(produtos, produto -> produto.getNome().toUpperCase().charAt(0) == 'T'));


    }

    public static double somaFiltrada(List<Produto> lista, Predicate<Produto> predicate) {
        double soma = 0;
        for (Produto produto : lista) {
            if (predicate.test(produto)) {
                soma += produto.getPreco();
            }
        }
        return soma;
    }
}
