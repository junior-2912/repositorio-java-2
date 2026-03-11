package Exercicios.ExercicioTratamentoExcecoes.application;

import Exercicios.ExercicioTratamentoExcecoes.entities.Conta;
import Exercicios.ExercicioTratamentoExcecoes.exceptions.LimiteEstouradoException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("Entre com os dados da conta: ");
            System.out.println("Numero: ");
            int numero = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Titular: ");
            String titular = entrada.nextLine();
            System.out.println("Saldo Inicial: ");
            double saldoInicial = entrada.nextDouble();
            System.out.println("Limite de saque: ");
            double limiteSaque = entrada.nextDouble();

            Conta conta1 = new Conta(titular, saldoInicial, numero, limiteSaque);

            System.out.println("Digite o valor para saque: ");
            conta1.saque(entrada.nextDouble());
            System.out.println(conta1);
        } catch (LimiteEstouradoException e) {
            System.out.println("Erro no saque: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }




        entrada.close();
    }
}
