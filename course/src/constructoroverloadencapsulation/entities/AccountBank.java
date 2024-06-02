package constructoroverloadencapsulation.entities;

public class AccountBank {
	private int number;
	private String holder;
	private double balance;

	public AccountBank(int number, String holder, double initialDeposit) {
		this.number = number;
		this.holder = holder;
		deposit(initialDeposit);
	}

	public AccountBank(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}

	public int getAccount() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amont) {
		balance += amont;
	}

	public void withdraw(double amont) {
		balance -= amont + 5.00;
	}

	public String toString() {
		return "Account number: " + number 
				+ ", " 
				+ "Holder: " + holder 
				+ ", " 
				+ "Balance: $" + String.format("%.2f", balance);
	}

}
