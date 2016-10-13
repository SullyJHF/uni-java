package shapesAndFills.starEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class StarEx extends JFrame {
  private static final long serialVersionUID = -7238144372228809307L;

  public StarEx(){
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    
    setTitle("Star");
    setSize(350, 250);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        StarEx ex = new StarEx();
        ex.setVisible(true);
      }
    });
  }
}
