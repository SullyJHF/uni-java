package text;

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
     for(String arg : args) {
       Unique unique = new Unique(arg);
       System.out.print("Processing " + arg);
       unique.process();
       System.out.println(" - Done!");
     }
  }
}
