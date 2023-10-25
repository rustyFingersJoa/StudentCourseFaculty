package StudentCourseFaculty;
import java.util.ArrayList;

public abstract class Student {
	
	private ArrayList<Course> course = new ArrayList<>();
	private Name name;
	private Address address;
	private int id;
	
	Student(){
		
	}
	
	Student(Name name, Address address, int id) {
	this.setName(name);
	this.setAddress(address);
	this.setId(id);
	}

	
	public ArrayList<Course> getCourse() {
		return course;
	}

	public void setCourse(ArrayList<Course> course) {
		this.course = course;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	
	public abstract double getAverageGrade();
	public abstract String isGraduate();
	
	public void addCourse (Course obj) {
		this.course.add(obj);
	}
	
	public void listCourses() {
		for (int i = 0; i < course.size(); i++)
			System.out.println(course.get(i).getCourseName());
	}
	
	public Course searchForCourse(Course c) {
		for (int i = 0; i < course.size(); i++) {
			if (course.get(i).getCourseName().equals(c.getCourseName())) {
				return course.get(i); 
			}
		}
		return course.get(0);
	}
	
	public String toString() {
		return "Student name: " + name + ", Address: " + address + ", " + id + "\n Courses: ";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Student)
			return name.toString() == ((Student)o).name.toString();
		else 
			return false;
	}
	

}
