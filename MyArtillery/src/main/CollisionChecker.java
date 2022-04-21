package main;

import entity.Entity;

public class CollisionChecker {

  GamePanel gamePanel;

  public CollisionChecker(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
  }

  public int checkObject(Entity entity, boolean isBall) {
    int index = -1;
    for (int i = 0; i < gamePanel.objs.size(); i++) {
      if (gamePanel.objs.get(i) != null && !gamePanel.objs.get(i).name.equals("Explosion")) {
        // get entity's solid area position
        entity.solidArea.x = entity.x + entity.solidAreaXOffset;
        entity.solidArea.y = entity.y + entity.solidAreaYOffset;

        // get the object's solid area position
        gamePanel.objs.get(i).solidArea.x = gamePanel.objs.get(i).x + gamePanel.objs.get(i).solidAreaXOffset;
        gamePanel.objs.get(i).solidArea.y = gamePanel.objs.get(i).y + gamePanel.objs.get(i).solidAreaXOffset;

        if (entity.solidArea.intersects(gamePanel.objs.get(i).solidArea)) {
          System.out.println("collision with obj" + i);
          return i;
        }
      }
    }
    return -1;
  }

}
