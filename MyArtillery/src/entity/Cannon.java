package entity;


import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Cannon extends Entity {

  GamePanel gamePanel;
  KeyHandler keyHandler;



  public Cannon(GamePanel gamePanel, KeyHandler keyHandler) {
    this.gamePanel = gamePanel;
    this.keyHandler = keyHandler;
    setDefaultValues();
    getCannonImage();
    width = gamePanel.tileSize * 2;
    height =gamePanel.tileSize * 2;
  }


  public void getCannonImage() {
    try {
      cannonImage = ImageIO.read(getClass().getResourceAsStream("/characters/cannon.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update() {

    if (keyHandler.moveLeftPressed) {
      if (x > 10) x -= speed;
    }
    if (keyHandler.moveRightPressed) {
      if (x < 250) x += speed;
    }

    if (keyHandler.angleLeftPressed) {
      if (angel < 75) angel += speed / 5;
      System.out.println("angel: " + angel);
    }
    if (keyHandler.angleRightPressed) {
      if (angel > 4) angel -= speed / 5;
      System.out.println("angel: " + angel);
    }
    if (keyHandler.powerUpPressed) {
      power += speed / 50.0;
      System.out.println("power: " + power);
    }
    if (keyHandler.powerDownPressed) {
      if (power > 4) power -= speed / 50.0;
      System.out.println("power: " + power);
    }

  }

  public void draw(Graphics2D g2) {

    g2.drawImage(cannonImage, x, y, width, height, null);

  }







}
