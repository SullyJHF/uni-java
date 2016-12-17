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
    String tempStr = input.replaceAll("\\s+", "").toUpperCase();
    StringBuilder outputStr = new StringBuilder();
    for (char c : tempStr.toCharArray()) {
      outputStr.append(decryptCharacter(c));
    }
    return outputStr.toString();
  }

  public char decryptCharacter(char c) {
    if(!Character.isLetter(c)) return c;
    int offsettedC = c - A_VALUE;
    int newC = offsettedC - this.offset;
    // newC %= ALPHABET_LENGTH;
    if (newC < 0) newC += ALPHABET_LENGTH;
    newC += A_VALUE;
    return (char) newC;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }
}
