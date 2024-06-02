package exceptionhandling.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptionhandling.model.entities.ReservationVeryBadSolution;

public class MainReservationVeryBadSolution {

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
			ReservationVeryBadSolution reservation = new ReservationVeryBadSolution(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());

			System.out.println("\nEnter date to update reservation");

			System.out.print("Check-in Date: ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-out Date: ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();

			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");

			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation.toString());
			}

		}

		sc.close();

	}

}
