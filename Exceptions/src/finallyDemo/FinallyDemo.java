package finallyDemo;

public class FinallyDemo {

  public static int method1() {
    try {
      return 1;
    } finally {
      System.out.println("Within finally block.");
      return 2;
    }
  }

  public static void main(String args[]) {
    System.out.println(FinallyDemo.method1());
  }
}
