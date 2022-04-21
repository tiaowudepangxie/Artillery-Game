package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

  GamePanel gamePanel;
  Tile[] tiles;

  public TileManager(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    tiles = new Tile[5];
    getTileImage();
  }

  public void getTileImage() {
    try {
      tiles[0] = new Tile();
      tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ground2.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2) {
    for (int row = 10; row < gamePanel.maxScreenRow; row++) {
      for (int col = 0; col < gamePanel.maxScreenCol; col++) {
        g2.drawImage(
            tiles[0].image,
            col * gamePanel.tileSize,row * gamePanel.tileSize,
            gamePanel.tileSize, gamePanel.tileSize,
            null
        );
      }
    }

  }

}
