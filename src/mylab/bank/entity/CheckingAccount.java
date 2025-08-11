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
            throw new WithdrawalLimitExceededException("���ܹ߻�: ����ѵ��� �ʰ��߽��ϴ�. �ѵ�: "+withdrawalimit);
        }
        super.withdraw(amount);
    }
	
	@Override
	public String toString() {
		return super.toString()+"����ѵ�: "+withdrawalimit+"��";
	}

}
