package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Surface extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
  private Random r;
  private int SCREEN_WIDTH = 800;
  private int SCREEN_HEIGHT = 600;

  Timer t;

  private final int DELAY = 16;
  private final int INITIAL_DELAY = 50;

  private final float GRAVITY = 1.0f;

  private final float FRICTION = 0.7f;

  private final int MAX_BALL_SIZE = 100;
  private final int MIN_BALL_SIZE = 20;

  private ArrayList<Ball> balls;

  public Surface() {
    setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    this.addMouseMotionListener(this);
    r = new Random();
    balls = new ArrayList<Ball>();
    t = new Timer(DELAY, this);
    t.setInitialDelay(INITIAL_DELAY);
    t.start();
  }

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    for (Ball ball : balls) {
      g2d.setColor(ball.color);
      g2d.fillOval((int)ball.x, (int)ball.y, ball.size, ball.size);
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = balls.size() - 1; i >= 0; i--) {
      Ball ball = balls.get(i);
      ball.y += ball.yVel;
      ball.x += ball.xVel;

      if (ball.y + ball.size >= SCREEN_HEIGHT) {
        ball.y = SCREEN_HEIGHT - ball.size;
        ball.yVel *= -FRICTION * (1 - (ball.size / (MAX_BALL_SIZE + MIN_BALL_SIZE)));
        ball.xVel *= FRICTION;
      }
      if(ball.y <= 0) {
        ball.y = 0;
        ball.yVel *= -FRICTION * (1 - (ball.size / (MAX_BALL_SIZE + MIN_BALL_SIZE)));
      }
      if (ball.x + ball.size >= SCREEN_WIDTH) {
        ball.x = SCREEN_WIDTH - ball.size;
        ball.xVel = -ball.xVel;
      }
      if(ball.x <= 0) {
        ball.x = 0;
        ball.xVel = -ball.xVel;
      }
      ball.yVel += GRAVITY;
      ++ball.aliveTicks;
      if (ball.aliveTicks == 5000) balls.remove(ball);
    }
    repaint();
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int ballSize = r.nextInt(MAX_BALL_SIZE) + MIN_BALL_SIZE;
    float xVel = (r.nextFloat() * 20) - 10;
    float yVel = (r.nextFloat() * 20) - 10;
    balls.add(new Ball(
        e.getX() - ballSize / 2,
        e.getY() - ballSize / 2,
        ballSize,
        yVel,
        xVel,
        new Color(
            r.nextFloat(),
            r.nextFloat(),
            r.nextFloat())));
  }

  @Override
  public void mouseMoved(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }
}
