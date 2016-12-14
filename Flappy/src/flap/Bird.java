package flap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bird {
  BufferedImage birdImage;
  private int x, y, w, h;

  public Bird() {
    w = 20;
    h = 20;
    birdImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    x = 20;
    y = 20;
  }

  public void update() {
    y++;
  }

  public BufferedImage getImage() {
    Graphics2D g2d = (Graphics2D) birdImage.getGraphics();
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0, 0, w, h);
    return birdImage;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return w;
  }

  public int getHeight() {
    return h;
  }
}
