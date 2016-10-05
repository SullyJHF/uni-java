
public class Ascending {
  int a, b;

  public Ascending(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public void check() {
    if (this.a < this.b) {
      System.out.printf("%d %d%n", this.a, this.b);
    } else if (this.a == this.b) {
      System.out.printf("Both numbers are equal %d%n", this.a);
    } else {
      System.out.printf("%d %d%n", this.b, this.a);
    }
  }
}
