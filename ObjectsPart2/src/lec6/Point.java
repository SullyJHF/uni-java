package lec6;

public class Point {
  public int x, y, z;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double distanceTo(Point p) {
    int w = p.x - this.x;
    int h = p.y - this.y;
    int d = 0;
    if(Integer.valueOf(p.z) != null) {
      d = p.z - this.z;
    }
    return Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2) + Math.pow(d, 2));
  }
}
