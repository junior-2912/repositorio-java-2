package Exercicios.ExercicioEscritaDeArquivos.Exercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        String path = "c:\\temp\\out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Estou aprendendo Java");
            bw.newLine();
            bw.write("Escrita de arquivos é legal");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
