import java.util.*;

public class StarsApp {
	
	public static void main(String[] args) {
		//retrieve available courses and indexes from database
		CourseList courseList = new CourseList();
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		Student user = new Student("Bryan","tkoh013@e.ntu.edu.sg");
		
		System.out.println("hello " + user.getName() + ". Select your option:");
		System.out.println("(1) Add Course.");
		System.out.println("(2) Drop Course.");
		System.out.println("(3) Check/Print Courses Registered.");
		System.out.println("(4) Check Vacancies Available.");
		System.out.println("(5) Change Index Number of Course.");
		System.out.println("(6) Swop Index Number with Another Student.");
		System.out.println("(7) Exit");
		System.out.print("Please enter your choice : ");
		
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			//Display available courses
			courseList.readCourseList();
			
			//Ask user for input
			System.out.print("Please enter course ID : ");
			sc.nextLine(); // Discard  '\n'
			String courseID = sc.nextLine();
			System.out.print("Please enter course index : ");
			String courseIndex = sc.nextLine();
			System.out.print(courseIndex + " has been chosen.");
			
			if (courseList.checkCourse(courseID, courseIndex, user)) {
				StudentManager.addCourse(courseID, courseIndex, user);
				System.out.print(courseID + " added successfully.");
			} else {
				System.out.print("Failed to add course.");
			}
			
		case 7:
			break;
		default:
			System.out.println("Invalid input!");
			break;
			}
	}
	
	
	
	
	
}
