package caesar;

import java.awt.EventQueue;

public class Main {
  private static void createAndShowGUI() {
    Screen screen = new Screen("Decrypt Caesars Ciphers");
    screen.setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> createAndShowGUI());
  }
}
