import java.util.ArrayList;

public class Index {
	private String indexName;
	private int indexVacancy;
	private ArrayList<Student> waitList = new ArrayList<Student>();
	
	// Create constructor for Index Class
	public Index (String indexName, int indexVacancy)
	{	
		this.indexName = indexName;
		this.indexVacancy = indexVacancy;
	}	
	
	public String getName() { return this.indexName; }
	public int getVacancy() { return this.indexVacancy; }
	
	public void setName(String indexName) { this.indexName = indexName; }
	public void setVacancy(int indexVacancy) { this.indexVacancy = indexVacancy; }
	
	public boolean toWaitList(Student o) {
		for (int i = 0; i < this.waitList.size(); i++) {
			Student student = (Student)this.waitList.get(i);
			if (student == o) {
				System.out.println("Student already on waitlist for index " + this.indexName);
				return false;
			}
		}
		waitList.add(o);
		System.out.println("Student has been added to waitlist for index " + this.indexName);
		return true;
	}
	
}
