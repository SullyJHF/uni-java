package text;

// S182016

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Unique {
  FileHandler fileHandler;
  TextHandler textHandler;
  String currentFilename;

  public Unique(String filename) {
    this.currentFilename = filename;
    this.fileHandler = new FileHandler();
    this.textHandler = new TextHandler();
  }

  public void process() {
    this.fileHandler.loadFile(this.currentFilename);
    this.textHandler.setText(this.fileHandler.getText());
    this.fileHandler.saveToFile(this.textHandler.getSortedUniqueWords());
  }

  public static void main(String[] args) {
    if (args.length > 0) {
      for (String arg : args) {
        Unique unique = new Unique(arg);
        System.out.print("Processing " + arg);
        unique.process();
        System.out.println(" - Done!");
      }
    } else {
      try (DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("textfiles"), "*.txt")) {
        paths.forEach(filePath -> {
          String filePathStr = filePath.toString();
          int lastDot = filePathStr.lastIndexOf('.');

          if (lastDot > -1 && filePathStr.substring(lastDot + 1).equals("txt") && Files.isRegularFile(filePath)) {
            String filename = filePath.getFileName().toString();
            Unique unique = new Unique(filename);
            System.out.print("Processing " + filename);
            unique.process();
            System.out.println(" - Done!");
          }
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}
