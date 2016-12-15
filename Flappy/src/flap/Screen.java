package flap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Screen extends JPanel {
  public static final int WIDTH = 600;
  public static final int HEIGHT = 900;
  private Bird bird;
  private ArrayList<Gap> gaps;

  private int tickCount = 0;

  private int score = 0;

  public boolean gameOver = false;

  public Screen() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground(Color.GRAY);
    bird = new Bird();
    gaps = new ArrayList<Gap>();
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
    for(Gap gap : gaps) {
      g2d.drawImage(gap.getImage(), gap.getX(), 0, null);
    }
    g2d.setColor(Color.WHITE);
    g2d.setFont(new Font(g2d.getFont().getFontName(), Font.PLAIN, 40));
    g2d.drawString(String.valueOf(score), 30, 60);
    g2d.dispose();
  }

  public void tick(boolean[] keys) {
    if(keys[KeyEvent.VK_ESCAPE]) System.exit(0);
    if(tickCount % 90 == 0) {
      gaps.add(new Gap());
      System.out.println(score);
    }
    bird.update(keys);
    for(int i = 0; i < gaps.size(); i++) {
      Gap gap = gaps.get(i);
      gap.update();
      if(gap.dead()) {
        gaps.remove(i);
      }
      if(bird.score(gap)) {
        score += 1;
        gap.scored = true;
      }
      if(bird.collide(gap)) {
        gameOver = true;
      }
    }
    tickCount++;
  }
}
