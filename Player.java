import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Player{
    public static Board board;
    public static Dice dice;
    Square square;
    String name;
    int x = 0;
    int y = 9;
    ImageIcon piece;

    public Player(String name){
        this.name = name;
        setPiece();
    }

    public String getName(){
        return name;
    }

    public ImageIcon getPiece(){
        return piece;
    }

    public void setPiece(){
        new Piece(this);
    }

    public void move(int moves){
        square.remove(this);
        for (int i = 0; i < moves; i++){
            if(x==0 && y == 0){
                board.get(y, x).add(this);
                board.info.setText(this.name + " is the winner!");
                dice.gameOver();
                return ;
            }
            else if(y % 2 != 0){
                if(x == 9){
                    y--;
                }
                else{
                    x++;
                }
            }
            else {
                if(x == 0){
                    y--;
                }
                else{
                    x--;
                }
            }
        }
        square = board.get(x, y);
        if(square.redirect != null){
            square = square.redirect;
            this.x = square.x;
            this.y = square.y;
        }
        square.add(this);
    }

}
