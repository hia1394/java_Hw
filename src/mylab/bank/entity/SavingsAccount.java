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
		System.out.println("���� "+inter+"���� ����Ǿ����ϴ�. ���� �ܾ�: "+balance+"��");
	}
	
	@Override
	public String toString() {
		
		return super.toString()+"������: "+interestRate+"%";
	}
}
