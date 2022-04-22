package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_hearts extends SuperObject {

  int lives;
  int startX, startY;

  public OBJ_hearts() {
    name = "Hearts";
    startX = 650;
    startY = 10;
    lives = 5;
    width = GamePanel.tileSize / 3;
    height = GamePanel.tileSize / 3;

    try {
      image = ImageIO.read(getClass().getResourceAsStream("/characters/heart_full.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update(int lives) {
    this.lives = lives;
  }

  public void draw(Graphics2D graphics2D) {
    for (int i = 0; i < lives; i++) {
      graphics2D.drawImage(image, startX + i * 20, startY, width, height, null);
    }
  }

}
