package composition.spotlight;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SpotlightEx extends JFrame {
  public SpotlightEx() {
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    
    setTitle("Spotlight");
    setSize(350, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        SpotlightEx ex = new SpotlightEx();
        ex.setVisible(true);
      }
    });
  }
}
