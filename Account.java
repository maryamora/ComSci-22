//Code created by Mary Danielle C. Amora

public class Account{

	private int accountNumber;
	private double balance = 0.0;


	public Account (int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account (int accountNumber){
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}

	public void credit(double amount){
		if (amount < 1){
			throw new IllegalArgumentException("Negative money!");
		}
		balance += amount;
	}

	public void debit(double amount){
		if (amount > balance){
			throw new IllegalArgumentException("Not enough money!");
		}
		if (amount < 1){
			throw new IllegalArgumentException("Negative money!");
		}
		balance -= amount;
	}

	public String toString(){
		return String.format("A/C no: %d, Balance = $ %.2f",accountNumber, balance);
	}


}