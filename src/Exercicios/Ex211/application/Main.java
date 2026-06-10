package Exercicios.Ex211.application;

import Exercicios.Ex211.entities.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        try (BufferedReader bf = new BufferedReader(new FileReader("c:\\windows\\temp\\in.txt"))) {
            String linha;
            while ((linha = bf.readLine()) != null) {
                String[] funcionariosSplit = linha.split(",");

                String nome = funcionariosSplit[0];
                String email = funcionariosSplit[1];
                double salario = Double.parseDouble(funcionariosSplit[2]);

                funcionarios.add(new Funcionario(nome, email, salario));
            }
            System.out.print("Digite um salario: ");
            double salarioParaFiltro = entrada.nextDouble();

            System.out.println("Email dos funcionario com salario maior que " + salarioParaFiltro);
            funcionarios.stream()
                    .filter(funcionario -> funcionario.getSalario() > salarioParaFiltro)
                    .map(Funcionario::getEmail)
                    .sorted()
                    .forEach(System.out::println);

            Predicate<Funcionario> somaBaseadaEmLetra = funcionario -> funcionario.getNome().toUpperCase().charAt(0) == 'M';
            System.out.println("Soma dos salarios das pessoas cujo nome inicia com 'M': " + String.format("%.2f", somaSalarioLetra(funcionarios, somaBaseadaEmLetra)));

            entrada.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double somaSalarioLetra(List<Funcionario> lista, Predicate<Funcionario> predicate) {
        double soma = 0;
        for (Funcionario funcionario : lista) {
            if (predicate.test(funcionario)) {
                soma += funcionario.getSalario();
            }
        }
        return soma;
    }
}
