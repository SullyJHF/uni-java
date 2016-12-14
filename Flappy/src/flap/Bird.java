package flap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Bird {
  BufferedImage birdImage;
  private float x, y;
  private int w, h;
  private float downSpeed = 0;
  private final float THRUST = -10.0f;
  private final float MIN_DOWN_SPEED = -7.5f;
  private final float MAX_DOWN_SPEED = 10;
  private float gravity = 0.2f;
  private boolean prevUp = false;
  private boolean up = false;
  private boolean gameOver = false;

  public Bird() {
    w = 40;
    h = 40;
    birdImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    x = 50;
    y = Screen.HEIGHT / 2;
  }

  public void update(boolean[] keys) {
    up = keys[KeyEvent.VK_SPACE];
    y += downSpeed;
    downSpeed += gravity;
    if(up && !prevUp) downSpeed += THRUST;
    if(downSpeed >= MAX_DOWN_SPEED) downSpeed = MAX_DOWN_SPEED;
    if(downSpeed <= MIN_DOWN_SPEED) downSpeed = MIN_DOWN_SPEED;
    checkCollision();
    prevUp = up;
  }

  private void checkCollision() {
    if(y <= 0) {
      y = 0;
      downSpeed = 0.1f;
    }
    if(y + h >= Screen.HEIGHT) {
      y = Screen.HEIGHT - h;
      downSpeed = 0;
      gameOver  = true;
    }
  }

  public BufferedImage getImage() {
    Graphics2D g2d = (Graphics2D) birdImage.getGraphics();
    g2d.setColor(Color.WHITE);
    g2d.fillOval(0, 0, w, h);
    return birdImage;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public int getWidth() {
    return w;
  }

  public int getHeight() {
    return h;
  }
}
