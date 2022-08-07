package Banking;
import Exceptions.*;

class BankAccount {
	private String name;
	private double balance;
	private final static double depositLimit = 500;
	private final static double withdrawLimit = 500;
	
	//Constructor
	public BankAccount(String name, double balance) {
		this.setName(name);
		this.balance=balance;
	}
	
	public void deposit(double depositAmount) throws InvalidAmountException, DepositLimitException{
		if(depositAmount <= 0) {throw new InvalidAmountException("Invalid Amount");}
		if(depositAmount > depositLimit) {throw new DepositLimitException("Deposit Limit");}
		balance += depositAmount;
	}
	
	public void withdraw(double withdrawAmount) throws BankAccountException{
		if(withdrawAmount <= 0) {throw new InvalidAmountException("Invalid Amount");}
		if(withdrawAmount > withdrawLimit) {throw new NotEnoughBalanceException("Not enough money");}
		balance -= withdrawAmount;
	}
	
	//Constructor
	public BankAccount(String name) {
		this(name,0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return this.getName() + ", balance=" + balance;
	}
	
}