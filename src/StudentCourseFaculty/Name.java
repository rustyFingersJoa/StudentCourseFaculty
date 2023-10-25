package StudentCourseFaculty;

public class Name {

	private String firstName, lastName, name;

	public Name(){
		
	}
	
	public Name(String name) {
		this.setName(name);
	}
	
	public Name (String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String toString() {
		if (name != null)
		    return name + " ";
		else
			return firstName + " " + lastName;
			
	}

}
