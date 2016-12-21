package text;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {
  private Path path;
  private String outputFilename;
  private StringBuilder inputText = new StringBuilder();

  public FileHandler() {

  }

  public FileHandler(String filename) {
    loadFile(filename);
  }

  public void loadFile(String filename) {
    // make a Path object of the filename
    this.path = Paths.get("textfiles", filename);
    // make the output filename
    this.outputFilename = "out_" + filename;
    getTextFromFile();
  }

  private void getTextFromFile() {
    try {
      // This loops through each line in the file and appends it to inputText
      Charset charset = Charset.forName("Cp1252");
      // fix this to work with any character encodings
      Files.lines(this.path, charset).forEach(line -> this.inputText.append(line + " "));
    } catch (IOException e) {
      // Print the stack trace if an error occurs
      e.printStackTrace();
    }
  }

  public String getText() {
    // returns the inputText as a string
    return this.inputText.toString();
  }

  public void saveToFile(List<String> uniqueWords) {
    PrintWriter out = null;
    try {
      Path outputPath = Paths.get("output");
      // make sure to create the output folder if it doesn't exist
      if (Files.notExists(outputPath)) Files.createDirectory(outputPath);
      out = new PrintWriter("output/" + outputFilename);
      // loop through each word and add it to the output file
      for (String word : uniqueWords) {
        out.println(word);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (out != null) out.close();
    }
  }

  public void printText() {
    System.out.println(this.inputText.toString());
  }
}
