package FileIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Question3 {
	public static void main(String[] args) {
		
		try {
			FileInputStream out = new FileInputStream(new File("question11.dat"));
			System.out.println("Displaying int");
		    int num;
		    while((num= out.read())!= -1) {
		    	System.out.println( (char) num);
		    }
		    out.close();
		} catch (IOException e) {
		    System.out.println("Fail");
		}
		
	}
}
