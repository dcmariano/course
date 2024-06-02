package exceptionhandling.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptionhandling.model.entities.ReservationBadSolution;

public class MainReservationBadSolution {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		sc.nextLine();

		System.out.print("Check-in Date: ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check-out Date: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			ReservationBadSolution reservation = new ReservationBadSolution(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());

			System.out.println("\nEnter date to update reservation");

			System.out.print("Check-in Date: ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-out Date: ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);

			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation.toString());
			}

		}

		sc.close();

	}

}
