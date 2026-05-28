package Exercicios.Fixacao195.application;

import Exercicios.Fixacao195.application.application.EntradaLogin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo: ");
        String path = entrada.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Set<EntradaLogin> usuarios = new HashSet<>();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] linhas = linha.split(" ");
                String nome = linhas[0];
                Instant instante = Instant.parse(linhas[1]);
                LocalDateTime data = LocalDateTime.ofInstant(instante, ZoneId.systemDefault());
                usuarios.add(new EntradaLogin(nome, data));
            }

            System.out.print("Total de usuarios: " + usuarios.size());

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        entrada.close();
    }
}
