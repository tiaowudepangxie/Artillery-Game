package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Ball extends Entity {
  private final double GRAVITY = 0.1;

  GamePanel gamePanel;
  KeyHandler keyHandler;
  int startX;
  int startY;

  public int collideObjIndex;

  public Ball(GamePanel gamePanel, KeyHandler keyHandler) {
    this.gamePanel = gamePanel;
    this.keyHandler = keyHandler;
    setDefaultValues();
    this.x += GamePanel.tileSize * 1.5;
    this.y += GamePanel.tileSize * 0.5;
    startX = this.x;
    startY = this.y;
    getBallImage();
    width = GamePanel.tileSize / 4;
    height = GamePanel.tileSize / 4;

    // solidArea
    // here the position x, y are the relative position to this entity
    solidArea = new Rectangle(1, 1, 10, 10);
    solidAreaXOffset = 1;
    solidAreaYOffset = 1;

  }

  public void getBallImage() {
    try {
      ballImage = ImageIO.read(getClass().getResourceAsStream("/characters/ball.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void update(Entity e) {
    double powerX = this.power * Math.cos(Math.toRadians(this.angel));

    this.x = (int) (this.x + powerX);
    int deltaX = this.x - this.startX;
    int deltaY = (int) (deltaX * Math.tan(Math.toRadians(angel)) - GRAVITY * Math.pow(deltaX / powerX, 2.0) / 2);
    this.y = startY - deltaY;

    collideObjIndex = gamePanel.collisionChecker.checkObject(this, true);

    if (this.y > 10 * GamePanel.tileSize || this.x > 780 || collideObjIndex >= 0) {
      this.setDefaultValues(e);
      this.x += GamePanel.tileSize * 1.5;
      this.y += GamePanel.tileSize * 0.5;
      startX = this.x;
      startY = this.y;
    }
  }

  public void draw(Graphics2D g2) {

    g2.drawImage(ballImage, x, y, width, height, null);

  }


}
