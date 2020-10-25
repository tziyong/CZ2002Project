import java.util.ArrayList;

public class Student {
	private String name;
	private String email;
	private ArrayList<Course> studentCourseList = new ArrayList<Course>();
	
	// Create constructor for Student Class
	public Student (String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() { return this.name; }
	public String getEmail() { return this.email; }
	
	public void addCourse(String courseID, String courseIndex) {
		studentCourseList.add(null);
	}
}
