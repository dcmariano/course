package interfaces.model.application;

import java.util.Scanner;

import interfaces.model.service.BrazilInterestService;
import interfaces.model.service.UsaInterestService;

public class MainInterestService {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();
		System.out.println("Payments after " + months + " months");
		BrazilInterestService bis = new BrazilInterestService(1.0);
		UsaInterestService usais = new UsaInterestService(2.0);
		double paymentBis = bis.payment(amount, months);
		double paymentUsa = usais.payment(amount, months);

		System.out.println("Brazil interest service: $" + String.format("%.2f", paymentBis));
		System.out.println("USA interest service: $" + String.format("%.2f", paymentUsa));

		sc.close();
	}

}
