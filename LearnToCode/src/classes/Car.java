package classes;

class Car {
  private String make;
  private int year, totalDistTravelled;
  private float engineSize;


  public Car(String make, int year, float engineSize, int initialDist) {
    this.make = make;
    this.year = year;
    this.engineSize = engineSize;
    this.totalDistTravelled = initialDist;
  }

  public void drive(int distance) {
    if(distance > 0) this.totalDistTravelled += distance;
  }

  public String getMake() {
    return this.make;
  }

  public int getDistanceTravelled() {
    return this.totalDistTravelled;
  }

  public void honk() {
    System.out.println("Honk!");
  }
}
