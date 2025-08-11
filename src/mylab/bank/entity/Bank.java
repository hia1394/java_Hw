package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
	private List<Account> accounts;
	private int nextAccountNumber; 
	public Bank() {
		accounts = new ArrayList<>();
		nextAccountNumber = 1000;
	}
	
	public Account createAccount(String name, String accountType,float balance,float value) {
		Account account;
		if(accountType.equalsIgnoreCase("Saving")) {
			account = new SavingsAccount(nextAccountNumber++,name,balance,value);
			System.out.println("���� ���°� �����Ǿ����ϴ�. "+account);
		}
		else{
			account = new CheckingAccount(nextAccountNumber++,name,balance,value);
			System.out.println("üŷ ���°� �����Ǿ����ϴ�. "+account);
		}
		accounts.add(account);
		return account;
	}
	public Account getAccount(int accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNum() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("���ܹ߻�: ���¹�ȣ AC"+accountNumber+"�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }
	
	public void sanding(int accountNum1,int accountNum2,float sand) {
		for(Account account: accounts) {
			if (account.getAccountNum() == accountNum1) {
				try {
					account.withdraw(sand);
				} catch (InsufficientBalanceException e) {
					System.out.println(e.getMessage());
				}
			}
			if(account.getAccountNum()== accountNum2) {
				account.deposit(sand);
			}
		}
		System.out.println(sand+"���� AC"+accountNum1+"���� "+accountNum2+"�� �۱ݵǾ����ϴ�.");
	}
	public void getAllAccount() {
		for(Account account: accounts) {
			System.out.println(account);
		}
		System.out.println("==================");
	}
}
