package books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
  private List<Book> books;
  private Comparator<Book> bookTitleComp = new Comparator<Book>() {
    @Override
    public int compare(Book b1, Book b2) {
      return b1.getTitle().compareTo(b2.getTitle());
    }
  };

  private Comparator<Book> bookDoubleComp = new Comparator<Book>() {
    @Override
    public int compare(Book b1, Book b2) {
      return b1.getPrice() > b2.getPrice() ? 1 : b1.getPrice() == b2.getPrice() ? 0 : -1;
    }
  };

  public Library() {
    this.books = new ArrayList<Book>();
  }

  public void add(Book book) {
    if(book.getTitle().toLowerCase().startsWith("the ")) {
      book.setTitle(book.getTitle().substring(4) + ", The");
    }
    this.books.add(book);
  }

  public void listBooks() {
    for(Book b : books) {
      System.out.printf("%s by %s, £%.2f in %s%n", b.getTitle(), b.getAuthor(), b.getPrice(), b.getFormat());
    }
  }

  public Library searchAuthor(String author) {
    Library tempLibrary = new Library();
    for(Book b : this.books) {
      if(b.getAuthor() == author) {
        tempLibrary.add(b);
      }
    }
    return tempLibrary;
  }

  public Library searchTitle(String title) {
    Library tempLibrary = new Library();
    for(Book b : this.books) {
      if(b.getTitle().toLowerCase().indexOf(title.toLowerCase()) != -1) {
        tempLibrary.add(b);
      }
    }
    return tempLibrary;
  }

  public Library searchFormat(String format) {
    Library tempLibrary = new Library();
    for(Book b : this.books) {
      if(b.getFormat() == format) {
        tempLibrary.add(b);
      }
    }
    return tempLibrary;
  }

  public void sortByTitle() {
    Collections.sort(this.books, bookTitleComp);
  }

  public void sortByPrice() {
    Collections.sort(this.books, bookDoubleComp);
  }
}
