package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Censor {

	
	public static void main(String[] args) {
		
		try {
			File source = new File("source.txt");
			File badList = new File("badList.txt");
			File destination = new File("destination.txt");
			if	(source.createNewFile()&& badList.createNewFile() && destination.createNewFile()) {
				System.out.println(source.getName() + " was created");
				System.out.println(badList.getName() + " was created");
				System.out.println(destination.getName() + " was created");
			} else {System.out.println("Files already exist");}
			
			PrintWriter writer = new PrintWriter("badList.txt");
			writer.write("foo,bar");
			writer.close();
			PrintWriter srcWriter = new PrintWriter("source.txt");
			srcWriter.write("The prof uses foo and bar too often in class. It is like being in a barn.");
			srcWriter.close();
			
			censor(source,destination,badList);
		} catch (IOException e) {System.out.println("Fail");e.printStackTrace();}
	      
		
	}
	
	public static void censor(File source, File destination, File badlist) {
		String src = "";
		String list = "";
		
		try {
			//Read the source and badList files
			Scanner badSc = new Scanner(badlist);
			while (badSc.hasNextLine()) {list = badSc.nextLine();}
			badSc.close();
			
			Scanner sc = new Scanner(source);
			while (sc.hasNextLine()) {src = sc.nextLine();}
			sc.close();
			

			//Create a string array of bad words
			String[] bad = list.split(",");
			
			for (int i=0; i < bad.length;i++) {
				System.out.println(bad[i]);
			}
			String dest = "";
			
			//Replacing each bad word with an appropriate size "*"
			for	(String i:bad) {
				int length = i.length();
				String ast = "*";
				for(int j = 0; j<length-1;j++) {
					ast+="*";
				}
				dest = src.replace(i, ast);
			}
			System.out.println(dest);
			
			PrintWriter writer = new PrintWriter(destination);
			writer.write(dest);
			writer.close();
		} catch (FileNotFoundException e) {e.printStackTrace();System.out.println("File not found");}
	}
}
