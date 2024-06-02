package inheritancepolymorphism.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inheritancepolymorphism.entities.Company;
import inheritancepolymorphism.entities.Individual;
import inheritancepolymorphism.entities.TaxPayer;

public class MainTaxPayer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of tax payers: ");
		int payers = sc.nextInt();

		List<TaxPayer> taxPayers = new ArrayList<>();

		for (int i = 0; i < payers; i++) {
			System.out.println("\nTax payer #" + (i + 1) + " data:");

			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if (type == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				taxPayers.add(new Company(name, annualIncome, numberOfEmployees));
			} else {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				taxPayers.add(new Individual(name, annualIncome, healthExpenditures));
			}

		}

		double totalTaxes = 0;
		System.out.println("\nTAXES PAYD:");
		for (TaxPayer i : taxPayers) {
			System.out.println(i.getName() + ": $" + String.format("%.2f", i.tax()));
			totalTaxes += i.tax();

		}
		System.out.print("\nTOTAL TAXES: $" + String.format("%.2f", totalTaxes));

		sc.close();
	}

}
