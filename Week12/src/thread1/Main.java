package thread1;

public class Main {
  public static void main(String[] args) {
    Thread[] threads = new Thread[5];
    for(int i = 0; i < 5; i++) {
      threads[i] = new Thread(new Hello(i));
    }

    for(Thread t : threads) {
      t.start();
    }
  }
}
