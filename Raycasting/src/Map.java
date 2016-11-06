import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
  private File mapFile;
  BufferedImage mapImg;

  private ColourHandler ch;;

  private int w, h;

  private int[][] mapArray;

  public Map(String filepath) {
    this.mapFile = new File(filepath);
    this.ch = new ColourHandler();
    loadImage();
    createArray();
  }

  private void loadImage() {
    try {
      this.mapImg = ImageIO.read(mapFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createArray() {
    this.w = this.mapImg.getWidth(null);
    this.h = this.mapImg.getHeight(null);
    this.mapArray = new int[w][h];
    for(int row = 0; row < this.w; row++) {
      for(int cell = 0; cell < this.h; cell++) {
        int rgb = this.mapImg.getRGB(row, cell);
        this.mapArray[row][cell] = this.ch.getMapTileFromColourRGB(rgb);
      }
    }
  }

  public int[][] getMapArray() {
    return this.mapArray;
  }

  public int getWidth() {
    return mapArray.length;
  }

  public int getHeight() {
    return mapArray[0].length;
  }

  public void printMap() {
    for(int[] row : this.mapArray) {
      for(int col : row) {
        System.out.print(col + " ");
      }
      System.out.println();
    }
  }
}
