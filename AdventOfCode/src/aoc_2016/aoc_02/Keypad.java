package aoc_2016.aoc_02;

public class Keypad {
  private int w;
  private int h;
  private int maxW;
  private int maxH;
  private int[][] keypad;
  private int x;
  private int y;

  public Keypad(int w, int h) {
    keypad = new int[h][w];
    this.w = w;
    this.h = h;
    this.maxW = w - 1;
    this.maxH = h - 1;
    this.x = w / 2;
    this.y = h / 2;
    int num = 1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        keypad[i][j] = num;
        num++;
      }
    }
  }

  public String navigate(String[] inputs) {
    StringBuilder code = new StringBuilder();
    for (String input : inputs) {
      for (char c : input.toCharArray()) {
        moveOne(c);
        //        System.out.print(c + " (" + x + "," + y + ") " + keypad[y][x] + "   ");
      }
      //      System.out.println();
      code.append(keypad[y][x]);
    }
    return code.toString();
  }

  public void moveOne(char c) {
    switch (c) {
    case 'U':
      if (y == 0) break;
      y--;
      break;
    case 'D':
      if (y == maxH) break;
      y++;
      break;
    case 'R':
      if (x == maxW) break;
      x++;
      break;
    case 'L':
      if (x == 0) break;
      x--;
      break;
    }
  }

  public void printKeypad() {
    for (int[] rows : keypad) {
      System.out.print("[");
      for (int cols : rows) {
        System.out.print(" " + cols + " ");
      }
      System.out.println("]");
    }
  }
}
