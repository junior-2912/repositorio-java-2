package Exercicios.Exercicio168.application;

import Exercicios.Exercicio168.entities.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo a ser lido: ");
        String strPath = entrada.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String linha;
            List<Produto> produtos = new ArrayList<>();

            while ((linha = br.readLine()) != null) {
                String[] produto = linha.split(",");

                produtos.add(new Produto(produto[0], Double.parseDouble(produto[1].trim()), Integer.parseInt(produto[2].trim())));
            }

            String path = "c:\\temp\\out\\summary.txt";

            boolean sucesso = new File("c:\\temp\\out").mkdir();
            System.out.println("Pasta criada com sucesso? " + sucesso);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (Produto produto : produtos) {
                    bw.write(produto.getNome() + "," + produto.valorTotal());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        entrada.close();
    }
}
