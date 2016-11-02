import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Employee> employees = new ArrayList<Employee>();
    employees.add(new Employee(1, "Brad", "Evans", "Software Apprentice"));
    employees.add(new Employee(2, "Sullivan", "Ford", "Software Apprentice"));
    employees.add(new Employee(3, "Caleb", "Holloway", "Network Apprentice"));
    employees.add(new Employee(4, "Geraint", "White", "Best coder in the world"));
    employees.add(new Employee(5, "Peter", "Thorpe", "Advanced Software Engineer"));
    
    System.out.println(getFirstName(employees, 4));
    System.out.println(getLastName(employees, 3));
    System.out.println(getFullName(employees, 1));
    System.out.println(getJobTitle(employees, 2));
    System.out.println(getIdByLastName(employees, "Ford"));
    System.out.println(getJobTitle(employees, 1));
    setJobTitle(employees, 1, "Boyyy");
    System.out.println(getJobTitle(employees, 1));
  }
  
  public static String getFirstName(ArrayList<Employee> e, int id) {
    Employee x = findEmployeeById(e, id);
    if(x == null) return "Employee not found";
    return x.getFirstName();
  }
  
  public static String getLastName(ArrayList<Employee> e, int id) {
    Employee x = findEmployeeById(e, id);
    if(x == null) return "Employee not found";
    return x.getLastName();
  }
  
  public static String getFullName(ArrayList<Employee> e, int id) {
    return getFirstName(e, id) + " " + getLastName(e, id);
  }
  
  public static String getJobTitle(ArrayList<Employee> e, int id) {
    Employee x = findEmployeeById(e, id);
    if(x == null) return "Employee not found";
    return x.getJobTitle();
  }
  
  public static int getIdByLastName(ArrayList<Employee> e, String lastName) {
    for(int i = 0; i < e.size(); i++) {
      if(e.get(i).getLastName() == lastName) {
        return e.get(i).getId();
      }
    }
    return -1;
  }
  
  public static void setJobTitle(ArrayList<Employee> e, int id, String newJobTitle) {
    Employee x = findEmployeeById(e, id);
    x.setJobTitle(newJobTitle);
  }
  
  private static Employee findEmployeeById(ArrayList<Employee> e, int id) {
    for(int i = 0; i < e.size(); i++) {
      if(e.get(i).getId() == id) {
        return e.get(i);
      }
    }
    return null;
  }
}