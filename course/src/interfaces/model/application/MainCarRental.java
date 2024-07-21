package interfaces.model.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Vehicle;
import interfaces.model.service.BrazilTaxService;
import interfaces.model.service.RentalService;

public class MainCarRental {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter rental details");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();

		System.out.print("Pick-up (dd/MM/yyyy HH:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

		System.out.print("Drop-off (dd/MM/yyyy HH:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter the price per hour: ");
		double pricePerHour = sc.nextDouble();

		System.out.print("Enter the price per day: ");
		double pricePerDay = sc.nextDouble();

		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(carRental);

		System.out.println("INVOICE");
		System.out.println("Basic Payment: $" + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: $" + String.format("%.2f", carRental.getInvoice().getTax()));

		System.out.println("Total payment: $" + String.format("%.2f", carRental.getInvoice().totalPayment()));

		sc.close();
	}

}
