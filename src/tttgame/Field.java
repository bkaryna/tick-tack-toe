package tttgame;

public class Field {
    char[][] field = new char[3][3];

    public Field(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                setSlot(i, j, ' ');
            }
        }
    }

    void showField(){
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j!=0)
                    System.out.print("|"+ field[i][j]);
                else
                    System.out.print(" "+ field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void setSlot(int x, int y, char c){
        field[x][y] = c;
    }

    char getSlot(int x, int y){
        return field[x][y];
    }

    Boolean checkSlotAvailability(int x, int y){
        if(field[x][y]==' ')
            return true;
        else
            return false;
    }

    void clearField(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
            }
        }
    }
}
