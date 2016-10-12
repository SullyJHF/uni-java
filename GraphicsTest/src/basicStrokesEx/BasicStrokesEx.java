package basicStrokesEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BasicStrokesEx extends JFrame {
  private static final long serialVersionUID = 3626660178058839841L;

  public BasicStrokesEx() {
    initUI();
  }

  private void initUI() {
    add(new Surface());

    setTitle("Basic strokes");
    setSize(280, 270);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        BasicStrokesEx ex = new BasicStrokesEx();
        ex.setVisible(true);
      }
    });
  }
}
