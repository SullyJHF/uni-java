import java.awt.Color;

public class Main {
  private final int MAP_WIDTH = 24;
  private final int MAP_HEIGHT = 24;
  static int[][] worldMap = {
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,2,2,2,2,2,0,0,0,0,3,0,3,0,3,0,0,0,1},
    {1,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,2,0,0,0,2,0,0,0,0,3,0,0,0,3,0,0,0,1},
    {1,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,2,2,0,2,2,0,0,0,0,3,0,3,0,3,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,4,0,4,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,4,0,0,0,0,5,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,4,0,4,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,4,0,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
  };
  
  public final static int SCREEN_WIDTH = 320;
  public final static int SCREEN_HEIGHT = 200;
  
  public static void main(String[] args) {
    double posX = 22, posY = 12;
    double dirX = -1, dirY = 0;
    double planeX = 0, planeY = 0.66;
    
    double time = System.currentTimeMillis();
    double oldTime = time;
    
    boolean done = false;
    
    while(!done) {
      for(int x = 0; x < SCREEN_WIDTH; x++) {
        double cameraX = 2 * x / (double) SCREEN_WIDTH - 1;
        double rayPosX = posX;
        double rayPosY = posY;
        double rayDirX = dirX + planeX * cameraX;
        double rayDirY = dirY + planeY * cameraX;
        
        int mapX = (int) rayPosX;
        int mapY = (int) rayPosY;
        
        double sideDistX, sideDistY;
        
        double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
        double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
        double perpWallDist;
        
        int stepX, stepY;
        
        int hit = 0;
        int side = -1;
        
        if(rayDirX < 0) {
          stepX = -1;
          sideDistX = (rayPosX - mapX) * deltaDistX;
        } else {
          stepX = 1;
          sideDistX = (mapX + 1.0 - rayPosX) * deltaDistX;
        }
        
        if(rayDirY < 0) {
          stepY = -1;
          sideDistY = (rayPosY - mapY) * deltaDistY;
        } else {
          stepY = 1;
          sideDistY = (mapY + 1.0 - rayPosY) * deltaDistY;
        }
        
        while(hit == 0) {
          if(sideDistX < sideDistY) {
            sideDistX += deltaDistX;
            mapX += stepX;
            side = 0;
          } else {
            sideDistY += deltaDistY;
            mapY += stepY;
            side = 1;
          }
          if(worldMap[mapX][mapY] > 0) hit = 1;
        }
        
        if(side == 0) {
          perpWallDist = (mapX - rayPosX + (1 - stepX) / 2) / rayDirX;
        } else {
          perpWallDist = (mapY - rayPosY + (1 - stepY) / 2) / rayDirY;
        }
        
        int lineHeight = (int)(SCREEN_HEIGHT / perpWallDist);
        int drawStart = -lineHeight / 2 + SCREEN_HEIGHT / 2;
        if(drawStart < 0) drawStart = 0;
        int drawEnd = lineHeight / 2 + SCREEN_HEIGHT / 2;
        if(drawEnd >= SCREEN_HEIGHT) drawEnd = SCREEN_HEIGHT - 1;
        
        Color c;
        switch(worldMap[mapX][mapY]) {
        case(1):
          c = Color.RED;
        break;
        case(2):
          c = Color.GREEN;
        break;
        case(3):
          c = Color.BLUE;
        break;
        case(4):
          c = Color.WHITE;
        break;
        default:
          c = Color.YELLOW;
        }
        
        if(side == 1) {
          c = c.darker();
        }
        
        //draw the line
        
        oldTime = time;
        time = System.currentTimeMillis();
        double frameTime = (time - oldTime) / 1000.0;
        System.out.println(1.0 / frameTime);
        //repaint the screen
        
        double moveSpeed = frameTime * 5.0;
        double rotSpeed = frameTime * 3.0;
      }
    }
  }
}
