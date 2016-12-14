package aoc_2016.aoc_02;

public class Main {
  public static void main(String[] args) {
    FileHandler fh = new FileHandler("input.txt");
    String[] inputs = fh.getInputsAsArray();

    Keypad pad = new Keypad(3, 3);
    String code = pad.navigate(inputs);
    System.out.println(code);

    ExtendedKeypad exPad = new ExtendedKeypad();
    code = exPad.navigate(inputs);
    System.out.println(code);
  }
}
