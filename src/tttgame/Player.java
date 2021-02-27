package tttgame;

public class Player {
    String nickname;

    void setNickname(String n){
        nickname=n;
    }

    void showPlayer(){
        System.out.println(nickname);
    }
}