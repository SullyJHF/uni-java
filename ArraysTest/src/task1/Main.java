package task1;

public class Main {
  public static void main(String[] args) {
    int[] a = {17, 89, 27, 11, 91, 42, 73, 90, 5, 56};
    ArrayCalculator ac = new ArrayCalculator(a);

    System.out.println(ac.min());
    System.out.println(ac.max());
    System.out.println(ac.range());
    System.out.println(ac.mean());
    System.out.println(ac.sd());
  }
}
