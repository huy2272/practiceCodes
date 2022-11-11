package Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class StrikeEdgeDriver {
	public static void main(String[] args) {
		StrikeEdgeA recursiveCall = new StrikeEdgeA();
		StrikeEdgeB stckCall = new StrikeEdgeB();
		File file = new File("in.txt");
		Scanner sc;
		FileOutputStream fout;		
		try {
			sc = new Scanner(file);
			sc.nextLine();
			while (sc.hasNextLine()) {
				String s=sc.nextLine();
				String[] strArr = s.split(" ");
				int size = Integer.parseInt(strArr[0]);
				int start = Integer.parseInt(strArr[1]);
				int[] intArr = new int[size];
				for	(int i = 0; i < strArr.length-2; i++) {
					intArr[i] = Integer.parseInt(strArr[i+2]);
				}
				System.out.println(Arrays.toString(intArr));
				fout = new FileOutputStream("Out.txt", true);
				PrintWriter writer = new PrintWriter(fout);
				// Output for recursive method
				writer.write(String.valueOf(recursiveCall.solRecursive(intArr, start))+"\n");
				// Output for stack method
				writer.write(String.valueOf(stckCall.solStack(intArr, start))+"\n");
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.print("Error while reading or writing to file");
			e.printStackTrace();
		}
	}
}
