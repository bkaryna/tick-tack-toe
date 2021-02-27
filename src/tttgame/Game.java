package tttgame;

import java.util.Scanner;

public class Game {
    Player one = new Player();
    Player two = new Player();
    Field board = new Field();

    void setPlayers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter nicknames\nPlayer 1: ");
        one.setNickname(input.next());
        System.out.println("Player 2: ");
        two.setNickname(input.next());
    }

}
