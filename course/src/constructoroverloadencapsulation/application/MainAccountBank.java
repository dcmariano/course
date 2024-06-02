package constructoroverloadencapsulation.application;

import java.util.Scanner;

import constructoroverloadencapsulation.entities.AccountBank;

public class MainAccountBank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountBank accountBank = null;

		System.out.print("Enter account number: ");
		int account = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter account holder: ");
		String holder = sc.nextLine();
		System.out.print("Is there an initial deposit (y/n)? ");

		char choice;

		do {
			choice = Character.toLowerCase(sc.next().charAt(0));
			if (choice != 'y' && choice != 'n') {
				System.out.print("Enter a valid answer, you have an initial deposit (y/n)? ");
			}
		} while (choice != 'y' && choice != 'n');

		if (choice == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			accountBank = new AccountBank(account, holder, initialDeposit);

		} else if (choice == 'n') {
			accountBank = new AccountBank(account, holder);
		}

		System.out.println("\nAccount Data \n" + accountBank + "\n");

		System.out.print("Enter a deposit value: ");
		accountBank.deposit(sc.nextDouble());
		System.out.println("\nUpdated account data \n" + accountBank + "\n");

		System.out.print("Enter a withdraw value: ");
		accountBank.withdraw(sc.nextDouble());
		System.out.println("\nUpdated account data \n" + accountBank);

		sc.close();
	}

}
