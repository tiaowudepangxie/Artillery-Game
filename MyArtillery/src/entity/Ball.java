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
  boolean isAtStartPoint;

  public int collideObjIndex;
  public static int lives = 16;

  public Ball(GamePanel gamePanel, KeyHandler keyHandler) {
    this.gamePanel = gamePanel;
    this.keyHandler = keyHandler;
    setDefaultValues();
    isAtStartPoint = true;
    this.x += GamePanel.tileSize * 1.5;
    this.y += GamePanel.tileSize * 0.5;
    startX = this.x;
    startY = this.y;
    getBallImage();
    width = GamePanel.tileSize / 3;
    height = GamePanel.tileSize / 3;

    // solidArea
    // here the position x, y are the relative position to this entity
    solidArea = new Rectangle(1, 1, 10, 10);
    solidAreaXOffset = 1;
    solidAreaYOffset = 1;
  }

  @Override
  public void setDefaultValues() {
    x = -100;
    y = -100;
    speed = 5;
    angel = 10;
    power = 0;
  }

  public void getBallImage() {
    try {
      ballImage = ImageIO.read(getClass().getResourceAsStream("/characters/ball.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void update(Entity e) {
    if (isAtStartPoint && keyHandler.firePressed) {
      this.setDefaultValues(e);
      this.x += GamePanel.tileSize * 1.5;
      this.y += GamePanel.tileSize * 0.5;
      startX = this.x;
      startY = this.y;

      lives -= 1;
      isAtStartPoint = false;
    }

    double powerX = this.power * Math.cos(Math.toRadians(this.angel));

    this.x = (int) (this.x + powerX);
    int deltaX = this.x - this.startX;
    int deltaY = (int) (deltaX * Math.tan(Math.toRadians(angel)) - GRAVITY * Math.pow(deltaX / powerX, 2.0) / 2);
    this.y = startY - deltaY;

    collideObjIndex = gamePanel.collisionChecker.checkObject(this, true);

    if (this.y > 10 * GamePanel.tileSize || this.x > 780 || collideObjIndex >= 0) {
      this.isAtStartPoint = true;
      this.setDefaultValues();

    }
  }

  public void draw(Graphics2D g2) {

    g2.drawImage(ballImage, x, y, width, height, null);

  }


}
