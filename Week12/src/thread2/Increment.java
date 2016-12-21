package thread2;

public class Increment implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      inc();
    }
    System.out.println(Main.n);
  }

  private void inc() {
    Main.n++;
  }
}
