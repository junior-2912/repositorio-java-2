package Exercicios.ExercicioLeituraDeArquivos.Exercicios1ao10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program01 {
    public static void main(String[] args) {
        try {
            Scanner sc;
            int contador = 0;
            int contadorCaracteres = 0;
            sc = new Scanner(new File("c:\\temp\\in.txt"));
            while (sc.hasNextLine()) {
                contador++;
                String palavraLinha = sc.nextLine();
                contadorCaracteres += palavraLinha.length();
            }
            System.out.println(contador);
            System.out.println(contadorCaracteres);

            sc.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
