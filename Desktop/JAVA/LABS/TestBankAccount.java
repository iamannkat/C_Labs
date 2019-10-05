import java.util.ArrayList;

class BankAccount
{
	private double ammount = 0;
	
	public void deposit(double depos)
	{
		ammount += depos;
	}
	
    public double withdraw(double draw){
		if (ammount> draw){
			ammount -= draw ;
			return draw;
		}else{
			return 0;
		}
	}
	public void printStatement(){
		System.out.println("The balance in the account is:  " + ammount);
		for (String[] activity){
			System.out.println(namearray)
		} 
	}
}
class TestBankAccountPlus
{
	public static void main(String args[]){
		ArrayList<String[]> activity = new ArrayList<String[]>();
		BankAccountPlus myaccount = new BankAccountPlus();
		double pocketmoney = 0;
		myaccount.deposit(100);
		activity.add(100.toString);
		pocketmoney += myaccount.withdraw(50);
		myaccount.deposit(100);
		myaccount += myaccount.withdraw(200);
		System.out.println("Pocket money: " + pocketmoney); 
		activity.add(
		
		
		}
}
