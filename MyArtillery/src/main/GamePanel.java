package main;

import entity.Ball;
import entity.Cannon;
import object.OBJ_Monster;
import object.OBJ_explosion;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

  // Screen settings
  static final int originalTileSize = 16;
  static final int scale = 3;

  public static final int tileSize = originalTileSize * scale; // 48 * 48 tile
  public static final int maxScreenCol = 16;
  public static final int maxScreenRow = 12;
  public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
  public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

  //Frames per secs
  int FPS = 60;
  KeyHandler keyHandler = new KeyHandler();
  Thread gameThread;
  TileManager tileManager = new TileManager(this);


  public ObjSetter objSetter = new ObjSetter(this);
  public Cannon cannon = new Cannon(this, keyHandler);
  public Ball ball = new Ball(this, keyHandler);
  public ArrayList<SuperObject> objs = new ArrayList<>();

  public CollisionChecker collisionChecker = new CollisionChecker(this);

  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.getHSBColor(198/360f, 1,1));
    this.setDoubleBuffered(true); // true: all the drawing will be done in an offscreen painting buffer
    this.addKeyListener(keyHandler);
    this.setFocusable(true); // GamePanel can be focused to receive key input
  }

  public void setupGame() {
    objSetter.setObject();
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    System.out.println(this);

    gameThread.start();
  }

  @Override
  public void run() {
    double drawInterval = 1_000_000_000 / FPS; // 0.0167 seconds
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;

    long timer = 0;
    int drawCount = 0; // just for test

    while (gameThread != null) {
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (delta >= 1) {
        // UPDATE: update information
        update();
        // DRAW: draw the screen
        repaint();
        delta--;
      }
    }
  }

  public void update() {
    cannon.update();
    ball.update(cannon);
    if (ball.collideObjIndex >= 0) {
      objs.set(ball.collideObjIndex, new OBJ_explosion(objs.get(ball.collideObjIndex)));
    }

    for (int i = 0; i < objs.size(); i++) {
      if (objs.get(i) != null) {
        objs.get(i).update();
      }
    }

  }


  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    Graphics2D graphics2D = (Graphics2D) graphics;

    tileManager.draw(graphics2D);

    for (int i = 0; i < objs.size(); i++) {
      if (objs.get(i) != null) {
        objs.get(i).draw(graphics2D, this);
      }
    }

    cannon.draw(graphics2D);
    ball.draw(graphics2D);

    graphics2D.dispose();
  }



}
