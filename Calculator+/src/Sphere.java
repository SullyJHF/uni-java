import java.util.Scanner;

public class Sphere {
  private double r;

  public Sphere() {
    this.r = inputRadius();
  }

  public Sphere(double r) {
    this.r = r;
  }

  public double getRadius() {
    return this.r;
  }

  public double calcVolume() {
    return (4.0 / 3.0) * Math.PI * Math.pow(this.r, 3);
  }

  public double calcSurfaceArea() {
    return 4 * Math.PI * Math.pow(this.r, 2);
  }

  private double inputRadius() {
    Scanner input = new Scanner(System.in);
    return input.nextDouble();
  }
}
