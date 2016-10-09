package textEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TextEx extends JFrame {
  private static final long serialVersionUID = 1L;

  public TextEx() {
    initUI();
  }

  private void initUI() {
    add(new Surface());

    setTitle("Simple 2D Java Example");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        TextEx ex = new TextEx();
        ex.setVisible(true);
      }
    });
  }
}
