package books;

public class Media {
  private String author, title, format;
  public Media(String author, String title, String format) {
    this.author = author;
    this.title = title;
    this.format = format;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return this.author;
  }

  public String getFormat() {
    return this.format;
  }
}
