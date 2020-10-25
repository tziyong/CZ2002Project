import java.util.ArrayList;

public class Course {
	private String courseID;
	private String courseName;
	private ArrayList<Index> courseIndexList = new ArrayList<Index>();// to store index data
	
	// Create constructor for Course Class
	public Course (String courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
	}
	
	public void addIndex (String indexName, int indexVacancy) {
		Index index = new Index (indexName, indexVacancy);
		courseIndexList.add(index);
	}
	
	//print methods
	public void printCourseInfo () {
		System.out.println(this.courseID);
		System.out.println(this.courseName);
		this.printcourseIndexList();
	}
	
	public void printcourseIndexList () {
		for (int i = 0; i < this.courseIndexList.size() ; i++) {
			System.out.println("Index: " + this.courseIndexList.get(i).getName() + " Vacancy: " + this.courseIndexList.get(i).getVacancy());
		}
	}
	
	// get methods
	public String getCourseID() { return this.courseID; }
	public String getCourseName() { return this.courseName; }
	public ArrayList<Index> getCourseIndexList() { return this.courseIndexList; }
	
	public boolean checkIndexVacancy(String courseIndex, Student student) {
		for (int i = 0 ; i < this.courseIndexList.size() ; i++) {
			Index index = (Index)this.courseIndexList.get(i);
			if (courseIndex.compareTo(index.getName()) == 0) { // index exists in courseIndexList
				if (index.getVacancy() == 0) {
					index.toWaitList(student);
				} else {  // has vacancy
					return true; 
				}
			}
		}
		System.out.println("Index " + courseIndex +" not found in " + this.courseID);
		return false; // index does not exist in courseIndexList
	}

}
