package shapesAndFills.coloursEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ColoursEx extends JFrame {
  public ColoursEx() {
    initUI();
  }

  private void initUI() {
    add(new Surface());
    
    setTitle("Colours");
    setSize(360, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable(){
      @Override
      public void run(){
        ColoursEx ex = new ColoursEx();
        ex.setVisible(true);
      }
    });
  }
}
