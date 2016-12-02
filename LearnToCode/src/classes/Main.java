package classes;

public class Main {
  public static void main(String[] args) {
    Car myCar = new Car("Fiat", 2006, 1.1f, 66700);

    myCar.honk();

    System.out.println(myCar.getMake());
    System.out.println(myCar.getDistanceTravelled());
    myCar.drive(26);
    System.out.println(myCar.getDistanceTravelled());
  }
}
