package exceptionhandling.application;

import java.util.Scanner;

import exceptionhandling.model.entities.Account;
import exceptionhandling.model.exceptions.BusinessException;

public class MainAccount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, initialBalance, withdrawLimit);

			System.out.print("\nEnter the amount to withdraw: ");
			account.withDraw(sc.nextDouble());
			System.out.print("New balance: $" + String.format("%.2f", account.getBalance()));

		} catch (BusinessException e) {
			System.out.print("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.print("Unexpected error");
		} finally {
			sc.close();
		}
	}
}
