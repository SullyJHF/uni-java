package aoc_2016.aoc_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
  private Path path;
  private StringBuilder input = new StringBuilder();

  public FileHandler(String filepath) {
    path = Paths.get("src/aoc_2016/aoc_03/res", filepath);
    loadInput();
  }

  private void loadInput() {
    try {
      Files.lines(path).forEach(line -> input.append(line + "\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int[][] getTriangles() {
    int[][] triangles;
    String[] trianglesStr = input.toString().split("\n");
    triangles = new int[trianglesStr.length][3];
    for(int i = 0; i < triangles.length; i++) {
      String[] curTri = trianglesStr[i].split("\\s+");
      // first elm of curTri is an empty string
      int a = Integer.valueOf(curTri[1]);
      int b = Integer.valueOf(curTri[2]);
      int c = Integer.valueOf(curTri[3]);
      triangles[i][0] = a;
      triangles[i][1] = b;
      triangles[i][2] = c;
    }
    return triangles;
  }

  public String getInput() {
    return input.toString();
  }

  public String[] getInputsAsArray() {
    return input.toString().split("\n");
  }
}
