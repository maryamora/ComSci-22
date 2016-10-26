import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

 Ball ball = new Ball(this);
 Player1 playerOne = new Player1(this);
 Player2 playerTwo = new Player2(this);
 int speed = 1;
 int playerOneScore = 0;
 int playerTwoScore = 0;
 int playerOnePU = 1;
 int playerTwoPU = 1;

 private int getScore() {
  return speed - 1;
 }
 

 public Game() {
  addKeyListener(new KeyListener() {
   @Override
   public void keyTyped(KeyEvent e) {
   }

   @Override
   public void keyReleased(KeyEvent e) {
    playerOne.keyReleased(e);
   }

   @Override
   public void keyPressed(KeyEvent e) {
    playerOne.keyPressed(e);
   }
  });
  
  //
  
  addKeyListener(new KeyListener() {
   @Override
   public void keyTyped(KeyEvent m) {
   }

   @Override
   public void keyReleased(KeyEvent m) {
    playerTwo.keyReleased(m);
   }

   @Override
   public void keyPressed(KeyEvent m) {
    playerTwo.keyPressed(m);
   }
  });
  
  setFocusable(true);
  Sound.BACK.loop();
 }

 private void move() {
  ball.move();
  playerOne.move();
  playerTwo.move();
 }

 @Override
 public void paint(Graphics g) {
  super.paint(g);
  Graphics2D g2d = (Graphics2D) g;
  g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
  ball.paint(g2d);
  playerOne.paint(g2d);
  playerTwo.paint(g2d);

  g2d.setColor(Color.GRAY);
  g2d.setFont(new Font("Verdana", Font.BOLD, 30));
  g2d.drawString(String.valueOf(playerOneScore), 10, 30);
  g2d.setColor(Color.GRAY);
  g2d.setFont(new Font("Verdana", Font.BOLD, 10));
  g2d.drawString("Power Up: "+playerOnePU, 10, 40);
  
  g2d.setColor(Color.PINK);
  g2d.setFont(new Font("Verdana", Font.BOLD, 30));
  g2d.drawString(String.valueOf(playerTwoScore), 250, 340);
  g2d.setColor(Color.PINK);
  g2d.setFont(new Font("Verdana", Font.BOLD, 10));
  g2d.drawString("Power Up: "+playerTwoPU, 210, 310);
  
 }


 //CREATE RESET FOR 3 games

 public void reset(String player){
   
   Sound.GAMEOVER.play();
   
   if (player.equalsIgnoreCase("Player 1")){
     playerTwoScore++;
     if (playerTwoScore >= 3){
       gameOver(player);
     }else{
       ball.resetBall();
       speed = 1;
       JOptionPane.showMessageDialog(null, "Player 1 wins this round!");
       
     }
   }else if (player.equalsIgnoreCase("Player 2")){
     playerOneScore++;
     if (playerOneScore >= 3){
       gameOver(player);
     }else{
       ball.resetBall();
       speed = 1;
       JOptionPane.showMessageDialog(null, "Player 2 wins this round!");
       
     }
   }
 }
 
 public void powerUp(String player){
   if (player.equalsIgnoreCase("Player 1") && playerTwoPU != 0){
     playerTwoPU = 0;
     speed += 3;
   }else if(player.equalsIgnoreCase("Player 2") && playerOnePU != 0){
     playerOnePU = 0;
     speed += 3;
   }
 }
 
 public void gameOver(String player) {
  Sound.BACK.stop();
  Sound.GAMEOVER.play();
   
   if (player.equalsIgnoreCase("Player 1")){
     playerTwoScore++;
     JOptionPane.showMessageDialog(null,"GAME OVER!!! Player 1 wins!!!!");
     try{
       main(null);
     }catch(InterruptedException e){
       e.printStackTrace();
     }
     
   }else if (player.equalsIgnoreCase("Player 2")){
     JOptionPane.showMessageDialog(null,"GAME OVER!!! Player 2 wins!!!");
     playerOneScore++;
     try{
       main(null);
     }catch(InterruptedException e){
       e.printStackTrace();
     }
    
   }
   
 }

 public static void main(String[] args) throws InterruptedException {
  JFrame frame = new JFrame("Mini Tennis");
  Game game = new Game();
  frame.add(game);
  frame.setSize(300, 400);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  while (true) {
   game.move();
   game.repaint();
   Thread.sleep(10);
  }
 }
}