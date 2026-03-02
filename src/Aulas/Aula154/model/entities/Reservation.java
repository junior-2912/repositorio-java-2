package Aulas.Aula154.model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(LocalDate checkIn, LocalDate checkOut, Integer roomNumber) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration() {
        return this.checkOut.getDayOfMonth() - this.checkIn.getDayOfMonth();
        // ou:
        // return checkOut.getDays - checkIn.getDays;
    }

    public void updateDates (LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", checkIn: "
                + checkIn.format(fmt)
                + ", checkout: "
                + fmt.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
