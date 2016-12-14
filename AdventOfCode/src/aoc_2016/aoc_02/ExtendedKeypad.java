package aoc_2016.aoc_02;

public class ExtendedKeypad {
  private int[][] keypad = {
      { 0, 0, 1, 0, 0 },
      { 0, 2, 3, 4, 0 },
      { 5, 6, 7, 8, 9 },
      { 0, 10, 11, 12, 0 },
      { 0, 0, 13, 0, 0 }
  };
  private int maxW, maxH;
  private int x, y;

  public ExtendedKeypad() {
    x = 0;
    y = 2;
    maxH = keypad.length - 1;
    maxW = keypad[0].length - 1;
  }

  public String navigate(String[] inputs) {
    StringBuilder code = new StringBuilder();
    for (String input : inputs) {
      for (char c : input.toCharArray()) {
        moveOne(c);
      }
      code.append(keypad[y][x] + " ");
    }
    return code.toString();
  }

  public void moveOne(char c) {
    switch (c) {
    case 'U':
      if(y == 0) break;
      if (keypad[y - 1][x] == 0) break;
      y--;
      break;
    case 'D':
      if(y == maxH) break;
      if (keypad[y + 1][x] == 0) break;
      y++;
      break;
    case 'R':
      if(x == maxW) break;
      if (keypad[y][x + 1] == 0) break;
      x++;
      break;
    case 'L':
      if(x == 0) break;
      if (keypad[y][x - 1] == 0) break;
      x--;
      break;
    }
  }
}
