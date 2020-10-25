import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataReader {
	public static final String SEPARATOR = "|";
	
	// an example of reading
	public static ArrayList readCourse(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Course data
		
		String tempName = "";
				
        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String courseID = star.nextToken().trim();	// first token
				String courseName = star.nextToken().trim();	// second token
				String indexName = star.nextToken().trim(); // third token
				int indexVacancy = Integer.parseInt(star.nextToken().trim()); // fourth token
				
				if (tempName.compareTo(courseName) != 0 ) { // if course not in array
					
					tempName = courseName;
					Course course = new Course(courseID, courseName); // create Course object from file data
					course.addIndex(indexName, indexVacancy);
					
					alr.add(course); // add to Course list
				} else { // else add Index of course
					for (int j = 0 ; j < alr.size() ; j++) {
						if (courseID.compareTo(((Course) alr.get(j)).getCourseID()) == 0) {
							((Course) alr.get(j)).addIndex(indexName,indexVacancy);
						}
					}
				}
			}
			return alr ;
	}
	  /** Read the contents of the given file. */
	  public static List read(String fileName) throws IOException {
		  List data = new ArrayList() ;
		  Scanner scanner = new Scanner(new FileInputStream(fileName));
		  try {
			  while (scanner.hasNextLine()) {
				  data.add(scanner.nextLine());
			  }	
		  }
		  finally {
			  scanner.close();
		  }
		  return data;
	  }
	  
	  //main method for testing code
	  public static void main(String[] aArgs)  {
		  DataReader dataReader = new DataReader();
		  String filename = "src/courseInfo.txt" ;
		  try {
			  // read file containing Course records.
			  ArrayList al = DataReader.readCourse(filename) ;
			  for (int i = 0 ; i < al.size() ; i++) {
				  Course course = (Course)al.get(i);
				  System.out.println("Course Name: " + course.getCourseName() );
				  System.out.println("Course ID: " + course.getCourseID() );
				  course.printcourseIndexList();
			  }
		  } catch (IOException e) {
			  System.out.println("IOException > " + e.getMessage());
		  }
	  }
}