package caesar;

public class CaesarCipher {
  private final int ALPHABET_LENGTH = 26;
  private final char A_VALUE = 'A';
  private int offset;

  public CaesarCipher() {}

  public CaesarCipher(int offset) {
    setOffset(offset);
  }

  public String decryptString(String input) {
    String tempStr = input.toUpperCase();
    StringBuilder outputStr = new StringBuilder();
    for (char c : tempStr.toCharArray()) {
      outputStr.append(decryptCharacter(c));
    }
    return outputStr.toString();
  }

  public char decryptCharacter(char c) {
    if(!Character.isLetter(c)) return c;
    int offsettedC = c - A_VALUE;
    offsettedC -= this.offset;
    // newC %= ALPHABET_LENGTH;
    if (offsettedC < 0) offsettedC += ALPHABET_LENGTH;
    offsettedC += A_VALUE;
    return (char) offsettedC;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }
}
