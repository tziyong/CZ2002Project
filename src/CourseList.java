import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	// Constructor
	public CourseList() {
		  DataReader dataReader = new DataReader();
		  String filename = "src/courseInfo.txt" ;
		  try {
			  // read file containing Course records.
			   this.courseList = DataReader.readCourse(filename);
		  } catch (IOException e) {
			  System.out.println("IOException > " + e.getMessage());
		  }
	  }
	// print methods
	public void readCourseList() {
		for (int i = 0 ; i < this.courseList.size() ; i++) {
			  Course course = (Course)this.courseList.get(i);
			  System.out.println("Course Name: " + course.getCourseName() );
			  System.out.println("Course ID: " + course.getCourseID() );
			  course.printcourseIndexList();
		  }
	}
	
	public boolean checkCourse (String courseID, String courseIndex, Student student) {
		for (int i = 0 ; i < this.courseList.size() ; i++) {
			  Course course = (Course)this.courseList.get(i);
			  if (courseID.compareTo(course.getCourseID()) == 0) { //course exist in courseList
				  if (course.checkIndexVacancy(courseIndex, student)) { //check if index has vacancy
					  System.out.println(courseIndex + " is available.");
					  return true; // course can be added
				  } else {
					  return false; //index not found 
				  }
			  }
		}
		System.out.println("Course " + courseID + " does not exist in the database.");
		return false; // course not found 
	}
	
}
