package text;

public class Main {
  public static void main(String[] args) {
    FileHandler fileHandler = new FileHandler();
    fileHandler.loadFile("shakespeare1.txt");

    TextHandler textHandler = new TextHandler(fileHandler.getText());

    fileHandler.saveToFile(textHandler.getSortedUniqueWords());
  }
}
