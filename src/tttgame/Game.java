package tttgame;

import java.util.Scanner;

public class Game {
    Player one = new Player();
    Player two = new Player();
    Field board = new Field();

    void setPlayers() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter nicknames\nPlayer 1: ");
        one.setNickname(input.next());
        System.out.print("Player 2: ");
        two.setNickname(input.next());
    }

    void makeMove(char character){
        int x, y;
        do {
        Scanner input = new Scanner(System.in);
        if (character=='x')
            System.out.print(one.getNickname() + ", enter coordinates: ");
        else
            System.out.print(two.getNickname() + ", enter coordinates: ");

            x = input.nextInt();
            y = input.nextInt();

            if (x>2||y>2||x<0||y<0)
                System.out.println("Wrong coordinates. Try again.");
        } while (x>2||y>2||x<0||y<0);

        if (board.checkSlotAvailability(x,y)==true)
            board.setSlot(x,y,character);
        else {
            System.out.println("This slot is taken. Try again.");
            makeMove(character);
        }
    }

    Boolean checkAllOptions(char player){
        if (board.getSlot(0,0)==player && board.getSlot(1,1)==player && board.getSlot(2,2)==player)
            return true;
        else if (board.getSlot(0,2)==player && board.getSlot(1,1)==player && board.getSlot(2,0)==player)
            return true;
        else if (board.getSlot(0,0)==player && board.getSlot(0,1)==player && board.getSlot(0,2)==player)
            return true;
        else if (board.getSlot(1,0)==player && board.getSlot(1,1)==player && board.getSlot(1,2)==player)
            return true;
        else if (board.getSlot(2,0)==player && board.getSlot(2,1)==player && board.getSlot(2,2)==player)
            return true;
        else if (board.getSlot(2,0)==player && board.getSlot(1,0)==player && board.getSlot(2,0)==player)
            return true;
        else if (board.getSlot(0,1)==player && board.getSlot(1,1)==player && board.getSlot(2,1)==player)
            return true;
        else if (board.getSlot(0,2)==player && board.getSlot(1,2)==player && board.getSlot(2,2)==player)
            return true;
        else
            return false;
    }

    Boolean ifWon(char player){
        if (checkAllOptions(player)==true)
            return true;
        else
            return false;
    }

    void play(){
        setPlayers();
        for (int i = 0; i < 9; i++) {
            board.showField();
            if (i%2==0) {
                makeMove('x');
                if (i >= 3)
                    if (ifWon('x')==true) {
                        System.out.println(one.getNickname() + " won!");
                        break;
                    }
            }
            else {
                makeMove('o');
                if (i >= 3)
                    if (ifWon('o')==true) {
                        System.out.println(two.getNickname() + " won!");
                        break;
                    }
            }
        }
    }



}
