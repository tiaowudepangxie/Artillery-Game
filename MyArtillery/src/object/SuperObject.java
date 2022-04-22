package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

  public BufferedImage image;
  public String name;
  public boolean collision = false;
  public int x, y;
  public int width, height;
  public int spriteCounter = 0;
  public int spriteNum = 0;


  public Rectangle solidArea;
  // offset position to it's entity
  public int solidAreaXOffset, solidAreaYOffset;

  public void update() {

  }


  public void draw(Graphics2D graphics2D, GamePanel gamePanel) {
    graphics2D.drawImage(image, x, y, width, height, null);
  }



}
