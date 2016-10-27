package clipping.clippingEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ClippingEx extends JFrame {
  public ClippingEx() {
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    
    setTitle("Clipping");
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        ClippingEx ex = new ClippingEx();
        ex.setVisible(true);
      }
    });
  }
}
