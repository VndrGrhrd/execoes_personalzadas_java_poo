package app;

import model.entiti.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Room number: ");
            int room = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(room, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter date to update the reservation");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);

            sc.close();
        }catch (ParseException e){
            System.out.println("Invalid date format");
        }catch (DomainException e){
            System.out.println("Error in reservation Error: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Unexpected Error");
        }

    }
}
