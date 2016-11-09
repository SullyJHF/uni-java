import java.util.Scanner;

public class Circle {
  private double r;

  public Circle() {
    this.r = inputRadius();
  }

  public Circle(double r) {
    this.r = r;
  }

  public double getRadius() {
    return this.r;
  }

  public double calcPerimiter() {
    return this.r * 2 * Math.PI;
  }

  public double calcArea() {
    return Math.PI * Math.pow(this.r, 2);
  }

  private double inputRadius() {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the radius for your circle: ");
    return input.nextDouble();
  }
}
