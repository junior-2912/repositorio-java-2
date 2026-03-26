package Exercicios.ExercicioLeituraDeArquivos.Exercicios1ao10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program02 {
    public static void main(String[] args) {
        String path = "c:\\temp\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            int contadorPares = 0;
            while ((linha = br.readLine()) != null) {
                if (!linha.isEmpty()) {
                    int numero = Integer.parseInt(linha);

                    if (numero % 2 == 0) {
                        contadorPares++;
                        System.out.println(numero);
                    }
                }
            }

            System.out.println("Quantidade de pares: " + contadorPares);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
