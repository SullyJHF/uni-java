package lec6;

public class Rectangle {
  private Point a;
  private int w, h;

  public Rectangle(Point a, int w, int h) {
    this.a = a;
    this.w = w;
    this.h = h;
  }

  public int calculatePerimiter() {
    return w * 2 + h * 2;
  }

  public int calculateArea() {
    return w * h;
  }
}
