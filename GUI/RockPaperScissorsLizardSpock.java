//Created by Mary Danielle C. Amora

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.util.Random;
import javax.swing.*;

public class RockPaperScissorsLizardSpock extends Frame {
 private Label lblOne;
 private CheckboxGroup cbg;
 private TextArea textArea;
 private Button btn;
 private Label player;
 private TextField playerScore;
 private Label computer;
 private TextField computerScore;
 private int playerScoreVal = 0;
 private int pcScoreVal = 0;
 
 public RockPaperScissorsLizardSpock(){
   
   setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
   lblOne = new Label("Your Choice: ");
   cbg = new CheckboxGroup();
   Checkbox rock = new Checkbox("Rock", cbg, false);
   Checkbox paper = new Checkbox("Paper", cbg, false);
   Checkbox scissors = new Checkbox("Scissors", cbg, false);
   Checkbox lizard = new Checkbox("Lizard", cbg, false);
   Checkbox spock = new Checkbox("Spock", cbg, false);
   textArea = new TextArea("Results:",5,40);
   textArea.setEditable(false);
   btn = new Button("RockPaperScissorsLizardSpock!");
   player = new Label("Player's Score: \n");
   playerScore = new TextField("",10);
   playerScore.setEditable(false);
   playerScore.setBackground(Color.GREEN);
   computer = new Label("Computer's Score: ");
   computerScore = new TextField("",10);
   computerScore.setBackground(Color.GREEN);
   computerScore.setEditable(false);
   
   add(lblOne);
   add(rock);
   add(paper);
   add(scissors);
   add(lizard);
   add(spock);
   add(textArea);
   add(btn);
   add(player);
   add(playerScore);
   add(computer);
   add(computerScore);
   
   setTitle("RockPaperScissorsLizardSpock");
   setSize(500, 500);
   setVisible(true);
   
   btn.addActionListener(new MyActionListener());
 
 }
 
 class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          String selected = cbg.getSelectedCheckbox().getLabel();
          int pcChoice;
          String pc;
          pcChoice = randInt();
          if (pcChoice == 1){
           pc = "rock";
           if (selected.equalsIgnoreCase("scissors")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Scissors and the computer chose Rock\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Lizard")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Lizard and the computer chose Rock\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Spock")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Spock and the computer chose Rock\nYou won this round!\n");
           }else if(selected.equalsIgnoreCase("Paper")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Paper and the computer chose Rock\nYou won this round!\n");
           }else{
             textArea.setText("Results:\nYou chose "+selected+" and the computer chose Rock\nDRAW!\n");
           }
          }
          
          if (pcChoice == 2){
           pc = "Paper";
           if (selected.equalsIgnoreCase("Rock")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Rock and the computer chose Paper\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Spock")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Spock and the computer chose Paper\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Scissors")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Scissors and the computer chose Paper\nYou won this round!\n");
           }else if(selected.equalsIgnoreCase("Lizard")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Lizard and the computer chose Paper\nYou won this round!\n");
           }else{
             textArea.setText("Results:\nYou chose "+selected+" and the computer chose Paper\nDRAW!\n");
           }
          }
          
          
          if (pcChoice == 3){
           pc = "Scissors";
           if (selected.equalsIgnoreCase("Lizard")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Lizard and the computer chose Scissors\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Paper")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Paper and the computer chose Scissors\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Rock")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Rock and the computer chose Scissors\nYou won this round!\n");
           }else if(selected.equalsIgnoreCase("Spock")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Spock and the computer chose Scissors\nYou won this round!\n");
           }else{
             textArea.setText("Results:\nYou chose "+selected+" and the computer chose Scissors\nDRAW!\n");
           }
          }
          
          
          if (pcChoice == 4){
           pc = "Lizard";
           if (selected.equalsIgnoreCase("Paper")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Paper and the computer chose Lizard\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Spock")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Spock and the computer chose Lizard\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Rock")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Rock and the computer chose Lizard\nYou won this round!\n");
           }else if(selected.equalsIgnoreCase("Scissors")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Scissors and the computer chose Lizard\nYou won this round!\n");
           }else{
             textArea.setText("Results:\nYou chose "+selected+" and the computer chose Lizard\nDRAW!\n");
           }
          }
          
          
          if (pcChoice == 5){
           pc = "Spock";
           if (selected.equalsIgnoreCase("Rock")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Rock and the computer chose Spock\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Scissors")){
             pcScoreVal++;
             textArea.setText("Results:\nYou chose Scissors and the computer chose Spock\nYou lost this round!\n");
           }else if(selected.equalsIgnoreCase("Paper")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Paper and the computer chose Spock\nYou won this round!\n");
           }else if(selected.equalsIgnoreCase("Lizard")){
             playerScoreVal++;
             textArea.setText("Results:\nYou chose Lizard and the computer chose Spock\nYou won this round!\n");
           }else{
             textArea.setText("Results:\nYou chose "+selected+" and the computer chose Spock\nDRAW!\n");
           }
          }
          
          if (playerScoreVal > pcScoreVal){
            playerScore.setBackground(Color.GREEN);
            computerScore.setBackground(Color.PINK);
          }else if (pcScoreVal > playerScoreVal){
            playerScore.setBackground(Color.PINK);
            computerScore.setBackground(Color.GREEN);
          }else{
            playerScore.setBackground(Color.GREEN);
            computerScore.setBackground(Color.GREEN);
          }
          playerScore.setText(""+playerScoreVal);
          computerScore.setText(""+pcScoreVal);
          
          if (playerScoreVal >= 5 || pcScoreVal >= 5){
            if (playerScoreVal > pcScoreVal){
              JOptionPane.showMessageDialog(null,"Game Over! You won!");
              main(null);
            }else if (playerScoreVal < pcScoreVal){
              JOptionPane.showMessageDialog(null,"Game Over! You lost!");
              main(null);
            }else{
              JOptionPane.showMessageDialog(null,"Game Over! It's a tie!");
              main(null);
            }
          }
          
        }
    }
 public static int randInt() {
    Random rn = new Random();
    int randomNum = rn.nextInt((5 - 1) + 1) + 1;
    return randomNum;
} 
 
  public static void main(String[] args) {
         new RockPaperScissorsLizardSpock();
  }
 
}
