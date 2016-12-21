package single;

import java.util.Date;

public class Account {
  private String name, surname;
  private Date dob;

  public Account(String name, String surname, Date dob) {
    this.name = name;
    this.surname = surname;
    this.dob = dob;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public Date getDate() {
    return this.dob;
  }
}
