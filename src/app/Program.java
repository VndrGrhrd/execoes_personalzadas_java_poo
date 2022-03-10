package app;

import model.entities.Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        System.out.print("Room number: ");
        int room = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(room, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter date to update the reservation");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error =  reservation.updateDates(checkIn, checkOut);

            if(error != null){
                System.out.println("Error in reservation: " + error);
            }else{
                System.out.println(reservation);
            }
        }

        sc.close();
    }
}
