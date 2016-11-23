package text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TextHandler {
  private String text;
  private String[] words;
  private List<String> uniqueWords;

  private Comparator<String> wordComp = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
      if (s1.length() < s2.length()) return -1;
      if (s1.length() > s2.length()) return 1;
      if (s1.compareTo(s2) < 0) return -1;
      if (s1.compareTo(s2) > 0) return 1;
      return 0;
    }
  };

  public TextHandler() {

  }

  public TextHandler(String text) {
    setText(text);
  }

  public void setText(String text) {
    this.text = text;
    processText();
  }

  private void processText() {
    removePunc();
    fillWords();
    makeUnique();
    sortWords();
  }

  private void removePunc() {
    // regex to preserve all non punctuation characters;
    this.text = this.text.replaceAll("[^a-zA-Z\\s-]", "").replaceAll("\\s+", " ");
  }

  private void fillWords() {
    // take the words String and split it into an array
    this.words = this.text.split(" ");
  }

  private void makeUnique() {
    ArrayList<String> tempWords = new ArrayList<String>();
    // loop through all words
    for (String word : words) {
      word = word.toLowerCase();
      // if the word is in temp words then skip this loop
      if (tempWords.contains(word)) continue;
      // add the word to tempWords
      tempWords.add(word);
    }
    // set uniqueWords equal to tempWords
    this.uniqueWords = tempWords;
  }

  private void sortWords() {
    // This uses the custom word comparator
    Collections.sort(this.uniqueWords, wordComp);
  }

  public List<String> getSortedUniqueWords() {
    // just return the List<String> uniqueWords
    return this.uniqueWords;
  }

  public void printText() {
    System.out.println(this.text);
  }

  public void printWords() {
    for (String word : words) {
      System.out.println(word);
    }
  }

  public void printUniqueWords() {
    String[] tempWords = new String[this.uniqueWords.size()];
    tempWords = this.uniqueWords.toArray(tempWords);
    for (String word : tempWords) {
      System.out.println(word);
    }
  }
}
