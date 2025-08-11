package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account{
	private float withdrawalimit;
	
	public CheckingAccount(int accountNum, String name, float balance,float withdrawalimit) {
		super(accountNum, name, balance);
		this.withdrawalimit = withdrawalimit;
	}
	
    public void withdraw(float amount) throws InsufficientBalanceException{
        if (amount > withdrawalimit) {
            throw new WithdrawalLimitExceededException("예외발생: 출금한도를 초과했습니다. 한도: "+withdrawalimit);
        }
        super.withdraw(amount);
    }
	
	@Override
	public String toString() {
		return super.toString()+"출금한도: "+withdrawalimit+"원";
	}

}
