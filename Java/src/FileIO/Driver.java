package Question4;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	
	
	public static void main(String[] args) {
		Address a1 = new Address("7810" , "Vietnam");
		try {
			FileOutputStream fos = new FileOutputStream(new File("address.dat"));
			fos.write(a1.toString().getBytes());
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream out = new FileInputStream(new File("address.dat"));
			System.out.println("Displaying address");
		    int num;
		    while((num= out.read())!= -1) {
		    	System.out.print( (char) num);
		    }
		    out.close();
		} catch (IOException e) {
		    System.out.println("Fail");
		}
	}
	
}
