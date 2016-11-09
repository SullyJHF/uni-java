package lec6;

public class Circle {
  private Point o;
  private double r;

  public Circle(Point o, double r) {
    this.o = o;
    this.r = r;
  }

  public boolean isPointInCircle(Point p) {
    if(p.distanceTo(this.o) <= this.r) {
      return true;
    }
    return false;
  }

  public int getX() {
    return this.o.x;
  }

  public int getY() {
    return this.o.y;
  }

  public int getZ() {
    return this.o.z;
  }

  public double getRadius() {
    return this.r;
  }
}
