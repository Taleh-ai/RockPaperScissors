package org.example;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private int round;

    public Game(Player player1) {
        this.player1 = player1;
        this.player2 = new Player("Computer");
        this.round = 1;
    }



    public void playRound() {
        System.out.print(player1.getName() + ", enter your choice (rock, paper, or scissors): ");
        player1.setChoice(playerChoices());
        player2.setChoice(random());
       String result =  calculateResult(player1.getChoice(),player2.getChoice());
        if (result.equals(player1.getName() + " wins!")) {
            player1.setScore(player1.getScore() + 1);
        } else if (result.equals(player2.getName() + " wins!")) {
            player2.setScore(player2.getScore() + 1);
        }
        System.out.println(result);
        round++;

    }

    public void playGame() {
        System.out.println("Let's play Rock Paper Scissors!");

        while (true) {
            System.out.println();
            System.out.println("Round " + this.round);

            this.playRound();
            System.out.println("Player1: "+this.player1.getChoice() + " and Player2: " +this.player2.getChoice());
            System.out.println(this.player1.getName() + " score: " + this.player1.getScore());
            System.out.println(this.player2.getName() + " score: " + this.player2.getScore());

            System.out.print("Play another round? (y/n) ");
            String choice = playerChoices();

            if (choice.equals("n")) {
                break;
            }
        }

        if (this.player1.getScore() > this.player2.getScore()) {
            System.out.println("Score:"+this.player1.getScore()+':'+this.player2.getScore());
            System.out.println(this.player1.getName() + " wins the game!");

        } else if (this.player2.getScore() > this.player1.getScore()) {
            System.out.println("Score:"+this.player1.getScore()+':'+this.player2.getScore());
            System.out.println(this.player2.getName() + " wins the game!");
        } else {
            System.out.println("It's a tie game!");
        }
    }

    private String random() {
        String[] choices = {"rock", "paper", "scissors"};
        int random = (int) (Math.random() * choices.length);
        return choices[random];
    }
    public String playerChoices(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().toLowerCase();
    }
    private String calculateResult(String player1Choice, String player2Choice) {
        if (player1Choice.equals(player2Choice)) {
            return "It's a tie!";
        } else if (player1Choice.equals("rock") && player2Choice.equals("scissors") ||
                player1Choice.equals("paper") && player2Choice.equals("rock") ||
                player1Choice.equals("scissors") && player2Choice.equals("paper")) {
            return player1.getName() + " wins!";
        } else {
            return player2.getName() + " wins!";
        }
    }
}
