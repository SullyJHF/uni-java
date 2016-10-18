package shapesAndFills.texturesEx;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TexturesEx extends JFrame {
  public TexturesEx() {
    initUI();
  }
  
  private void initUI() {
    add(new Surface());
    
    setTitle("Textures");
    setSize(360, 120);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        TexturesEx ex = new TexturesEx();
        ex.setVisible(true);
      }
    });
  }
}
