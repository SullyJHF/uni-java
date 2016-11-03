import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Surface extends JPanel implements ActionListener {
  Graphics g;
  Timer t;
  private double goalFps = 60;
  private int frameTimeMs = (int) (1000 / goalFps);
  private final int INITIAL_DELAY = 0;
  private final int SCALE = 3;
  private final int SCREEN_HEIGHT = 200;
  private final int SCREEN_WIDTH = 320;
  private double runningTime = 0;
  private double oldRunningTime = 0;
  private String fps = "";
  private int[][] worldMap = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 2, 2, 0, 2, 2, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 4, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 4, 0, 0, 0, 0, 5, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 4, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 4, 0, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
  private final int MAP_WIDTH = worldMap.length;
  private final int MAP_HEIGHT = worldMap[0].length;

  // Game loop variables
  double posX, posY;
  double dirX, dirY;
  double planeX, planeY;
  double moveSpeed, rotSpeed;

  double time;
  double oldTime;

  public Surface() {
    initTimer();
    setSurfaceSize();
    initGameLoop();
  }

  private void initTimer() {
    t = new Timer(frameTimeMs, this);
    t.setInitialDelay(INITIAL_DELAY);
  }

  private void setSurfaceSize() {
    setPreferredSize(new Dimension(SCREEN_WIDTH * SCALE, SCREEN_HEIGHT * SCALE));
  }

  private void initGameLoop() {
    posX = 12;
    posY = 12;
    dirX = -1;
    dirY = 0;
    planeX = 0;
    planeY = 0.66;

    time = System.nanoTime();
    oldTime = time;
    t.start();
  }

  private void tick(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();

    // draw sky and ground
    g2d.setColor(Color.CYAN);
    g2d.fillRect(0, 0, SCREEN_WIDTH * SCALE, (SCREEN_HEIGHT / 2) * SCALE);
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, (SCREEN_HEIGHT / 2) * SCALE, SCREEN_WIDTH * SCALE, (SCREEN_HEIGHT / 2) * SCALE);

    // Loop through each column on the screen
    for (int x = 0; x < SCREEN_WIDTH; x++) {
      double cameraX = 2 * x / (double) SCREEN_WIDTH - 1;
      double rayPosX = posX;
      double rayPosY = posY;
      double rayDirX = dirX + planeX * cameraX;
      double rayDirY = dirY + planeY * cameraX;

      int mapX = (int) rayPosX;
      int mapY = (int) rayPosY;

      double sideDistX, sideDistY;

      double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
      double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
      double perpWallDist;

      int stepX, stepY;

      int hit = 0;
      int side = -1;

      if (rayDirX < 0) {
        stepX = -1;
        sideDistX = (rayPosX - mapX) * deltaDistX;
      } else {
        stepX = 1;
        sideDistX = (mapX + 1.0 - rayPosX) * deltaDistX;
      }

      if (rayDirY < 0) {
        stepY = -1;
        sideDistY = (rayPosY - mapY) * deltaDistY;
      } else {
        stepY = 1;
        sideDistY = (mapY + 1.0 - rayPosY) * deltaDistY;
      }

      while (hit == 0) {
        if (sideDistX < sideDistY) {
          sideDistX += deltaDistX;
          mapX += stepX;
          side = 0;
        } else {
          sideDistY += deltaDistY;
          mapY += stepY;
          side = 1;
        }
        if (mapX >= MAP_WIDTH) hit = -1;
        if (mapY >= MAP_HEIGHT) hit = -1;
        if (hit == -1) {
          break;
        }
        if (hit != -1 && worldMap[mapX][mapY] > 0) hit = 1;
      }

      if (hit == -1) {
        continue;
      }

      if (side == 0) {
        perpWallDist = (mapX - rayPosX + (1 - stepX) / 2) / rayDirX;
      } else {
        perpWallDist = (mapY - rayPosY + (1 - stepY) / 2) / rayDirY;
      }

      int lineHeight = (int) (SCREEN_HEIGHT / perpWallDist);
      int drawStart = -lineHeight / 2 + SCREEN_HEIGHT / 2;
      if (drawStart < 0) drawStart = 0;
      int drawEnd = lineHeight / 2 + SCREEN_HEIGHT / 2;
      if (drawEnd >= SCREEN_HEIGHT) drawEnd = SCREEN_HEIGHT - 1;

      Color c;
      switch (worldMap[mapX][mapY]) {
      case (1):
        c = Color.RED;
        break;
      case (2):
        c = Color.GREEN;
        break;
      case (3):
        c = Color.BLUE;
        break;
      case (4):
        c = Color.WHITE;
        break;
      default:
        c = Color.YELLOW;
      }

      if (side == 1) {
        c = c.darker();
      }

      // draw the line
      g2d.setColor(c);
      g2d.fillRect(x * SCALE, drawStart * SCALE, SCALE, (drawEnd - drawStart) * SCALE);
    }

    oldTime = time;
    time = System.nanoTime();
    double timeDiff = time - oldTime;
    double frameTime = timeDiff / 1000000000.0;
    g2d.setColor(Color.BLACK);
    g2d.setFont(new Font(g2d.getFont().getFontName(), Font.PLAIN, 20));
    oldRunningTime = runningTime;
    runningTime += timeDiff / 1000000000.0;
    if (Math.floor(runningTime) != Math.floor(oldRunningTime)) {
      updateFps((int) (1.0 / frameTime));
    }
    g2d.drawString(this.fps, 0, 18);

    // find out how to do some fps bullshit here
    moveSpeed = frameTime * 5.0;
    rotSpeed = frameTime * 3.0;
    if (Main.rotLeft) spinLeft();
    if (Main.rotRight) spinRight();
    if (Main.up) moveForward();
    if (Main.down) moveBackwards();
    g2d.dispose();
  }

  private void updateFps(int fps) {
    this.fps = String.valueOf(fps) + " FPS";
  }

  private void spinLeft() {
    double oldDirX = dirX;
    dirX = dirX * Math.cos(rotSpeed) - dirY * Math.sin(rotSpeed);
    dirY = oldDirX * Math.sin(rotSpeed) + dirY * Math.cos(rotSpeed);
    double oldPlaneX = planeX;
    planeX = planeX * Math.cos(rotSpeed) - planeY * Math.sin(rotSpeed);
    planeY = oldPlaneX * Math.sin(rotSpeed) + planeY * Math.cos(rotSpeed);
  }

  private void moveForward() {
    System.out.printf("dirX: %.2f, dirY: %.2f%n", dirX, dirY);
    if (worldMap[(int) (posX + dirX * moveSpeed)][(int) posY] == 0) posX += dirX * moveSpeed;
    if (worldMap[(int) posX][(int) (posY + dirY * moveSpeed)] == 0) posY += dirY * moveSpeed;
  }

  private void spinRight() {
    double oldDirX = dirX;
    dirX = dirX * Math.cos(-rotSpeed) - dirY * Math.sin(-rotSpeed);
    dirY = oldDirX * Math.sin(-rotSpeed) + dirY * Math.cos(-rotSpeed);
    double oldPlaneX = planeX;
    planeX = planeX * Math.cos(-rotSpeed) - planeY * Math.sin(-rotSpeed);
    planeY = oldPlaneX * Math.sin(-rotSpeed) + planeY * Math.cos(-rotSpeed);
  }

  private void moveBackwards() {
    if (worldMap[(int) (posX - dirX * moveSpeed)][(int) posY] == 0) posX -= dirX * moveSpeed;
    if (worldMap[(int) posX][(int) (posY - dirY * moveSpeed)] == 0) posY -= dirY * moveSpeed;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    tick(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // repaint calls paintComponent so in turn calls tick(g);
    repaint();
  }
}
