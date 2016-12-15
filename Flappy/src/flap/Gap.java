package flap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Gap {
  private final int WIDTH = 25;
  private final int MIN_GAP = Screen.HEIGHT / 6;
  private final int MAX_GAP = Screen.HEIGHT / 4;
  private int dist;
  private final int MIN_POS = Screen.HEIGHT / 8;
  private int pos;
  private int x;
  private float speed = -3f;
  private BufferedImage image;
  private Random r;
  public boolean scored;
  private Rectangle2D r1, r2;

  public Gap() {
    r = new Random();
    dist = r.nextInt(MAX_GAP) + MIN_GAP;
    pos = r.nextInt(Screen.HEIGHT - dist - MIN_POS) + MIN_POS;
    x = Screen.WIDTH + WIDTH;
    image = new BufferedImage(WIDTH, Screen.HEIGHT, BufferedImage.TYPE_INT_ARGB);
    scored = false;
    r1 = new Rectangle2D.Double(0, 0, WIDTH, pos);
    r2 = new Rectangle2D.Double(0, pos + dist, WIDTH, Screen.HEIGHT);
  }

  public void update() {
    x += speed;
  }

  public BufferedImage getImage() {
    Graphics2D g2d = (Graphics2D) image.getGraphics();
    g2d.setColor(Color.WHITE);
    g2d.fill(r1);
    g2d.fill(r2);
    return image;
  }

  public int getX() {
    return x;
  }

  public int getWidth() {
    return WIDTH;
  }

  public boolean dead() {
    return x + WIDTH <= 0;
  }

  public Rectangle2D getTop() {
    return new Rectangle2D.Double(x, 0, WIDTH, pos);
  }

  public Rectangle2D getBot() {
    return new Rectangle2D.Double(x, pos + dist, WIDTH, Screen.HEIGHT);
  }
}
