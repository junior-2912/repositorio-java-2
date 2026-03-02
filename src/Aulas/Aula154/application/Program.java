package Aulas.Aula154.application;

import Aulas.Aula154.model.entities.Reservation;

import java.lang.classfile.constantpool.LoadableConstantEntry;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("room number: ");
        int number = entrada.nextInt();
        System.out.print("checkin date: ");
        LocalDate checkin = LocalDate.parse(entrada.next(), fmt);
        System.out.print("checkout date: ");
        LocalDate checkout = LocalDate.parse(entrada.next(), fmt);

        if (checkout.isBefore(checkin)) {
            System.out.println("Error in reservation: Check out date must be after check in date");
        } else {
            Reservation reservation = new Reservation(checkin, checkout, number);
            System.out.println("reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("checkin date: ");
            checkin = LocalDate.parse(entrada.next(), fmt);
            System.out.print("checkout date: ");
            checkout = LocalDate.parse(entrada.next(), fmt);

            LocalDate now = LocalDate.now();
            if (checkin.isBefore(now) || checkout.isBefore(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future");
            } else if (checkout.isBefore(checkin)) {
                System.out.println("Error in reservation: Check out date must be after check in date");
            } else {
                reservation.updateDates(checkin, checkout);
                System.out.println("Reservarion : " + reservation);
            }
        }

        entrada.close();
    }
}
