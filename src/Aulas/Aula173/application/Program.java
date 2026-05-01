package Aulas.Aula173.application;

import Aulas.Aula173.model.entities.CarRental;
import Aulas.Aula173.model.entities.Vehicle;
import Aulas.Aula173.model.services.BrasilTaxService;
import Aulas.Aula173.model.services.RentalService;

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

        System.out.println("Entre com o preco por hora: ");
        double pricePerHour = entrada.nextDouble();
        System.out.println("Entre com o preco por dia: ");
        double pricePerDay = entrada.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrasilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("Fatura: ");
        System.out.println("Pagamento basico: " + cr.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + cr.getInvoice().getTax());
        System.out.println("Pagamento total: "+ cr.getInvoice().getTotalPayment());


        entrada.close();
    }
}
