package login;

import java.awt.EventQueue;

public class Main {
  public void createAndShowGUI() {
    LoginFrame frame = new LoginFrame();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      Main m = new Main();
      m.createAndShowGUI();
    });
  }
}
