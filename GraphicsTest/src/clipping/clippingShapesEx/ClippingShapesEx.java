package clipping.clippingShapesEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ClippingShapesEx extends JFrame {
  public ClippingShapesEx() {

    initUI();
  }

  private void initUI() {
    add(new Surface());

    setTitle("Clipping shapes");
    setSize(350, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        ClippingShapesEx ex = new ClippingShapesEx();
        ex.setVisible(true);
      }
    });
  }
}
