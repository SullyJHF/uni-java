package aoc_2016.aoc_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
  private Path path;
  private StringBuilder input = new StringBuilder();

  public FileHandler(String filepath) {
    path = Paths.get("src/aoc_2016/aoc_01/res", filepath);
    loadInput();
  }

  private void loadInput() {
    try {
      Files.lines(path).forEach(line -> input.append(line));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getInput() {
    return input.toString();
  }

  public String[] getInputsAsArray() {
    return input.toString().split(", ");
  }
}
