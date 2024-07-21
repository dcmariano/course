package interfaces.model.service;

import java.time.Duration;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;

	}

	public void processInvoice(CarRental carRental) {

		double hours = (Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes()) / 60.0;

		double basicPayment = hours <= 12.0 ? pricePerHour * Math.ceil(hours) : pricePerDay * Math.ceil(hours / 24.0);

		double tax = taxService.tax(basicPayment);

		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
