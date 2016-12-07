package book;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Screen extends JFrame {
  private final String TITLE = "Book Order Form";
  public Screen() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
      System.out.println(e + ": Look and feel not supported, returning to default look and feel");
    }
    setTitle(TITLE);
    setResizable(false);

    OrderPanel orderPanel = new OrderPanel();
    add(orderPanel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  }
}
