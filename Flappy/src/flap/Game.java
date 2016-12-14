package flap;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {
  private Thread thread;
  public Screen screen;
  private boolean running = false;

  public Game() {
    super("Flappy");
    screen = new Screen();
    add(screen);
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public synchronized void start() {
    if (running) return;
    running = true;
    thread = new Thread(this);
    thread.start();
  }

  public synchronized void stop() {
    if (!running) return;
    running = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    int frames = 0;

    double unprocessedSeconds = 0;
    long lastTime = System.nanoTime();
    double secondsPerTick = 1 / 60.0;
    int tickCount = 0;

    requestFocus();

    while (running) {
      long now = System.nanoTime();
      long passedTime = now - lastTime;
      lastTime = now;
      if (passedTime < 0) passedTime = 0;
      if (passedTime > 100000000) passedTime = 100000000;

      unprocessedSeconds += passedTime / 1000000000.0;

      boolean ticked = false;
      while (unprocessedSeconds > secondsPerTick) {
        screen.tick();
        unprocessedSeconds -= secondsPerTick;
        ticked = true;

        tickCount++;
        if (tickCount % 60 == 0) {
          //          System.out.println(frames + " fps");
          lastTime += 1000;
          frames = 0;
        }
      }

      if (ticked) {
        screen.render();
        frames++;
      } else {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
