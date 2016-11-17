package books;

public class Main {
  public static void main(String[] args) {
    Library l = new Library();
    Book harry1 = new Book("J.K Rowling", "Harry Potter and the Philosopher's Stone", 5.34, 0);
    Book harry2 = new Book("J.K Rowling", "Harry Potter and the Chamber of Secrets", 6.99, 0);
    Book dickens1 = new Book("Charles Dickens", "Great Expectations", 3.50, 0);
    Book dickens2 = new Book("Charles Dickens", "Oliver Twist", 10.0, 1);
    Book pratchett1 = new Book("Terry Pratchett", "The Colour of Magic", 4.21, 2);
    Book pratchett2 = new Book("Terry Pratchett", "Mort", 10.30, "hardback");

    l.add(harry1);
    l.add(harry2);
    l.add(dickens1);
    l.add(dickens2);
    l.add(pratchett1);
    l.add(pratchett2);

    System.out.println("ALL BOOKS");
    l.listBooks();
    System.out.println();

    System.out.println("BOOKS BY J.K ROWLING");
    Library harryBooks = l.searchAuthor("J.K Rowling");
    harryBooks.listBooks();
    System.out.println();

    System.out.println("BOOKS WITH 'THE' IN");
    Library booksWithThe = l.searchTitle("the");
    booksWithThe.listBooks();
    System.out.println();

    System.out.println("BOOKS SORTED BY TITLE");
    l.sortByTitle();
    l.listBooks();
    System.out.println();

    System.out.println("BOOKS SORTED BY PRICE");
    l.sortByPrice();
    l.listBooks();
  }
}
