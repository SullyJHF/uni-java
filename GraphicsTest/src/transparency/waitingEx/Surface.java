package transparency.waitingEx;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

class Surface extends JPanel implements ActionListener {

  private Timer timer;
  private int count;
  private final int INITIAL_DELAY = 200;
  private final int DELAY = 100;
  private final int STROKE_WIDTH = 3;

  private final double[][] trs = { { 0.0, 0.15, 0.30, 0.5, 0.65, 0.80, 0.9, 1.0 },
      { 1.0, 0.0, 0.15, 0.30, 0.5, 0.65, 0.8, 0.9 }, { 0.9, 1.0, 0.0, 0.15, 0.3, 0.5, 0.65, 0.8 },
      { 0.8, 0.9, 1.0, 0.0, 0.15, 0.3, 0.5, 0.65 }, { 0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.3, 0.5 },
      { 0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.3 }, { 0.3, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15 },
      { 0.15, 0.3, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0 } };

  private final int NUMBER_OF_LINES = trs.length;

  public Surface() {
    initTimer();
  }

  private void initTimer() {
    timer = new Timer(DELAY, this);
    timer.setInitialDelay(INITIAL_DELAY);
    timer.start();
  }

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    int width = getWidth();
    int height = getHeight();

    g2d.setStroke(new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g2d.translate(width / 2, height / 2);

    for (int i = 0; i < NUMBER_OF_LINES; i++) {
      float alpha = (float) trs[count % NUMBER_OF_LINES][i];
      AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
      g2d.setComposite(acomp);

      g2d.rotate(Math.PI / 4f);
      g2d.drawLine(0, -10, 0, -30);
    }

    g2d.dispose();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
    count++;
  }
}
