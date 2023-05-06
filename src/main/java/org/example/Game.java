package org.example;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    int round;
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.round = 1;
    }
    private String random() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int) (Math.random() * choices.length);
        return choices[index];
    }
    public void round(){
        Scanner scanner = new Scanner(System.in);
        player1.setChoice(scanner.nextLine().toLowerCase());
        player2.setChoice(random());
        if (player2.getChoice().equals(player1.getChoice())){
        
        }
    }
}
