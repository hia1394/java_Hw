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
		System.out.println(amount+"���� �ԱݵǾ����ϴ�.");
		this.balance += amount;
		System.out.println("���� �ܾ�: "+balance+"��");
	}
	
	public void withdraw(float amount) throws InsufficientBalanceException{
		if(amount>this.balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�.", amount);
			
			throw new InsufficientBalanceException(errMessage);
		}
		else
			System.out.println(amount+"���� ��ݵǾ����ϴ�.");
			this.balance -= amount;
			System.out.println("���� �ܾ�: "+balance+"��");
	}
	
	@Override
	public String toString() {
		return String.format("���¹�ȣ: AC%d, ������: %s, �ܾ�: %.1f,",accountNum, name,balance);
	}
}
