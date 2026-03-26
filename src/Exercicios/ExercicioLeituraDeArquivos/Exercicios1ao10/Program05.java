package Exercicios.ExercicioLeituraDeArquivos.Exercicios1ao10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;

public class Program05 {
    public static void main(String[] args) {
        String path = "c:\\temp\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.isEmpty()) {
                    String[] pessoas = linha.split(",");
                    String pessoa = pessoas[0].trim();
                    int idade = Integer.parseInt(pessoas[1].trim());
                    if (idade >= 21){
                        System.out.println(pessoa + " " + idade);
                    }
                }
            }
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
