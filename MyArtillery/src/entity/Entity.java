package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
the super class for player, balls, monster, and NPC classes
 */
public class Entity {

  public int x, y;
  public int speed;

  public int angel;
  public float power;

  public int width;
  public int height;

  public BufferedImage cannonImage, ballImage;

  public Rectangle solidArea;
  // offset position to it's entity
  public int solidAreaXOffset, solidAreaYOffset;

  public void setDefaultValues() {
    x = 60;
    y = 400;
    speed = 5;
    angel = 10;
    power = 0;
  }

  public void setDefaultValues(Entity e) {
    this.x = e.x;
    this.y = e.y;
    this.speed = e.speed;
    this.angel = e.angel;
    this.power = e.power;
  }
}
