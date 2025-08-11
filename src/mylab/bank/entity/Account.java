package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
	protected int accountNum;
	protected String name;
	protected float balance;

	public Account(int accountNum, String name, float balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}

	
	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void deposit(float amount) {
		System.out.println(amount+"원이 입금되었습니다.");
		this.balance += amount;
		System.out.println("현재 잔액: "+balance+"원");
	}
	
	public void withdraw(float amount) throws InsufficientBalanceException{
		if(amount>this.balance) {
			String errMessage = String.format("잔액이 부족합니다.", amount);
			
			throw new InsufficientBalanceException(errMessage);
		}
		else
			System.out.println(amount+"원이 출금되었습니다.");
			this.balance -= amount;
			System.out.println("현재 잔액: "+balance+"원");
	}
	
	@Override
	public String toString() {
		return String.format("계좌번호: AC%d, 소유자: %s, 잔액: %.1f,",accountNum, name,balance);
	}
}
