package text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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
    this.path = FileSystems.getDefault().getPath("textfiles", filename);
    // make the output filename
    this.outputFilename = "out_" + filename;
    getTextFromFile();
  }

  private void getTextFromFile() {
    try {
      // This loops through each line in the file and appends it to inputText
      Files.lines(this.path, Charset.forName("Cp1252")).forEach(line -> this.inputText.append(line + " "));
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
    try {
      PrintWriter out = new PrintWriter("output/" + outputFilename);
      // loop through each word and add it to the output file
      uniqueWords.forEach(word -> out.println(word));
      // close the PrintWriter as it isn't needed anymore
      out.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void printText() {
    System.out.println(this.inputText.toString());
  }
}
