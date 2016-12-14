package flap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Screen extends JPanel {
  private Bird bird;

  public Screen() {
    setPreferredSize(new Dimension(600, 400));
    setBackground(Color.GRAY);
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
    g2d.setColor(Color.BLACK);
    g2d.fillRect(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
    g2d.drawImage(bird.getImage(), bird.getY(), bird.getY(), null);
    g2d.dispose();
  }

  public void tick() {
    bird.update();
  }
}
