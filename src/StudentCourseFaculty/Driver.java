package StudentCourseFaculty;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver {
	public static void main(String[] args) throws IOException {
		ArrayList<Course> courses = new ArrayList<>();
		courses.add(new Course(new Name("COMP2311")));
		courses.add(new Course(new Name("COMP1331")));
		courses.add(new Course(new Name("COMP1310")));

		ArrayList<Student> students = new ArrayList<>();
		students.add(new Graduate(new Name("Yousef", "Dweik"), new Address("Abu Madi St.", "Jerusalem"), 3242));
		students.add(new NonGraduate(new Name("Husam", "Halawani"), new Address("Ashqariah St.", "Jerusalem"), 2764));
		students.add(new Graduate(new Name("Moayad", "Tamimi"), new Address("Abu taha St.", "Jerusalem"), 4735));
		
		ArrayList<Faculty> professors = new ArrayList<>();
		professors.add(new Faculty(new Name("Abdullah", "Karakrah")));
		professors.add(new Faculty(new Name("Hafeth", "Barghouti")));
		professors.add(new Faculty(new Name("Mohammed", "Khanafsah")));
		
		students.get(0).addCourse(courses.get(0));
		students.get(1).addCourse(courses.get(1));
		students.get(2).addCourse(courses.get(2));
		
		courses.get(0).addStudent(students.get(0)); courses.get(0).addFacultyMember(professors.get(0));
		courses.get(1).addStudent(students.get(1)); courses.get(1).addFacultyMember(professors.get(1));
		courses.get(2).addStudent(students.get(2)); courses.get(2).addFacultyMember(professors.get(2));
		
		professors.get(0).addCourse(courses.get(0));
		professors.get(1).addCourse(courses.get(1));
		professors.get(2).addCourse(courses.get(2));
		
		System.out.print("Students:\n");
		for (int i = 0; i < students.size(); i++) {
			System.out.println(" -" + students.get(i).getName().toString() + "          ");
		}
		System.out.print("\nCourses:\n");
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(" -" + courses.get(i).getCourseName().toString() + "           ");
		}
		System.out.print("\nFaculty Members:\n");
		for (int i = 0; i < professors.size(); i++) {
			System.out.println(" -" + professors.get(i).getFacultyName().toString());
		}
		
		System.out.println("\n");
		Scanner scan = new Scanner(System.in);
		int Option = 0;
		
		while (Option != 30) {
			System.out.println("1.  Search up info:\n"
					+          "2.  Add Students.          3. Remove Students.          4.  Modify Students.\n"
					+          "5.  Add Courses.           6. Remove Courses.           7.  Modify Course Title.\n"
					+          "8.  Add Faculty Members.   9. Remove Faculty Members.   10. Modify Faculty Members.\n"
					+          "11. Read from a file.");
					
			Option = scan.nextInt();
			String input, firstName, lastName, street, city, student, course, professor;
			int id, grade;
			char letter;
			
		switch(Option) {
		case 1: 
			System.out.println("Choose subject of info:\n'Students.'  /  'Courses'  /  'Faculty'  ");
			input = scan.next();
			
			if (input.equals("Students")) {
			System.out.println("Enter the student's name: ");
			scan.nextLine();
			student = scan.nextLine();
			
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getName().toString().equals(student)) {
					System.out.print("Courses registered:\n");
					for (int j = 0; j < students.get(i).getCourse().size(); j++) {
						System.out.print("-" + students.get(i).getCourse().get(j).getCourseName());
						System.out.println(", Grade: " + students.get(i).getCourse().get(j).getGrade());
						double avg = students.get(i).getAverageGrade();
						System.out.println("   *Grade Average: " + avg);
					}
					System.out.println("    Status: " + students.get(i).isGraduate());
					System.out.println();
					break;
				}
			}
		} else if (input.equals("Courses")) {
			System.out.println("Enter the course title: ");
			course = scan.next();
		    for (int i = 0; i < courses.size(); i++) {
		    	if (courses.get(i).getCourseName().getName().equals(course)) {
					System.out.println("Students that take this course: ");
					for (int j = 0; j < courses.get(i).getStudent().size(); j++) {
						System.out.println(courses.get(i).getStudent().get(j).getName().toString() + "  ");
					}    
					break;
				} 
		    }
		} else if (input.equals("Faculty")){
			System.out.println("Enter the name of the faculty member: ");
			scan.nextLine();
			professor = scan.nextLine(); 
			for (int i = 0; i < professors.size(); i++) {
				if (professors.get(i).getFacultyName().toString().equals(professor)) {
					System.out.println("Courses given by " + professor + ": ");
					for (int j = 0; j < professors.get(i).getCourse().size(); j++) {
						System.out.println(professors.get(i).getCourse().get(j).getCourseName().getName() + "  ");
					} 
					break;
				}
			}
			
		}
		       break;          //breaking from case 1
		case 2: 
			System.out.println("Enter the student's first name: ");
			firstName = scan.next();
			System.out.println("Enter the student's last name: ");
			lastName = scan.next();
	      	System.out.println("Enter their street: ");
		    street = scan.next();
		    System.out.println("Enter their city: ");
		    city = scan.next();
		    System.out.println("Enter their id: ");
		    id = scan.nextInt();
		
		students.add(new Graduate(new Name(firstName, lastName), new Address(street, city), id)); 
		       break;         //breaking from case 2
		case 3:
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i).getName().toString());
			}     
			
            System.out.println("\nEnter Student's name; ");
			scan.nextLine();
			student = scan.nextLine();
			
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getName().toString().equals(student)) {
					students.remove(i);
					System.out.println("Student removed.");
					break;
				}
			}
			   break;         //breaking from case 3
		case 4:
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i).getName().toString());
			}     //listing students
			System.out.println("\nEnter Student's name; ");
			
			scan.nextLine();
			student = scan.nextLine();
			
			
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getName().toString().equals(student)) {
					System.out.println("a. Register additional courses.  b. Remove courses. c. Set course grade");
					letter = scan.nextLine().charAt(0);
					
					switch (letter) {
					case 'a':
						System.out.println("Which of the following do you wish to add:\n\n"
							+ " -COMP2311            \r\n"
							+ " -COMP1331            \r\n"
							+ " -COMP1310 ");
					course = scan.next();
					for (int j = 0; j < courses.size(); j++) {
						if (courses.get(j).getCourseName().getName().equals(course)) {
							students.get(i).addCourse(courses.get(j));
							courses.get(j).addStudent(students.get(i));
							break;
						}
					}        break;
					case 'b':
						for (int r = 0; r < students.get(i).getCourse().size(); r++) {
							System.out.println("Registered courses: \n");
							System.out.print(students.get(i).getCourse().get(r).getCourseName().toString() + ", "); 
						}
						System.out.println("Enter the course you wish to remove: ");
						course = scan.next();
						for (int s = 0; s < students.get(i).getCourse().size(); s++) {
							if (students.get(i).getCourse().get(s).getCourseName().toString().equals(course)) {
								students.get(i).getCourse().remove(s);
								break;
						}
						}    
						     break;      
					case 'c': 
						try {
						for (int s = 0; s < courses.size(); s++) {
							System.out.println(courses.get(s).getCourseName().toString());
						}
						System.out.println("Enter the course you wish to set it's grade: ");
						course = scan.next();
						for (int j = 0; j < courses.size(); j++) {
							if (courses.get(j).getCourseName().getName().equals(course)) {
								System.out.println("Enter the grade: ");
								grade = scan.nextInt();
								students.get(i).getCourse().get(j).setGrade(grade);
								break;
							}
						}
						break;
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Enter a string.");
					}
				}
			  }
			}
			   break;         // breaking from case 4
		case 5:
			for (int i = 0; i < courses.size(); i++) {
				System.out.println(courses.get(i).getCourseName().toString());
			}
			
			System.out.println("Enter the course you wish to add: ");
			course = scan.next();
			courses.add(new Course(new Name(course)));
			   break;          // breaking from case 5
		case 6: 
			for (int i = 0; i < courses.size(); i++) {
				System.out.println(courses.get(i).getCourseName().toString());
			}
			System.out.println("Enter the course you wish to remove: ");
			course = scan.next();
			for (int j = 0; j < courses.size(); j++) {
				if (courses.get(j).getCourseName().getName().equals(course)) {
					courses.remove(j);
					break;
				}
			}         
			   break;        //breaking from case 6
		case 7: 
			for (int i = 0; i < courses.size(); i++) {
				System.out.println(courses.get(i).getCourseName().toString());
			}
			
			System.out.println("Enter the course you wish to modify: ");
			course = scan.next();
			
			for (int j = 0; j < courses.size(); j++) {
				if (courses.get(j).getCourseName().getName().equals(course)) {
					System.out.println("New title (In caps followed by their number): ");
					course = scan.next();
					courses.get(j).getCourseName().setName(course);
					break;
				}
			}        
			   break;        //breaking from case 7
		case 8:
			for (int i = 0; i < professors.size(); i++) {
				System.out.println(professors.get(i).getFacultyName().toString());
			}
			
			System.out.println("Enter name: ");
			scan.nextLine();
			professor = scan.nextLine();
		
			professors.add(new Faculty(new Name(professor)));
			   break;       //breaking from case 8
		case 9: 
			for (int i = 0; i < professors.size(); i++) {
				System.out.println(professors.get(i).getFacultyName().toString());
			}
			System.out.println("Enter the member you wish to remove: ");
			scan.nextLine();
			professor = scan.nextLine();
			for (int j = 0; j < professors.size(); j++) {
				if (professors.get(j).getFacultyName().toString().equals(professor)) {
					professors.remove(j);
					break;
				}
			}         
			    break;      //breaking from case 9
		case 10:
			for (int i = 0; i < professors.size(); i++) {
				System.out.println(professors.get(i).getFacultyName().toString());
			}
			
			System.out.println("Enter the member you want to modify: ");
			scan.nextLine();
			professor = scan.nextLine();
			
			System.out.println("a. Add a course they'll be teaching.   b. Remove one.");
			letter = scan.nextLine().charAt(0);
			
			switch (letter) {
			       case 'a':
			System.out.println("Enter the course: ");
			course = scan.next();
			for (int j = 0; j < professors.size(); j++) {
				if (professors.get(j).getFacultyName().toString().equals(professor)) {
					professors.get(j).addCourse(new Course(new Name(course)));
					break;
				}
			}
			                 break;
			       case 'b':
			    	   for (int i = 0; i < courses.size(); i++) {
							System.out.println(courses.get(i).getCourseName().toString());
						}
			
				System.out.println("Enter the course which they won't teach anymore: ");
				course = scan.next();
	            
				for (int j = 0; j < professors.size(); j++) {
					if (professors.get(j).getFacultyName().toString().equals(professor)) {
						for (int c = 0; c < courses.size(); c++) {
							if (courses.get(c).getCourseName().getName().equals(course)) {
								professors.get(j).getCourse().remove(c);
								break;
							}
						}
						break;
					}
				}
				
			}
			    break;     //breaking from case 10
		case 11:
			    try {
			    	File file = new File("StudentCourseFaculty.txt");
		        	BufferedWriter writer = new BufferedWriter (new PrintWriter(file));
		        	
		        	writer.write("Students: ");
		        	for (int i = 0; i < students.size(); i++) {
	        			writer.write("\n-" + students.get(i).getName().toString() + "\n");
	        			
	        			writer.write(" Registered Courses: ");
	        			for (int j = 0; j < students.get(i).getCourse().size(); j++) {
	        				writer.write(students.get(i).getCourse().get(j).getCourseName() + " ");
	        			}
	        	    }
		        	
		        	writer.write("\n\nCourses: ");
		        	for (int i = 0; i < courses.size(); i++) {
		        			writer.write("\n-" + courses.get(i).getCourseName().toString() + "\n");
		        			
		        		writer.write(" Taught by: ");
		        		for (int j = 0; j < courses.get(i).getFacultyMembers().size(); j++) {
		        			writer.write(courses.get(i).getFacultyMembers().get(j).getFacultyName() + " ");
		        		}
		        	}
		        	
		        	writer.write("\n\nProfessors:");
		        	for (int i = 0; i < professors.size(); i++) {
	        			writer.write("\n-" + professors.get(i).getFacultyName().toString() + "\n");
	        			
	        			writer.write(" Teaches: ");
	        			for (int j = 0; j < professors.get(i).getCourse().size(); j++) {
	        				writer.write(professors.get(i).getCourse().get(j).getCourseName() + " ");
	        			}
	        	    }
		        	
		        	writer.close();
		        	
		        	Scanner fileScan = new Scanner(file);
		        	System.out.println();
		        	
		        	while (fileScan.hasNextLine()) {
		        		System.out.println(fileScan.nextLine());
		        	}
		        	
		           System.out.println();
		           fileScan.close();
		           
		        } catch (FileNotFoundException e) {
		            System.out.println("An error occurred while writing to the file.");
		        }
			    					
			    break;     //breaking from case 1 1
		default: 
			System.out.println("invalid input.");
			    break;     //breaking from the default case
		} // end of switch
		} // end of while loop
		

		scan.close();
		}
	}
	
	

