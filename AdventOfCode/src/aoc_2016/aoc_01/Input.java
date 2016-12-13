package aoc_2016.aoc_01;

public class Input {
  int amount;
  int direction;

  public Input(String input) {
    this.direction = input.charAt(0) == 'L' ? -1 : 1;
    this.amount = Integer.valueOf(input.substring(1));
  }

  public int getAmount() {
    return amount;
  }

  public int getDirection() {
    return direction;
  }
}
