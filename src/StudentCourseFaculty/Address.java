package StudentCourseFaculty;

public class Address {
	
	private String street, city;
	
	Address(){
		
	}
	
	Address(String street, String city) {
		this.setStreet(street);
		this.setCity(city);
	}
	
	
	
	public String getStreet () {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	public String toString() {
		return "Street: " + street + ", City: " + city;
	}


}
