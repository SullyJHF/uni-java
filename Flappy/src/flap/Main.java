package flap;

import java.awt.EventQueue;

public class Main {
  public Main() {
    Game g = new Game();
    g.start();
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      Main m = new Main();
    });
  }
}
