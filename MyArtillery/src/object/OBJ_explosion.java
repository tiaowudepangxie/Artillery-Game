package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_explosion extends SuperObject {
  public int spriteCounter;
  public int spriteNum;

  int oriWidth, oriHeight;
  int oriX, oriY;

  // kth means appear in the kth (1 ~ 5)
  public OBJ_explosion(SuperObject oriObj) {
    name = "Explosion";
    spriteCounter = 0;
    spriteNum = 0;

    oriWidth = oriObj.width;
    oriHeight = oriObj.height;


    oriX = oriObj.x;
    oriY = oriObj.y;

    try {
      image = ImageIO.read(getClass().getResourceAsStream("/characters/explosion.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update() {
    if (spriteNum == 6) return;

    spriteCounter++;
    if (spriteCounter > 10) {
      spriteNum++;
      spriteCounter = 0;
    }
  }

  // kth = 6 image is null
  @Override
  public void draw(Graphics2D graphics2D, GamePanel gamePanel) {
    width = (oriWidth * spriteNum) / 5;
    height = (oriHeight * spriteNum) / 5;

    x = oriX + (oriWidth - width) / 2;
    y = oriY + (oriHeight - height) / 2;

    if (spriteNum == 6) image = null;

    graphics2D.drawImage(image, x, y, width, height, null);
  }
}