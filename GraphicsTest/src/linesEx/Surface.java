package linesEx;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Surface extends JPanel {
  private static final long serialVersionUID = 1L;

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    g2d.drawLine(30, 30, 200, 30);
    g2d.drawLine(200, 30, 30, 200);
    g2d.drawLine(30, 200, 200, 200);
    g2d.drawLine(200, 200, 30, 30);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }
}
