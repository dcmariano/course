package interfaces.model.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import interfaces.model.entities.Contract;
import interfaces.model.entities.Installment;
import interfaces.model.service.ContractService;
import interfaces.model.service.PaypalService;

public class MainContractsProcessing {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the contract details");

		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);

		System.out.print("Contract Value: ");
		double contractValue = sc.nextDouble();

		Contract contract = new Contract(number, date, contractValue);
		ContractService contractService = new ContractService(new PaypalService());

		System.out.print("Installments of number: ");
		int installments = sc.nextInt();

		contractService.processContract(contract, installments);

		System.out.println();

		System.out.println("Installments");

		for (Installment i : contract.getInstalments()) {
			System.out.println(i.getDueDate().format(fmt) + " - $" + String.format("%.2f", i.getAmount()));
		}
		sc.close();
	}

}
