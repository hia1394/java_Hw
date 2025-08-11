package mylab.bank.entity;

public class SavingsAccount extends Account{

	private float interestRate;
	
	public SavingsAccount(int accountNum, String name, float balance,float interestRate) {
		super(accountNum, name, balance);
		this.interestRate = interestRate;
	}
	
	public void interest() {
		float inter = (balance *(interestRate/100));
		deposit(inter);
		System.out.println("이자 "+inter+"원이 적용되었습니다. 현재 잔액: "+balance+"원");
	}
	
	@Override
	public String toString() {
		
		return super.toString()+"이자율: "+interestRate+"%";
	}
}
