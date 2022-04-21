package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Brick extends SuperObject {

  public OBJ_Brick(int row, int col) {
    name = "brick";
    x = GamePanel.tileSize * col;
    y = GamePanel.tileSize * row;

    width = GamePanel.tileSize;
    height = GamePanel.tileSize;

    solidArea = new Rectangle(0, 0, width, height);
    solidAreaXOffset = 0;
    solidAreaYOffset = 0;

    collision = true;

    try {
      image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
