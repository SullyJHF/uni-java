
public class Employee {
  private int id;
  private String firstName, lastName, jobTitle;
  
  public Employee(int id, String firstName, String lastName, String jobTitle) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
  }
  
  public int getId() {
    return this.id;
  }
  
  public String getFirstName() {
    return this.firstName;
  }
  
  public String getLastName() {
    return this.lastName;
  }
  
  public String getJobTitle() {
    return this.jobTitle;
  }
  
  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }
}
