package shapesAndFills.areasEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AreasEx extends JFrame {
  private static final long serialVersionUID = 7501241762857294151L;

  public AreasEx() {
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    
    setTitle("Areas");
    setSize(450, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        AreasEx ex = new AreasEx();
        ex.setVisible(true);
      }
    });
  }
}
