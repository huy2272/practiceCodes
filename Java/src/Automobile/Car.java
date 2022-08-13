package Automobile;

public class Car  {
	private final double MAX_TIRE_PRESSURE=5.43;
	private boolean car_on;
	private double tirePressure;
	
	public Car (double tP) {
		if (!validTirePressure(tP))
			tirePressure = MAX_TIRE_PRESSURE;
		else
			tirePressure = tP;
		car_on = false;
	}
	//Getters and Setters
	public boolean isCar_on() {
		return car_on;
	}

	public void setCar_on(boolean car_on) {
		this.car_on = car_on;
	}

	public double getMAX_TIRE_PRESSURE() {
		return MAX_TIRE_PRESSURE;
	}
	
	//Sets tire pressure if it is valid, else does nothing
	public void setTirePressure(double tire_pressure) {
		if (!validTirePressure(tire_pressure))
			return;
		this.tirePressure = tire_pressure; 
	}
	
	public double getTirePressure() {
		return tirePressure;
	}
	//End 
	
	//Turn car on
	public void startCar() {
		car_on = true;
	}
	//Turn car off
	public void shutCar() {
		car_on=false;
	}
	
	//Checks if the requested tire pressure is valid
	//Return true if tire pressure is valid or else false
	private boolean validTirePressure(double tire_pressure) {
		return (tire_pressure >= 0 && tire_pressure <= MAX_TIRE_PRESSURE);
	}
	
	//Set tire pressure to the max pressure
	public void fillTires() {
		this.tirePressure= MAX_TIRE_PRESSURE;
	}

	@Override
	public String toString() {
		return ((car_on ? "Car is ON" : "Car is OFF") + "with \n\t Tire Pressure: " + tirePressure + "psi");
		
	}
	
	public boolean equals(Object o) {
		if ( o == null)
			return false;
		if (o.getClass()== this.getClass())
		{
			Car  c = (Car ) o;
			if (this.tirePressure == c.tirePressure)
				return true;
		}
		return false;
	}

}
