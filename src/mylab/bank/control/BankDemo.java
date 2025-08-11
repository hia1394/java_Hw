package mylab.bank.control;

import javax.security.auth.login.AccountNotFoundException;

import mylab.bank.entity.*;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		
		System.out.println("====���»���====");
		Account savingsAccount = bank.createAccount("ȫ�浿", "Saving", 10000,3);
		Account checkingsAccount = bank.createAccount("ȫ�浿", "Checking", 20000, 5000);
		bank.createAccount("�̿���", "Saving", 30000,2);
		
		System.out.println("====��� ���� ���====");
		bank.getAllAccount();
		
		System.out.println("====�Ա�/��� �׽�Ʈ====");
		savingsAccount.deposit(5000);
		try {
			checkingsAccount.withdraw(3000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("====���� ���� �׽�Ʈ====");
		((SavingsAccount) savingsAccount).interest();

		System.out.println("====���� ��ü �׽�Ʈ====");
		bank.sanding(1002, 1001, 5000);
		
		System.out.println("====��� ���� ���====");
		bank.getAllAccount();
		
		
		try {
			checkingsAccount.withdraw(6000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		try {
			checkingsAccount.withdraw(10000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			bank.getAccount(9999);
		}catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}


}
