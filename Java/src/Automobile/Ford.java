package Automobile;
public class Ford extends Car {
	private final String password = "2112YYZ";
	private String Id;
	
	//Constructor
	public Ford(double tire_pressure, String id) {
		super(tire_pressure);
		Id = id;
	}
	
	//Setters and Getters
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return password;
	}
	//End
	public void startCar(String password) {
		
		if(this.getPassword() == password)
			System.out.println("Special Features Activated");
		super.startCar();
	}


	@Override
	public String toString() {
		return super.toString() + "\n\t This is a Ford with ID" + Id;
	}
	
	public boolean equals(Object o) {
		if ( o == null)
			return false;
		if (o.getClass()== this.getClass())
		{
			Ford f = (Ford) o;
			//Check if pressure and id is the same
			if ((this.getTirePressure() == f.getTirePressure()) && this.Id == f.Id)
				return true;
		}
		return false;
	}
}
