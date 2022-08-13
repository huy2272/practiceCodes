package Driver;
import Automobile.*;
public class Driver {

	public static void main(String[] args) {
		Ford f = new Ford(1.23, "1234");
		Car c = new Ford(1.23, "1234");
		
		System.out.println("c = f? --->" + c.equals(f));
		System.out.println("f = c? --->" + f.equals(c));
		
		Ford f2 = new Ford(1.23, "1235");
		Car c2 = new Car(1.23);
		
		System.out.println("f2 = f? " +f2.equals(f));
		System.out.println("f2 = f? " +c2.equals(c));
		
		//Single null test
		Ford f3 = null;
		System.out.println("f = f3? --> " +f.equals(f3));
	}

}
