package csv;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSV {
  public static void main(String[] args) {
    Statistics stats = new Statistics();

    try (DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("src/csv/input"), "*.csv")) {
      paths.forEach(file -> {
        FileHandler fh = new FileHandler(file);
        System.out.println("min: " + stats.min(fh.getNumbers()));
        System.out.println("max: " + stats.max(fh.getNumbers()));
        System.out.println("range: " + stats.range(fh.getNumbers()));
        System.out.println("mean: " + stats.mean(fh.getNumbers()));
        System.out.println("standard deviation: " + stats.sd(fh.getNumbers()));
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
