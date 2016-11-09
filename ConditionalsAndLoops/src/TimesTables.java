
public class TimesTables {
  public void print() {
    for (int i = 1; i <= 12; i++) {
      for (int j = 1; j <= 12; j++) {
        System.out.printf("%d * %d = %d\t", i, j, i * j);
      }
      System.out.println();
    }
  }
}
