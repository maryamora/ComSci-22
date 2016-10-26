import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Player2 {
 private static final int Y = 5;
 private static final int WITH = 60;
 private static final int HEIGHT = 10;
 int x = 0;
 int xa = 0;
 private Game game;

 public Player2(Game game) {
  this.game = game;
 }
 
 public void move() {
  if (x + xa > 0 && x + xa < game.getWidth() - WITH)
   x = x + xa;
 }

 public void paint(Graphics2D g) {
   g.setColor(Color.BLACK);
   g.fillRect(x, Y, WITH, HEIGHT);
 }

 public void keyReleased(KeyEvent e) {
  xa = 0;
 }

 public void keyPressed(KeyEvent e) {
  if (e.getKeyCode() == KeyEvent.VK_A)
   xa = -game.speed;
  if (e.getKeyCode() == KeyEvent.VK_D)
   xa = game.speed;
  if (e.getKeyCode() == KeyEvent.VK_SHIFT)
     game.powerUp("Player 1");
 }

 public Rectangle getBounds() {
  return new Rectangle(x, Y, WITH, HEIGHT);
 }

 public int getTopY() {
  return HEIGHT + Y;
 }
}