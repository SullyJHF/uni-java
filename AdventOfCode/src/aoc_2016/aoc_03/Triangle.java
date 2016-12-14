package aoc_2016.aoc_03;

public class Triangle {
  int a, b, c;
  public Triangle(int[] tri) {
    this.a = tri[0];
    this.b = tri[1];
    this.c = tri[2];
  }

  public boolean isValid() {
    if(a + b > c && a + c > b && b + c > a) return true;
    return false;
  }
}
