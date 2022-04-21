package main;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("5004 Artillery");

    // create the panel and it into the window
    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);
    window.pack();

    //show it in the center of the screen
    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.setupGame();
    gamePanel.startGameThread();

    System.out.println("main" + gamePanel);
  }
}
