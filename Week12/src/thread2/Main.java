package thread2;

public class Main {
  public static int n = 0;
  public static void main(String[] args) throws InterruptedException {
    Main m = new Main();
    Thread t1 = new Thread(new Increment());
    Thread t2 = new Thread(new Increment());
    t1.start();
    t1.join();
    t2.start();
  }
}
