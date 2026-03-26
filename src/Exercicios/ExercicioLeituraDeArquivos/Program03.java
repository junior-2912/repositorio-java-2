package Exercicios.ExercicioLeituraDeArquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program03 {
    public static void main(String[] args) {

        String caminho = "c:\\temp\\pessoas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;

            int somaIdades = 0;
            int quantidade = 0;

            int maiorIdade = Integer.MIN_VALUE;
            String nomeMaisVelho = "";

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(",");

                String nome = partes[0];
                int idade = Integer.parseInt(partes[1]);

                // Soma e contagem
                somaIdades += idade;
                quantidade++;

                // Verifica mais velho
                if (idade > maiorIdade) {
                    maiorIdade = idade;
                    nomeMaisVelho = nome;
                }
            }

            double media = (double) somaIdades / quantidade;

            System.out.println("Pessoa mais velha: " + nomeMaisVelho);
            System.out.println("Idade: " + maiorIdade);
            System.out.println("Média das idades: " + media);

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}