package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Mushrooms extends SuperObject {
  int lives;
  int startX, startY;

  public OBJ_Mushrooms() {
    name = "Mushrooms";
    startX = 10;
    startY = 10;
    lives = 15;
    width = GamePanel.tileSize / 4;
    height = GamePanel.tileSize / 4;

    try {
      image = ImageIO.read(getClass().getResourceAsStream("/characters/ball.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update(int lives) {
    this.lives = lives - 1;
  }

  public void draw(Graphics2D graphics2D) {
    for (int i = 0; i < lives; i++) {
      graphics2D.drawImage(image, startX + (i % 5) * 20, startY + (i / 5) * 20, width, height, null);
    }
  }

}
