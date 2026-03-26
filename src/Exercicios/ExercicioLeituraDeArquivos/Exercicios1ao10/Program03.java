package Exercicios.ExercicioLeituraDeArquivos.Exercicios1ao10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program03 {
    public static void main(String[] args) {
        String path = "c:\\temp\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String maiorPalavra = "";
            int maiorTamanho = 0;
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.length() > maiorTamanho){
                    maiorPalavra = linha;
                    maiorTamanho = linha.length();
                }
            }

            System.out.println(maiorPalavra);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
