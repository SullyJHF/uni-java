package caesar;

public class CaesarCipher {
  private final int ALPHABET_LENGTH = 26;
  private final int A_VALUE = Character.valueOf('A');
  private int offset;

  public CaesarCipher() {}

  public CaesarCipher(int offset) {
    setOffset(offset);
  }

  public String decryptString(String input) {
    String tempStr = input.replaceAll(" ", "").toUpperCase();
    String outputStr = new String();
    for (char c : tempStr.toCharArray()) {
      outputStr += decryptCharacter(c);
    }
    return outputStr;
  }

  public char decryptCharacter(char c) {
    c = Character.toUpperCase(c);
    int offsettedC = c - A_VALUE;
    int newC = offsettedC - this.offset;
    newC %= ALPHABET_LENGTH;
    if (newC < 0) newC += ALPHABET_LENGTH;
    newC += A_VALUE;
    return (char) newC;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }
}
