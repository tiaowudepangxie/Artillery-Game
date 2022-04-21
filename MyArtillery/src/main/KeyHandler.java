package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
  public boolean firePressed, powerUpPressed, powerDownPressed, angleLeftPressed, angleRightPressed;
  public boolean moveLeftPressed, moveRightPressed;

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

    int code = e.getKeyCode();

    if(code == KeyEvent.VK_SPACE) {
      firePressed = true;
    }
    if(code == KeyEvent.VK_UP) {
      powerUpPressed = true;
    }
    if(code == KeyEvent.VK_DOWN) {
      powerDownPressed = true;
    }
    if(code == KeyEvent.VK_LEFT) {
      angleLeftPressed = true;
    }
    if(code == KeyEvent.VK_RIGHT) {
      angleRightPressed = true;
    }
    if(code == KeyEvent.VK_A) {
      moveLeftPressed = true;
    }
    if(code == KeyEvent.VK_D) {
      moveRightPressed = true;
    }

  }

  @Override
  public void keyReleased(KeyEvent e) {

    int code = e.getKeyCode();

    if(code == KeyEvent.VK_SPACE) {
      firePressed = false;
    }
    if(code == KeyEvent.VK_UP) {
      powerUpPressed = false;
    }
    if(code == KeyEvent.VK_DOWN) {
      powerDownPressed = false;
    }
    if(code == KeyEvent.VK_LEFT) {
      angleLeftPressed = false;
    }
    if(code == KeyEvent.VK_RIGHT) {
      angleRightPressed = false;
    }
    if(code == KeyEvent.VK_A) {
      moveLeftPressed = false;
    }
    if(code == KeyEvent.VK_D) {
      moveRightPressed = false;
    }

  }
}
