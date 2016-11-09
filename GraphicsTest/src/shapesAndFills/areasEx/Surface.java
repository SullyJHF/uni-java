package shapesAndFills.areasEx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Surface extends JPanel{
  private static final long serialVersionUID = -9008383368690468067L;

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHints(rh);
    g2d.setPaint(Color.GRAY);
    
    Area a1 = new Area(new Rectangle2D.Double(20, 20, 100, 100));
    Area a2 = new Area(new Ellipse2D.Double(50, 50, 100, 100));
    
    a1.subtract(a2);
    g2d.fill(a1);
    
    Area a3 = new Area(new Rectangle2D.Double(150, 20, 100, 100));
    Area a4 = new Area(new Ellipse2D.Double(150, 20, 100, 100));
    
    a3.subtract(a4);
    g2d.fill(a3);
    
    Area a5 = new Area(new Rectangle2D.Double(280, 20, 100, 100));
    Area a6 = new Area(new Ellipse2D.Double(320, 40, 100, 100));        
    
    a5.add(a6);
    g2d.fill(a5);
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }
}
