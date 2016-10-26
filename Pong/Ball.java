import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.*;
import java.awt.event.KeyEvent;

public class Ball {
 private static final int DIAMETER = 30;
 
 int x = 50;
 int y = 50;
 int xa = 1;
 int ya = 1;
 private Game game;

 public Ball(Game game) {
  this.game = game;
 }

 public void resetBall(){
   x = randInt();
   y = randInt();
   xa = 1;
   ya = 1;
 }
 
 void move() {
  boolean changeDirection = true;
  if (x + xa < 0)
   xa = game.speed;
  else if (x + xa > game.getWidth() - DIAMETER)
   xa = -game.speed;
  else if (y + ya < 0)
    game.reset("Player 1");
//ya = game.speed;
  else if (y + ya > game.getHeight() - DIAMETER)
   game.reset("Player 2");
  else if (collisionWithPlayerOne()){
   ya = -game.speed;
   y = game.playerOne.getTopY() - DIAMETER;
   game.speed++;
  } else if (collisionWithPlayerTwo()){
    ya = game.speed;
    y = game.playerTwo.getTopY();
    //game.speed++;
  }else
   changeDirection = false;
  
  if (changeDirection) 
   Sound.BALL.play();
  x = x + xa;
  y = y + ya;
 }
 
 protected boolean collisionWithPlayerOne() {
  return game.playerOne.getBounds().intersects(getBounds());
 }
 
 protected boolean collisionWithPlayerTwo() {
   return game.playerTwo.getBounds().intersects(getBounds());
 }

 public void paint(Graphics2D g) {
  g.fillOval(x, y, DIAMETER, DIAMETER);
 }

 public Rectangle getBounds() {
  return new Rectangle(x, y, DIAMETER, DIAMETER);
 }
 
 public static int randInt() {
    Random rn = new Random();
    int randomNum = rn.nextInt((100 - 30) + 1) + 30;
    return randomNum;
 } 
 
  public void keyReleased(KeyEvent e) {
  //xa = 0;
 }
 
}