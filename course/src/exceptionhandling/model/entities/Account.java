package exceptionhandling.model.entities;

import exceptionhandling.model.exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withDraw(Double amount) {
		if (balance < amount) {
			throw new BusinessException("Not enough balance");
		}
		if (amount > withDrawLimit) {
			throw new BusinessException("The amount exceeds the withdrawal limit");
		}
		balance -= amount;
	}
}
