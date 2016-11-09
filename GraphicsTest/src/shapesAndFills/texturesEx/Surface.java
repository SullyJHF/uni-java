package shapesAndFills.texturesEx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Surface extends JPanel {
  private BufferedImage darkEnergy;
  private BufferedImage ice;
  private BufferedImage plaster;
  private TexturePaint darkEnergytp;
  private TexturePaint icetp;
  private TexturePaint plastertp;

  public Surface() {
    loadImages();
  }

  private void loadImages() {
    try {
      darkEnergy = ImageIO.read(new File("src/shapesAndFills/texturesEx/res/dark_energy.jpg"));
      ice = ImageIO.read(new File("src/shapesAndFills/texturesEx/res/ice.jpg"));
      plaster = ImageIO.read(new File("src/shapesAndFills/texturesEx/res/plaster.jpg"));
    } catch (IOException e) {
      Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, e);
    }
  }

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    darkEnergytp = new TexturePaint(darkEnergy, new Rectangle(0, 0, 90, 60));
    icetp = new TexturePaint(ice, new Rectangle(0, 0, 90, 60));
    plastertp = new TexturePaint(plaster, new Rectangle(0, 0, 90, 60));
    
    g2d.setPaint(darkEnergytp);
    g2d.fillRect(10, 15, 90, 60);
    
    g2d.setPaint(icetp);
    g2d.fillRect(130, 15, 90, 60);
    
    g2d.setPaint(plastertp);
    g2d.fillRect(250, 15, 90, 60);
    
    g2d.dispose();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }
}
