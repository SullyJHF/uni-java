package aoc_2016.aoc_01;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
  private Point startPos = new Point();
  private Point pos = new Point();
  private List<Point> positions;
  private int distanceTravelled;
  private int curD;
  private final int TOT_DIRS = 4;
  // 0 north
  // 1 east
  // 2 south
  // 3 west

  public Person() {
    this.positions = new ArrayList<Point>();
    this.startPos.setLocation(0, 0);
    this.pos = this.startPos;
    this.curD = 0;
    this.distanceTravelled = 0;
  }

  public void move(Inputs is) {
    for (Input i : is) {
      move(i);
    }
  }

  public void move(Input i) {
    int amount = i.getAmount();
    //    System.out.println("Current direction: " + this.curD);
    int dirChange = i.getDirection();
    //    System.out.println("Turning: " + (i.getDirection() == 1 ? "RIGHT" : "LEFT"));
    this.curD += dirChange;
    if (curD < 0) curD += TOT_DIRS;
    curD %= TOT_DIRS;

    //    System.out.println("Current direction: " + this.curD);

    switch (curD) {
    case 0:
      for (int k = 0; k < amount; k++) {
        this.pos.y += 1;
        this.positions.add(new Point(this.pos));
      }
      break;
    case 1:
      for (int k = 0; k < amount; k++) {
        this.pos.x += 1;
        this.positions.add(new Point(this.pos));
      }
      break;
    case 2:
      for (int k = 0; k < amount; k++) {
        this.pos.y -= 1;
        this.positions.add(new Point(this.pos));
      }
      break;
    case 3:
      for (int k = 0; k < amount; k++) {
        this.pos.x -= 1;
        this.positions.add(new Point(this.pos));
      }
      break;
    }
    //    System.out.println("Amount to move: " + amount);

    //    System.out.println("New position: (" + this.pos.x + ", " + this.pos.y + ")");
    this.distanceTravelled += amount;
    //    System.out.println("Distance travelled: " + this.distanceTravelled);
    //    System.out.println();
  }

  public int getDistanceTravelled() {
    return this.distanceTravelled;
  }

  public int getShortestDistTravelled() {
    return Math.abs(this.pos.x) + Math.abs(this.pos.y);
  }

  public void printPositions() {
    for (Point p : this.positions) {
      System.out.println(p);
    }
  }

  public Point getFirstRevisitedPos() {
    ArrayList<Point> revisited = new ArrayList<Point>();
    for (Point p : this.positions) {
      if (Collections.frequency(this.positions, p) > 1) revisited.add(new Point(p));
    }

    int smallestIndex = Integer.MAX_VALUE;
    for (Point p : revisited) {
      //      System.out.println(p + " " + this.positions.indexOf(p));
      int index = this.positions.indexOf(p);
      if (smallestIndex > index) smallestIndex = index;
    }
    //    System.out.println(smallestIndex);
    return this.positions.get(smallestIndex);
  }

  public int getShortestRevisitedDistTravelled() {
    Point p = getFirstRevisitedPos();
    return Math.abs(p.x) + Math.abs(p.y);
  }

  public Point getStartPos() {
    return this.startPos;
  }

  public Point getPos() {
    return this.pos;
  }
}
