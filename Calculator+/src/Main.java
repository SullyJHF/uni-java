
public class Main {
  public static void main(String[] args) {
    Circle c = new Circle(7.5);
    System.out.println("Radius: " + c.getRadius());
    System.out.println("Perimiter: " + c.calcPerimiter());
    System.out.println("Area: " + c.calcArea());
    System.out.println();
    
    Sphere s = new Sphere(7.5);
    System.out.println("Radius: " + s.getRadius());
    System.out.println("Volume: " + s.calcVolume());
    System.out.println("Surface Area: " + s.calcSurfaceArea());
    System.out.println();
  }
}
