package test;

import java.awt.Color;

public class Ball {
  public int size;
  public float x, y, yVel, xVel;
  public Color color;
  public int aliveTicks;

  public Ball(float x, float y, int size, float yVel, float xVel, Color color) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.yVel = yVel;
    this.xVel = xVel;
    this.color = color;
    this.aliveTicks = 0;
  }
}
