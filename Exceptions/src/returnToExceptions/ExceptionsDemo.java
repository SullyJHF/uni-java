package returnToExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionsDemo {
  private String phonenumber;

  public String getPhoneNumber() {
    return phonenumber;
  }

  public void setPhoneNumber(String pnum) {
    phonenumber = pnum;
  }

  public void extractPhoneNumber(String text) throws EmptyStringException, InvalidPhoneNumberException {
    if (text == null || text.trim().length() < 1) throw new EmptyStringException("No empty text allowed.");

    Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
    Matcher matcher = pattern.matcher(text);

    if (!matcher.find()) throw new InvalidPhoneNumberException("No (valid) phone number provided.");

    phonenumber = matcher.group(0);
  }

  public static void main(String[] args) {
    ExceptionsDemo ed = new ExceptionsDemo();

    try {
      ed.extractPhoneNumber("123-531-9000");
      System.out.println("Your phone number is " + ed.getPhoneNumber());
    } catch (EmptyStringException | InvalidPhoneNumberException e) {
      System.out.println(e);
    }
  }
}
