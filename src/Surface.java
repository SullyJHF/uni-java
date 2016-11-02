import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Surface extends JPanel implements ActionListener {
  Timer t;
  private final int INITIAL_DELAY = 0;
  
  public Surface() {
    initTimer();
  }
  
  private void initTimer() {
    t = new Timer(INITIAL_DELAY, this);
  }
  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    
  }
}
