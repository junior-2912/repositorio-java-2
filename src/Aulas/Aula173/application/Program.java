package Aulas.Aula173.application;

import Aulas.Aula173.model.entities.CarRental;
import Aulas.Aula173.model.entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre com os dados do aluguel: ");
        System.out.println("Modelo do carro: ");
        String carModel = entrada.nextLine();
        System.out.println("Retirada: ");
        LocalDateTime start = LocalDateTime.parse(entrada.nextLine(), formatter);
        System.out.println("Retorno: ");
        LocalDateTime finish = LocalDateTime.parse(entrada.nextLine(), formatter);


        CarRental cr = new CarRental(finish, start, new Vehicle(carModel));


        entrada.close();
    }
}
