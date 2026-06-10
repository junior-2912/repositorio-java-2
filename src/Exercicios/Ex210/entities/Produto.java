package Exercicios.Ex210.entities;

// Classe que representa um Produto com nome e preço
public class Produto {
    // Atributo que armazena o nome do produto
    private String nome;

    // Atributo que armazena o preço do produto
    private double preco;

    // Construtor que inicializa um Produto com nome e preço
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getter para obter o nome do produto
    public String getNome() {
        return nome;
    }

    // Getter para obter o preço do produto
    public double getPreco() {
        return preco;
    }

    // Sobrescreve o método toString para exibir o produto no formato: "nome - preco"
    @Override
    public String toString() {
        return nome + " - " + preco;
    }
}
