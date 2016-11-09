package lec6;

import java.util.regex.Pattern;

public class PostCode {
  String pc;
  public PostCode(String pc) {
    if(Pattern.matches("^(\\w{1,2}\\d{1,2}\\s\\d\\w{2})$", pc)) {
      this.pc = pc;
    } else {
      this.pc = "Invalid postcode supplied";
    }
  }
}
