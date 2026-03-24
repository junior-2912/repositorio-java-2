package Exercicios.ExercicioLeituraDeArquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program02 {
    public static void main(String[] args) {
        try {
            List<Integer> numeros = new ArrayList<>();
            BufferedReader bf = new BufferedReader(new FileReader("c:\\temp\\numeros.txt"));
            String linha = bf.readLine();
            while (linha != null) {
                numeros.add(Integer.parseInt(linha));
                linha = bf.readLine();
            }
            int soma = 0;
            int maior = Integer.MIN_VALUE;
            int menor = Integer.MAX_VALUE;
            for (Integer numero : numeros) {
                soma += numero;
                if (maior < numero) {
                    maior = numero;
                }
                if (menor > numero) {
                    menor = numero;
                }
            }

            System.out.println(soma);
            System.out.println(menor);
            System.out.println(maior);


            bf.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
