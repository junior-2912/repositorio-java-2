package Exercicios.ExercicioFixacao177.application;

import Exercicios.ExercicioFixacao177.entities.Contrato;
import Exercicios.ExercicioFixacao177.services.Paypal;
import Exercicios.ExercicioFixacao177.services.ServicoContrato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre com os dados do contrato:");

        System.out.print("Numero: ");
        int nContrato = entrada.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        entrada.nextLine();
        LocalDate data = LocalDate.parse(entrada.nextLine(), fmt);

        System.out.print("Valor do contrato: ");
        double valorContrato = entrada.nextDouble();
        System.out.print("Entre com o numero de parcelas: ");
        int nParcelas = entrada.nextInt();

        Contrato contrato = new Contrato(data, nContrato, valorContrato);
        ServicoContrato servicoContrato = new ServicoContrato(new Paypal());

        System.out.println("Parcelas: ");
        servicoContrato.processarContrato(contrato, nParcelas);

        entrada.close();
    }
}
