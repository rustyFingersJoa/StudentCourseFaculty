package StudentCourseFaculty;
import java.util.ArrayList;

public class Course {
	
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Faculty> facultyMembers = new ArrayList<>();
	private Name courseName;
	private int grade;

	public Course(){
		
	}
	
	public Course(Name courseName) {
		this.setCourseName(courseName);
	}
	
	
	
	public ArrayList<Student> getStudent() {
		return this.students;
	}

	public void setStudent(ArrayList<Student> students) {
		this.students = students;
	}
	
	public ArrayList<Faculty> getFacultyMembers() {
		return facultyMembers;
	}

	public void setFaculty(ArrayList<Faculty> facultyMembers) {
		this.facultyMembers = facultyMembers;
	}
	
	public Name getCourseName() {
		return courseName;
	}

	public void setCourseName(Name courseName) {
		this.courseName = courseName;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	public void listStudents() {
		System.out.println();
		for (int i = 0; i < students.size(); i++)
			System.out.println(students.get(i).getName());
	}
	
	public Student searchForStudent(String s) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(s)) {
				return students.get(i); 
			}
		}
		return students.get(0);
	}
	
	public void listFacultyMembers() {
		System.out.println();
		for (int i = 0; i < facultyMembers.size(); i++)
			System.out.println(facultyMembers.get(i).getFacultyName());
	}
	
	public Faculty searchForFacultyMembers(Faculty f) {
		for (int i = 0; i < facultyMembers.size(); i++) {
			if (facultyMembers.get(i).getFacultyName().equals(f.getFacultyName())) {
				return facultyMembers.get(i);
			}
		}
		return facultyMembers.get(0);
	}
	
	
	public void addStudent(Student obj) {
		this.students.add(obj);
	}
	
	public void addFacultyMember(Faculty obj) {
		this.facultyMembers.add(obj);
	}
	
	public String toString() {
		return courseName.getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Course)
			return courseName.toString() == ((Course)o).courseName.toString();
		else
			return false;
	}

	
	
	
}



