package Exceptions;

public class BankAccountException extends Exception{

	public BankAccountException(String message) {
		super();
		System.out.println(message);
	}

}
