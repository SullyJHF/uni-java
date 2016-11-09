package transparency.transparentRectanglesEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TransparentRectanglesEx extends JFrame {
  public TransparentRectanglesEx() {
    initUI();
  }

  private void initUI() {
    add(new Surface());

    setTitle("Transparent Rectangles");
    setSize(590, 120);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        TransparentRectanglesEx ex = new TransparentRectanglesEx();
        ex.setVisible(true);
      }
    });
  }
}
