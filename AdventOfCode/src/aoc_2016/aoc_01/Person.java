package aoc_2016.aoc_01;

import java.awt.Point;

public class Person {
  private Point startPos = new Point();
  private Point pos = new Point();
  private int distanceTravelled;
  private int curD;
  private final int TOT_DIRS = 4;
  // 0 north
  // 1 east
  // 2 south
  // 3 west

  public Person() {
    this.startPos.setLocation(0, 0);
    this.pos = this.startPos;
    this.curD = 0;
    this.distanceTravelled = 0;
  }

  public void move(Inputs is) {
    for(Input i : is) {
      move(i);
    }
  }

  public void move(Input i) {
    int amount = i.getAmount();
    System.out.println("Current direction: " + this.curD);
    int dirChange = i.getDirection();
    System.out.println("Turning: " + (i.getDirection() == 1 ? "RIGHT" : "LEFT"));
    this.curD += dirChange;
    if(curD < 0) curD += TOT_DIRS;
    curD %= TOT_DIRS;

    System.out.println("Current direction: " + this.curD);

    switch(curD) {
    case 0:
      this.pos.y += amount;
      break;
    case 1:
      this.pos.x += amount;
      break;
    case 2:
      this.pos.y -= amount;
      break;
    case 3:
      this.pos.x -= amount;
      break;
    }
    System.out.println("Amount to move: " + amount);

    System.out.println("New position: (" + this.pos.x + ", " + this.pos.y + ")");

    this.distanceTravelled += amount;
    System.out.println("Distance travelled: " + this.distanceTravelled);
    System.out.println();
  }

  public int getDistanceTravelled() {
    return this.distanceTravelled;
  }

  public int getShortestDistTravelled() {
    return this.pos.x + this.pos.y;
  }

  public Point getStartPos() {
    return this.startPos;
  }

  public Point getPos() {
    return this.pos;
  }
}
