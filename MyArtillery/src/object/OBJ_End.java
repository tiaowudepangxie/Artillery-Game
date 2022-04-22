package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OBJ_End extends SuperObject {
  int lives;
  BufferedImage imageWin;
  BufferedImage imageLose;

  public OBJ_End() {
    name = "End";
    x = 350;
    y = 400;

    width = GamePanel.tileSize * 2;
    height = GamePanel.tileSize;

    try {
      imageWin = ImageIO.read(getClass().getResourceAsStream("/characters/youwin.png"));
      imageLose = ImageIO.read(getClass().getResourceAsStream("/characters/youlose.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void draw(Graphics2D graphics2D, boolean isWin) {
    image = (isWin) ? imageWin : imageLose;
    graphics2D.drawImage(image, x, y, width, height, null);

  }


}
