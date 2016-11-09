import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your first number here: ");
    int a = input.nextInt();
    System.out.print("Enter your second number here: ");
    int b = input.nextInt();
    System.out.print("Enter your third and final number here: ");
    int c = input.nextInt();
    input.close();

    Calculator calc = new Calculator(a, b, c);

    System.out.printf("%d + %d = %d%n", a, b, calc.sum());
    System.out.printf("%d - %d = %d%n", a, b, calc.difference());
    System.out.printf("%d * %d = %d%n", a, b, calc.product());
    System.out.printf("%d / %d = %f%n", a, b, calc.quotient());
    System.out.printf("%d %% %d = %d%n", a, b, calc.modulus());

    double[] q = calc.quadratic();
    if (q != null) {
      System.out.printf("%dx^2 + %dx + %d = 0 has the roots %f and %f%n", a, b, c, q[0], q[1]);
    } else {
      System.out.println("Discriminant < 0 so no real roots%n");
    }

    Circle circle = new Circle(4.5F);
    circle.printState();

    System.out.println();

    int angle = 30;
    System.out.printf("sin of %d is %f%n", angle, calc.sine(angle));
    System.out.printf("cos of %d is %f%n", angle, calc.cosine(angle));
    System.out.printf("tan of %d is %f%n", angle, calc.tangent(angle));
  }
}
