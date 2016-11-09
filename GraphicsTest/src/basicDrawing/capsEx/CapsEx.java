package basicDrawing.capsEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CapsEx extends JFrame {
  private static final long serialVersionUID = 8981356632481788229L;

  public CapsEx() {
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    setTitle("Caps");
    setSize(280, 270);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        CapsEx ex = new CapsEx();
        ex.setVisible(true);
      }
    });
  }
}
