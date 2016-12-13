package aoc_2016.aoc_02;

public class Main {
  public static void main(String[] args) {
    FileHandler fh = new FileHandler("input.txt");
    Keypad pad = new Keypad(3, 3);
    String[] inputs = fh.getInputsAsArray();
    String code = pad.navigate(inputs);
    System.out.println(code);
  }
}
