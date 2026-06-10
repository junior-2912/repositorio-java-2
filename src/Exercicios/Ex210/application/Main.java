package Exercicios.Ex210.application;

import Exercicios.Ex210.entities.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria uma lista para armazenar objetos Produto
        List<Produto> produtos = new ArrayList<>();

        // Try-with-resources: abre o arquivo de entrada e garante o fechamento automático
        try (BufferedReader bf = new BufferedReader(new FileReader("c:\\windows\\temp\\in.txt"))) {
            String linha;

            // Lê cada linha do arquivo até encontrar o final (null)
            while ((linha = bf.readLine()) != null) {
                // Divide a linha pelo delimitador "," para extrair nome e preço
                String[] splitProducts = linha.split(",");
                String nome = splitProducts[0];
                double preco = Double.parseDouble(splitProducts[1]);

                // Adiciona um novo Produto à lista
                produtos.add(new Produto(nome, preco));
            }
            
            // Calcula a média dos preços usando stream
            // map: extrai os preços | reduce: soma todos e divide pelo tamanho da lista
            double media = produtos.stream()
                    .map(Produto::getPreco)
                    .reduce(0.0, (acumulador, numero) -> acumulador + numero / produtos.size());

            // Exibe a média com 2 casas decimais
            System.out.println("Media: " + String.format("%.2f", media));

            // Filtra produtos com preço menor que a média,
            // ordena por nome em ordem reversa (Z-A),
            // extrai apenas o nome e imprime cada um
            produtos.stream().filter(produto -> produto.getPreco() < media)
                    .sorted(Comparator.comparing(Produto::getNome).reversed())
                    .map(Produto::getNome)
                    .forEach(System.out::println);

        } catch (IOException e) {
            // Trata exceções de entrada/saída (arquivo não encontrado, erro ao ler, etc)
            System.out.println(e.getMessage());
        }
    }
}
