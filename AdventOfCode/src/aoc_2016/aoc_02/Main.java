package aoc_2016.aoc_02;

public class Main {
  public static void main(String[] args) {
    FileHandler fh = new FileHandler("input.txt");
    System.out.println(fh.getInput());
    Keypad pad = new Keypad(3, 3);
  }
}
