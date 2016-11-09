package basicDrawing.pointsEx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;

class Surface extends JPanel implements ActionListener {
  private static final long serialVersionUID = 1L;
  
  private final int DELAY = 150;
  private Timer timer;

  public Surface() {
    initTimer();
  }

  private void initTimer() {
    timer = new Timer(DELAY, this);
    timer.start();
  }

  public Timer getTimer() {
    return timer;
  }

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    g2d.setPaint(Color.BLUE);

    int w = getWidth();
    int h = getHeight();

    Random r = new Random();

    for (int i = 0; i < 2000; i++) {
      int x = Math.abs(r.nextInt()) % w;
      int y = Math.abs(r.nextInt()) % h;
      g2d.drawLine(x, y, x, y);
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }
}
