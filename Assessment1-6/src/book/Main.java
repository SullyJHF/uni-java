package book;

import java.awt.EventQueue;

public class Main {
  private void createAndShowGUI() {
    Screen screen = new Screen();
    screen.setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      Main m = new Main();
      m.createAndShowGUI();
    });
  }

}
