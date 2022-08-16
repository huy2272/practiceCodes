package Question4;

public class Address {
	private String Street;
	private String Country;

	public Address(String street, String country) {
		super();
		Street = street;
		Country = country;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "Address [Street=" + Street + ", Country=" + Country + "]";
	}
	
	
	
}
