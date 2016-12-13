package aoc_2016.aoc_01;

public class Main {
  public static void main(String[] args) {
    FileHandler fh = new FileHandler("input.txt");
    Inputs inputs = new Inputs(fh.getInputsAsArray());
    Person santa = new Person();
    santa.move(inputs);
    System.out.println("Current Position: (" + santa.getPos().x + ", " + santa.getPos().y + ")");
    System.out.println("Total distance travelled: " + santa.getDistanceTravelled());
    System.out.println("Shortest distance travelled: " + santa.getShortestDistTravelled());
    System.out.println();
    System.out.println("Revisited: (" + santa.getFirstRevisitedPos().x + ", " + santa.getFirstRevisitedPos().y + ")");
    System.out.println("Shortest revisited distance travelled: " + santa.getShortestRevisitedDistTravelled());
  }
}
