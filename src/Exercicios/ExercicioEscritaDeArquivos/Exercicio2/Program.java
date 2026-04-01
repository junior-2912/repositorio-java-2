package Exercicios.ExercicioEscritaDeArquivos.Exercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String path = "c:\\temp\\nomes.txt";
        try (Scanner sc = new Scanner(System.in); BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Digite o " + (i + 1) + "º nome: ");
                bw.write(sc.nextLine());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
