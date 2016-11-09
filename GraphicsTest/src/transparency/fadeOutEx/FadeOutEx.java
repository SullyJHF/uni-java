package transparency.fadeOutEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class FadeOutEx extends JFrame {
  public FadeOutEx() {
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    
    pack();
    
    setTitle("Fade Out");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        FadeOutEx ex = new FadeOutEx();
        ex.setVisible(true);
      }
    });
  }
}
