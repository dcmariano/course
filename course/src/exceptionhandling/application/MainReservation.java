package exceptionhandling.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptionhandling.model.entities.Reservation;
import exceptionhandling.model.exceptions.DomainException;

public class MainReservation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();

			sc.nextLine();

			System.out.print("Check-in Date: ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Check-out Date: ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());

			System.out.println("\nEnter date to update reservation");

			System.out.print("Check-in Date: ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-out Date: ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());

		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} 

		sc.close();
	}

}
