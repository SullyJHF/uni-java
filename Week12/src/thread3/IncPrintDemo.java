package thread3;

public class IncPrintDemo {
  private final Object lock = new Object();
  public int n = 0;
  public boolean done = false;

  public IncPrintDemo() {
    Thread incrementor = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000000; i++) {
          System.out.println(Thread.currentThread().getName());
          n++;
          synchronized(lock) {
            lock.notify();
          }
        }
        done = true;
        synchronized (lock) {
          lock.notify();
        }
      }
    });

    Thread printer = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          while (!done) {
            try {
              lock.wait();
              System.out.println(Thread.currentThread().getName() + " " + n);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });

    incrementor.start();
    printer.start();
  }
}
