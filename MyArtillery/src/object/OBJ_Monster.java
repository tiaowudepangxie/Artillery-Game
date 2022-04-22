package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class OBJ_Monster extends SuperObject{
  boolean isUp;
  public static int lives = 6;

  public OBJ_Monster() {
    name = "Monster";
    Random ran = new Random();
    x = ran.nextInt(150) + 550;
    y = ran.nextInt(380) + 10;
    width = GamePanel.tileSize * 2;
    height = GamePanel.tileSize * 2;

    isUp = true;
    lives -= 1;

    // (x, y) should be the offset position from entity
    solidArea = new Rectangle(0, 0, (int) (48 * 1.5), (int) (48 * 1.8));
    solidAreaXOffset = 0;
    solidAreaYOffset = 0;

    collision = true;


    try {
      image = ImageIO.read(getClass().getResourceAsStream("/characters/monster.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update() {
    int speed = 3;

    if (isUp) {
      if (y > 10) {
        y -= speed;
      } else {
        isUp = false;
      }
    } else {
      if (y < 400) {
        y += speed;
      } else {
        isUp = true;
      }
    }

  }



}
