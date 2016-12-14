package flap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Screen extends JPanel {
  public static final int WIDTH = 400;
  public static final int HEIGHT = 600;
  private Bird bird;

  public Screen() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground(Color.GRAY);
    bird = new Bird();
  }

  public void render() {
    this.repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    RenderingHints rh = new RenderingHints(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHints(rh);
    g2d.drawImage(bird.getImage(), (int) bird.getX(), (int) bird.getY(), null);
    g2d.dispose();
  }

  public void tick(boolean[] keys) {
    bird.update(keys);
  }
}
