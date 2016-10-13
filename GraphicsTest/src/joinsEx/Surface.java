package joinsEx;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Surface extends JPanel {
  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    g2d.setStroke(bs1);
    g2d.drawRect(15, 15, 80, 50);

    BasicStroke bs2 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    g2d.setStroke(bs2);
    g2d.drawRect(125, 15, 80, 50);

    BasicStroke bs3 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    g2d.setStroke(bs3);
    g2d.drawRect(235, 15, 80, 50);

    g2d.dispose();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }
}
