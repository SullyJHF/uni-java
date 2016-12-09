package menuTest;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame {

  public Main() {
    super("Menu Test");
    setSize(new Dimension(300, 150));
    setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    JMenu file = new JMenu("File");
    JMenuItem newFile = new JMenuItem("New File...");
    JMenuItem openFile = new JMenuItem("Open...");
    file.add(newFile);
    file.add(openFile);

    JMenu edit = new JMenu("Edit");
    JMenuItem cutEdit = new JMenuItem("Cut");
    JMenuItem copyEdit = new JMenuItem("Copy");
    JMenuItem pasteEdit = new JMenuItem("Paste");
    edit.add(cutEdit);
    edit.add(copyEdit);
    edit.add(pasteEdit);

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(file);
    menuBar.add(edit);

    setJMenuBar(menuBar);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      Main m = new Main();
      m.setVisible(true);
    });
  }

}
