// set package name by Eclipse IDE.
package student_management_systems.task;

// importing required java utilities
import java.util.ArrayList;
import java.util.Scanner;

// creating s student class
class Student {
	String studentId;
	String name;
	int age;
	double grade;
	String studentProfile;
	
	// Constructor to be used in that Student class.
	Student(String studentIdInp, String nameInp, int ageInp, double gradeInp) {
		this.studentId = studentIdInp;
		this.name = nameInp;
		this.age = ageInp;
		this.grade = gradeInp;
	}
	
	// overrides the default behavior of toString() method and returns our expected result from the ArrayList .
	@Override 
	public String toString() {
		return "ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
	}

}
 
public class StudentManagementSystem {

	public static void main(String[] args) {
		// initiating the ArrayList
		ArrayList<Student> studentList = new ArrayList<>(); // Reference from w3 school.
		int menuChoice;
		
		// initiating the Scanner object
		Scanner studentInfoObj = new Scanner(System.in);
		
		
		while(true){
			// Showing the menu 
			System.out.println("==== Student Management System ====");
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Display All Students");
			System.out.println("5. Exit");
			System.out.println("==================================== \n");
			
			// prompt user to choice menu
			System.out.println("Enter your choice: ");
			menuChoice = studentInfoObj.nextInt();
			
			// checking the choice
			// System.out.println(menuChoice);
			
			// switch to work on menuChoice
			switch(menuChoice) {
			
			// to add a student ================================================================
			case 1: 
				System.out.println("Adding student ...");
				// prompting user to input details and storing them in the Scanner object
				// prompt user to input student Id
				System.out.println("Enter Student ID: ");
				String studentId = studentInfoObj.next();
				
				// prompt user to input student name
				System.out.println("Enter Name: ");
				String name = studentInfoObj.next();
				
				// prompt user to input student age
				System.out.println("Enter Age: ");
				int age = studentInfoObj.nextInt();
				
				// prompt user to input student grade
				System.out.println("Enter grade: ");
				double grade = studentInfoObj.nextDouble();
				
				// expected data will be added to the ArrayList only if the validating condition is met
				if(age > 0 && 0 <= grade && grade <= 100) {
					// checking the output
					System.out.println( "ID: " + studentId + ". Name: " + name + ". Age: " + age + " y/o. Grade: " + grade);
					
					// defining an object named studentInfo which will carry the values of student info into Student constructor from Student class
					Student studentInfo = new Student(studentId, name, age, grade);
					
					// checking the output using studentInfo
//					System.out.println("Student info from constructor: "+ studentInfo.studentId + " " + studentInfo.name + " " + studentInfo.age + " " + studentInfo.grade);
					
					// adding student information to the ArrayList
					studentList.add(studentInfo);
					// checking whether the data is added in the ArrayList
//					System.out.println("Student info from ArrayList: "+ studentList);
					// successful message
					System.out.println("Student added successfully! \n");
				} else {
					if(age <= 0 && 0 <= grade && grade <= 100) {
						System.out.println("Invalid input. Age must be positive.");	
					} else if (age > 0 && 0 >= grade || grade >= 100){
						System.out.println("Invalid input. Grade must be between 0 and 100");
					} else {
						System.out.println("Invalid input. Please check your input.");
					}
					
				}
				
				
				break;
				
			// updating student ================================================================
			case 2: 
				System.out.println("Updating student ...");
				
				// prompting user to enter the ID of the student to update
				System.out.println("Enter student ID to update: ");
				// taking the id input to get the student data to update
				String updatedId = studentInfoObj.next();
				// check if the data for our expected student is available
				boolean foundUpdate = false;
				
				// target the student info using it's id
				for(Student student : studentList) {
					if(student.studentId.equals(updatedId)) {
						System.out.println("Updatable");
						
						// prompt for updates
						System.out.println("Enter new name: ");
						String newName = studentInfoObj.next();
						System.out.println("Enter new age: ");
						int newAge = studentInfoObj.nextInt();
						System.out.println("Enter new grade: ");
						double newGrade = studentInfoObj.nextDouble();
						
						// validation of the updates
						if (newAge > 0 && newGrade >= 0 && newGrade <= 100) {
			                student.name = newName;
			                student.age = newAge;
			                student.grade = newGrade;
			                System.out.println("Student with ID " + updatedId + " updated successfully!");
			            } else {
			                System.out.println("Invalid input. Age must be positive and grade must be between 0 and 100.");
			            }
						
					foundUpdate = true;
					}
				}
					

				// if no student with the entered id is found
				if (!foundUpdate) { 
					System.out.println("Student with ID " + updatedId + " not found.");
					}
				
				
				break;
			
			// Deleting student ================================================================
			case 3:
				System.out.println("Deleting student ...");
				// status of being deletion or " hasDeleted ? "
				boolean hasDeleted = false;
				// prompting user to enter the ID of the student to delete
				System.out.println("Enter student ID to delete: ");
				// taking the id input to get the student data for deletion
				String deletedId = studentInfoObj.next(); 
				// the status of the presence of the user (currently false)
				
				
				// iterate through the list to find the student
				for(Student student : studentList) {
					// targeting the expected user 
					if(student.studentId.equals(deletedId)) {
						// removing the student information if it matches the target id
						studentList.remove(student);
						// printing out the response
						System.out.println("Student with ID " + deletedId + " deleted successfully!");
						// the status of the presence of the user (currently true)
						hasDeleted = true;
						// breaking the statement
						break;
					}
				}
				
				// if the user does not exist
				if(!hasDeleted) {
					System.out.println("Student with ID " + deletedId + " not found.");
				}
				
				break;
				
			// displaying all the student ============================================================
			case 4:
				System.out.println("Displaying all student ...");
				
				// checking whether the ArrayList has any entry or not
				if(!studentList.isEmpty()) {
					
				
				// checking whether the data is added in the ArrayList
				System.out.println("Student info from ArrayList: "+ studentList);
				// successful message
				System.out.println("Student added successfully! \n");
				
				// showing each student's information in distinct object
				System.out.println("List of Students:");
				
				// consider each student's info object as student from the list of all the added students which is studentList
				for(Student student : studentList) {
					System.out.println("{ "+ student + " }");
					
				}
				
				} else {
					System.out.println("No student added yet.");
				}
				break;
				
			// exiting the application ================================================================
			case 5:
				// closing the switch case;
				studentInfoObj.close();
				System.out.println("Exiting ...");
				System.exit(0);
				
				break;
			default:
				// catch for any invalid inputs
				System.out.println("You selected: " + menuChoice + ". Invalid input. Please try again.");
			}
		}
		

		
	}

}
