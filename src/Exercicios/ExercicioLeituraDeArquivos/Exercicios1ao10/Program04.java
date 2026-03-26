package Exercicios.ExercicioLeituraDeArquivos.Exercicios1ao10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program04 {
    public static void main(String[] args) {
        String path = "c:\\temp\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] numerosString = linha.split(",");
                int somaLinha = 0;
                for (String numero : numerosString) {
                    somaLinha += Integer.parseInt(numero.trim());
                }
                System.out.println(somaLinha);
            }


        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
