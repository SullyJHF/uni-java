package linesEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class LinesEx extends JFrame {
  private static final long serialVersionUID = 1L;

  public LinesEx() {
    initUI();
  }

  private void initUI() {
    add(new Surface());

    setTitle("Lines");
    setSize(350, 250);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        LinesEx ex = new LinesEx();
        ex.setVisible(true);
      }
    });
  }
}
