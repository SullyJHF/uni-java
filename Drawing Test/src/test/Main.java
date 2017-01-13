package test;

import java.awt.EventQueue;

public class Main {
  public Main() {
    Window w = new Window();
    w.setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        Main m = new Main();
      }
    });
  }
}
