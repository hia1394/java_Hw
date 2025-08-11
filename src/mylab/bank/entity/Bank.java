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
			System.out.println("저축 계좌가 생성되었습니다. "+account);
		}
		else{
			account = new CheckingAccount(nextAccountNumber++,name,balance,value);
			System.out.println("체킹 계좌가 생성되었습니다. "+account);
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
        throw new AccountNotFoundException("예외발생: 계좌번호 AC"+accountNumber+"에 해당하는 계좌를 찾을 수 없습니다.");
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
		System.out.println(sand+"원이 AC"+accountNum1+"에서 "+accountNum2+"로 송금되었습니다.");
	}
	public void getAllAccount() {
		for(Account account: accounts) {
			System.out.println(account);
		}
		System.out.println("==================");
	}
}
