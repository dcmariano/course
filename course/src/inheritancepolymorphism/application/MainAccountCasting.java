package inheritancepolymorphism.application;

import inheritancepolymorphism.entities.Account;
import inheritancepolymorphism.entities.BusinessAccount;
import inheritancepolymorphism.entities.SavingsAccount;

public class MainAccountCasting {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Account acc = new Account(1001, "Davi", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "João", 0.0, 500.0);

		// UPCASTING
		
		@SuppressWarnings("unused")
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Marco", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

		// DOWNCASTING

		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);

		// BusinessAccount acc5 = (BusinessAccount) acc3;

		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(100.0);
			System.out.println("Loan!");
		}

		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
	}
}
