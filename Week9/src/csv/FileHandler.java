package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileHandler {
  private ArrayList<Float> numbers = new ArrayList<Float>();
  private Scanner s = null;

  public FileHandler(Path path) {
    try {
      s = new Scanner(new BufferedReader(new FileReader(path.toString())));
      s.useDelimiter(",");
      while(s.hasNext()) {
        float number = s.nextFloat();
        numbers.add(number);
      }
    } catch(InputMismatchException | IOException e) {
      e.printStackTrace();
    } finally {
      if(s != null) s.close();
    }
  }

  public ArrayList<Float> getNumbers() {
    return this.numbers;
  }
}
