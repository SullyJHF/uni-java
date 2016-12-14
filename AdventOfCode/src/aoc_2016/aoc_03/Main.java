package aoc_2016.aoc_03;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    FileHandler fh = new FileHandler("input.txt");
    ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    int[][] tris = fh.getTriangles();
    int totalCount = 0;
    int validCount = 0;
    for(int[] tri : tris) {
      Triangle triangle = new Triangle(tri);
      if(triangle.isValid()) validCount++;
      triangles.add(triangle);
      totalCount++;
    }
    System.out.println(totalCount + " : " + validCount);

    tris = fh.getExTriangles();
    totalCount = 0;
    validCount = 0;
    for (int[] tri : tris) {
      Triangle triangle = new Triangle(tri);
      if (triangle.isValid()) validCount++;
      triangles.add(triangle);
      totalCount++;
    }
    System.out.println(totalCount + " : " + validCount);
  }
}
