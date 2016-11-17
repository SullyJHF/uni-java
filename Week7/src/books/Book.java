package books;

public class Book {
  private String author, title;
  private double price;
  private String format;
  private String[] formats = { "paperback", "hardback", "ebook" };

  public Book(String author, String title, double price, int format) {
    this.author = author;
    this.title = title;
    this.price = price;
    this.format = this.formats[format];
  }

  public Book(String author, String title, double price, String format) {
    this.author = author;
    this.title = title;
    this.price = price;
    this.format = format;
  }

  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public double getPrice() {
    return this.price;
  }

  public String getFormat() {
    return this.format;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
