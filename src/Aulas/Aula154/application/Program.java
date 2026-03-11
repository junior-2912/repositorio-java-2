package Aulas.Aula154.application;

import Aulas.Aula154.model.entities.Reservation;
import Aulas.Aula154.model.exceptions.DomainException;

import java.lang.classfile.constantpool.LoadableConstantEntry;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        try {
            Scanner entrada = new Scanner(System.in);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("room number: ");
            int number = entrada.nextInt();
            System.out.print("checkin date: ");
            LocalDate checkin = LocalDate.parse(entrada.next(), fmt);
            System.out.print("checkout date: ");
            LocalDate checkout = LocalDate.parse(entrada.next(), fmt);

            Reservation reservation = new Reservation(checkin, checkout, number);
            System.out.println("reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("checkin date: ");
            checkin = LocalDate.parse(entrada.next(), fmt);
            System.out.print("checkout date: ");
            checkout = LocalDate.parse(entrada.next(), fmt);

            reservation.updateDates(checkin, checkout);

            System.out.println("Reservation : " + reservation);
            entrada.close();
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
    }
}

