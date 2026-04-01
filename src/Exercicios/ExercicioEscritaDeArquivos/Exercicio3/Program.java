package Exercicios.ExercicioEscritaDeArquivos.Exercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String path = "c:\\temp\\numeros.txt";
        try (Scanner sc = new Scanner(System.in); BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Digite o " + (i+1) + "º numero:");
                int numero = sc.nextInt();
                if (numero % 2 == 0) bw.write(numero + " | Par");
                else bw.write(numero + " | Impar");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
