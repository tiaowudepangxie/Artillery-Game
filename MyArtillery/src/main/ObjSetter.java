package main;

import object.OBJ_Brick;
import object.OBJ_Monster;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ObjSetter {
  GamePanel gamePanel;
  int map[][];

  public ObjSetter(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    map = new int[GamePanel.maxScreenRow][GamePanel.maxScreenCol];
    loadMap();
    System.out.println(map);
  }

  public void loadMap() {

    try {
      InputStream fileIn = getClass().getResourceAsStream("/maps/tilemap1.txt");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));

      for (int row = 0; row < GamePanel.maxScreenRow; row++) {
        String line = bufferedReader.readLine();
        String strNums[] = line.split(" ");
        for (int col = 0; col < GamePanel.maxScreenCol; col++) {
          map[row][col] = Integer.parseInt((strNums[col]));
        }
      }
      bufferedReader.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void setObject() {
    gamePanel.objs.add(new OBJ_Monster());

    for (int row = 0; row < GamePanel.maxScreenRow; row++) {
      for (int col = 0; col < GamePanel.maxScreenCol; col++) {
        if (map[row][col] == 1) {
          gamePanel.objs.add(new OBJ_Brick(row, col));
        }
      }
    }



  }

}
