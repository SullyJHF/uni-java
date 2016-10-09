package textEx;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class Surface extends JPanel {
  private static final long serialVersionUID = 1L;

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawString("Java 2D", 50, 50);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }
}
