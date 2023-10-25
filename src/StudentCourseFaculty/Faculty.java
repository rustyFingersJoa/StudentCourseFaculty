package StudentCourseFaculty;
import java.util.ArrayList;

public class Faculty {
	
	private ArrayList<Course> course = new ArrayList<>();
	private Name facultyName;
	

	public Faculty() {
     
	}
	
	public Faculty(Name facultyName) {
		this.setFacultyName(facultyName);
	}
	
	
	
	public Name getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(Name name) {
		this.facultyName = name;
	}
	
	public ArrayList<Course> getCourse() {
		return course;
	}

	public void setCourse(ArrayList<Course> course) {
		this.course = course;
	}
	
	
	
	public void addCourse(Course course) {
		this.course.add(course);
	}
	
	public void deleteCourse(Course course, int i) {
		this.course.remove(i);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Faculty)
			return facultyName.toString() == ((Faculty)o).facultyName.toString();
		else
			return false;
	}
	
}
