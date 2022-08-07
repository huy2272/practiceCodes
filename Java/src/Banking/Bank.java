package Banking;
import Exceptions.BankAccountException;

public class Bank {
	public static void main(String[] args) {
		BankAccount acc = new BankAccount("Huy", 200);
		
		try {
			acc.withdraw(100);
			acc.deposit(600);
		} catch (BankAccountException e) {
			System.out.println("Bankaccount exception" + e);
		}
		
		System.out.println(acc);
	}
}
