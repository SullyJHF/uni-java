package caesarCipher;

public class Cipher {
  int offset;
  public Cipher(int offset) {
    this.offset = offset;
  }
  
  private String removePunc(String s) {
    return s.replaceAll("\\p{Punct}| ", "");
  }
  
  private String addX(String s) {
    for(int i = 0; i <= 5 - s.length(); i++) {
      s += 'X';
    }
    return s;
  }
  
  public String encode(String s) {
    s = removePunc(s);
    s = s.toUpperCase();
    String result = "";
    for(int i = 0; i < s.length(); i++) {
      int c = (int)s.charAt(i);
      c -= 65;
      c += this.offset;
      c %= 26;
      if(c < 0) c += 26;
      c += 65;
      char ch = (char) c;
      result += ch;
      if(i % 5 == 4) result += " ";
    }
    
    String[] changedArray = result.split(" ");
    if(changedArray[changedArray.length - 1].length() < 5) {
      String lastString = changedArray[changedArray.length - 1];
      lastString = addX(lastString);
      changedArray[changedArray.length - 1] = lastString;
      result = "";
      for(int i = 0; i < changedArray.length; i++) {
        result += changedArray[i] + " ";
      }
    }
    return result.trim();
  }
}
