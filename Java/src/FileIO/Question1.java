package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		
		try	{
			//File will be created in the current folder
			File file = new File("chars.txt");
			if (file.createNewFile())
				System.out.println("File Created: " + file.getName());
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		FileWriter writer = null;
		try	{
			writer = new FileWriter ("chars.txt", true);
			writer.write("Hello World!");
			writer.close();
		} catch	(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		File file = new File("chars.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String s=sc.nextLine();
				for(char c:s.toCharArray()) {
					System.out.println((int) c);
					System.out.println(c);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
