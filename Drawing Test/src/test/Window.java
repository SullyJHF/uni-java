package test;

import javax.swing.JFrame;

public class Window extends JFrame {
  public Window() {
    setTitle("Graphics test");
    setResizable(false);

    Surface s = new Surface();
    add(s);

    pack();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }
}
