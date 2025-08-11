package mylab.bank.control;

import javax.security.auth.login.AccountNotFoundException;

import mylab.bank.entity.*;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		
		System.out.println("====계좌생성====");
		Account savingsAccount = bank.createAccount("홍길동", "Saving", 10000,3);
		Account checkingsAccount = bank.createAccount("홍길동", "Checking", 20000, 5000);
		bank.createAccount("이영희", "Saving", 30000,2);
		
		System.out.println("====모든 계좌 목록====");
		bank.getAllAccount();
		
		System.out.println("====입금/출금 테스트====");
		savingsAccount.deposit(5000);
		try {
			checkingsAccount.withdraw(3000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("====이자 적용 테스트====");
		((SavingsAccount) savingsAccount).interest();

		System.out.println("====계좌 이체 테스트====");
		bank.sanding(1002, 1001, 5000);
		
		System.out.println("====모든 계좌 목록====");
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
