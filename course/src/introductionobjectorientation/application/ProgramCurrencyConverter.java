package introductionobjectorientation.application;

import java.util.Scanner;

import introductionobjectorientation.util.CurrencyConverter;

public class ProgramCurrencyConverter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Whats is the dollar price?");
		double quotation = sc.nextDouble();
		System.out.println("How many dollars will be bought?");
		double valueQuantity = CurrencyConverter.converter(quotation, sc.nextDouble());
		System.out.printf("Amount to be paid in reais = R$%.2f", valueQuantity);
	
		sc.close();
	}

}
