package Exercicios.ExercicioLeituraDeArquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program01 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("c:\\temp\\nomes.txt"));

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
