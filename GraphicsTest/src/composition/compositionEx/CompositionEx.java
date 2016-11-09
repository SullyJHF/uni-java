package composition.compositionEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CompositionEx extends JFrame {
  public CompositionEx() {
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    
    setTitle("Composition");
    setSize(400, 120);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        CompositionEx ex = new CompositionEx();
        ex.setVisible(true);
      }
    });
  }
}
