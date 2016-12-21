package thread1;

public class Hello implements Runnable {
  private int num;

  public Hello(int num) {
    this.num = num;
  }
  @Override
  public void run() {
    System.out.println("Hello, world! " + num);
  }
}
