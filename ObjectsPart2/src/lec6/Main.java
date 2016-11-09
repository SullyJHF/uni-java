package lec6;

public class Main {
  public static void main(String[] args) {
    Point p0 = new Point(0, 0);
    Point p1 = new Point(2, 10);
    Point p2 = new Point(7, 5);
    Point p3 = new Point(16, 10);
    Point p4 = new Point(17, 9);
    Point p5 = new Point(1, 2, 3);
    Point p6 = new Point(2, 3, 5);
    Point p7 = new Point(6, 5, 11);

    Rectangle r = new Rectangle(p0, 10, 5);
    System.out.printf("Perimiter: %d%n", r.calculatePerimiter());
    System.out.printf("Area: %d%n", r.calculateArea());
    System.out.println();

    Circle c = new Circle(p3, 5);
    boolean inCircle = c.isPointInCircle(p1);
    System.out.printf("Point (%d, %d) is %s the circle with origin (%d, %d) and radius %f%n", p1.x, p1.y,
        inCircle ? "in" : "not in", c.getX(), c.getY(), c.getRadius());
    inCircle = c.isPointInCircle(p4);
    System.out.printf("Point (%d, %d) is %s the circle with origin (%d, %d) and radius %f%n", p4.x, p4.y,
        inCircle ? "in" : "not in", c.getX(), c.getY(), c.getRadius());
    System.out.println();

    Circle s = new Circle(p6, 6);
    boolean inSphere = s.isPointInCircle(p5);
    System.out.printf("Point (%d, %d, %d) is %s the sphere with origin (%d, %d, %d) and radius %f%n", p5.x, p5.y, p5.z,
        inSphere ? "in" : "not in", s.getX(), s.getY(), s.getZ(), s.getRadius());
    inSphere = s.isPointInCircle(p7);
    System.out.printf("Point (%d, %d, %d) is %s the sphere with origin (%d, %d, %d) and radius %f%n", p7.x, p7.y, p7.z,
        inSphere ? "in" : "not in", s.getX(), s.getY(), s.getZ(), s.getRadius());
    System.out.println();

    PostCode postcode = new PostCode("IP5 3FR");
    System.out.println(postcode.pc);
    PostCode postcode1 = new PostCode("A5 5GF");
    System.out.println(postcode1.pc);
    PostCode postcode2 = new PostCode("A5 GRE");
    System.out.println(postcode2.pc);

    Calculator calc = new Calculator(args);
    System.out.println(calc.sum());
    System.out.println(calc.difference());
    System.out.println(calc.product());
    System.out.println(calc.quotient());
  }
}
