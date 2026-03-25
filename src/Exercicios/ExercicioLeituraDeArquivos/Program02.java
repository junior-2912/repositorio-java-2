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
            BufferedReader bf = new BufferedReader(new FileReader("c:\\temp\\numeros.txt"));

            String linha;
            int soma = 0;
            int maior = Integer.MIN_VALUE;
            int menor = Integer.MAX_VALUE;

            while ((linha = bf.readLine()) != null) {
                int numero = Integer.parseInt(linha);

                soma += numero;

                if (numero > maior){
                    maior = numero;
                }
                if (numero < menor){
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
