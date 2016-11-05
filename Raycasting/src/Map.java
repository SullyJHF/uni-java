import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
  private File mapFile;
  BufferedImage mapImg;
  
  private int w, h;

  public Map(String filepath) {
    this.mapFile = new File(filepath);
    loadImage();
    createArray();
  }

  private void loadImage() {
    try {
      mapImg = ImageIO.read(mapFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private void createArray() {
    this.w = mapImg.getWidth(null);
    this.h = mapImg.getHeight(null);
    System.out.printf("w: %d, h: %d", w, h);
    for(int row = 0; row < this.w; row++) {
      for(int cell = 0; cell < this.h; cell++) {
        mapImg.getRGB(row, cell);
      }
    }
  }
}
