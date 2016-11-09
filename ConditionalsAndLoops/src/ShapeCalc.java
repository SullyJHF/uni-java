import java.util.Scanner;

public class ShapeCalc {
  private Scanner input = new Scanner(System.in);
  private char shape;

  public ShapeCalc() {
    System.out.print("Enter your shape (T, S, R, C): ");
    this.shape = input.findInLine(".").charAt(0);
  }

  public int calcShape() {
    float s1, s2, r;
    switch (this.shape) {
    case 'T':
      System.out.print("Enter the base of your triangle: ");
      s1 = input.nextFloat();
      System.out.print("Enter the height of your triangle: ");
      s2 = input.nextFloat();
      System.out.printf("The area of your triangle is: %.2f%n", calcTriangle(s1, s2));
      break;

    case 'S':
      System.out.print("Enter a side of your square: ");
      s1 = input.nextFloat();
      System.out.printf("The area of your square is: %.2f%n", calcSquare(s1));
      break;

    case 'R':
      System.out.print("Enter the base length of your rectangle: ");
      s1 = input.nextFloat();
      System.out.print("Enter the height of your rectangle: ");
      s2 = input.nextFloat();
      System.out.printf("The area of your rectangle is: %.2f%n", calcRectangle(s1, s2));
      break;

    case 'C':
      System.out.print("Enter the radius of your circle: ");
      r = input.nextFloat();
      System.out.printf("The area of your circle is: %.2f%n", calcCircle(r));
    }
    return 1;
  }

  private float calcTriangle(float b, float h) {
    return 0.5F * b * h;
  }

  private float calcSquare(float s) {
    return s * s;
  }

  private float calcRectangle(float b, float h) {
    return b * h;
  }

  private float calcCircle(float r) {
    return (float) (Math.PI) * r * r;
  }
}
