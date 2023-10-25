package StudentCourseFaculty;

public class NonGraduate extends Student {
	
	public NonGraduate(Name name, Address address, int id) {
			this.setName(name);
			this.setAddress(address);
			this.setId(id);
	}
	
	public double getAverageGrade() {
		double avg = 0;
		int sum = 0;
		int counter = 0;
		
		for (int i = 0; i < this.getCourse().size(); i++) {
			sum += this.getCourse().get(i).getGrade();
			counter++;
		} avg = sum/counter;
		
		return avg;
	}
	
	public void addCourse (Course obj) {
		this.getCourse().add(obj);
	}
	
	public String isGraduate() {
		return "NonGraduate";
	}
	

}
