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

  public int extractPhoneNumber(String text) {
    if (text == null || text.trim().length() < 1) throw new IllegalArgumentException("No empty text allowed.");

    Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
    Matcher matcher = pattern.matcher(text);

    if (matcher.find()) {
      phonenumber = matcher.group(0);
      return 0;
    }

    throw new IllegalArgumentException("No (valid) phone number provided.");
  }

  public static void main(String[] args) {
    ExceptionsDemo ed = new ExceptionsDemo();

    try {
      int value = ed.extractPhoneNumber("This is my phone number 147-987-0000, ty");
      System.out.println("Your phone number is " + ed.getPhoneNumber());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
