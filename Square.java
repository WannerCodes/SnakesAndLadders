import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Square extends JPanel{
    int x;
    int y;
    ArrayList<Player> playersOnSquare = new ArrayList<Player>();
    JLabel label = new JLabel("");
    static Board board;
    Square redirect;

    public Square(int x, int y, Board board){
        this.x = x;
        this.y = y;
        this.add(label);
        this.board = board;
    }

    public void add(Player p){
        playersOnSquare.add(p);
        label.setText("");
        for (Player player : playersOnSquare){
            label.setText(label.getText() + player.name + "\n");
        }
    }

    public void remove(Player p){
        playersOnSquare.remove(p);
        label.setText("");
        for (Player player : playersOnSquare){
            label.setText(label.getText() + "\n" + player.name);
        }
        label.setBackground(Color.BLACK);
    }


    public void initGUI(){
        setPreferredSize(new Dimension(80,80));
        setOpaque(false);
    }

    public static void setLaddersSnakes(){
        //ladders
        board.get(0, 9).redirect = board.get(2, 6); //1
        board.get(3, 9).redirect = board.get(6, 8); //4
        board.get(8, 9).redirect = board.get(9, 6); //9
        board.get(0, 7).redirect = board.get(1, 5); //21
        board.get(7, 7).redirect = board.get(3, 1); //28
        board.get(9, 4).redirect = board.get(6, 3); //51
        board.get(8, 2).redirect = board.get(9, 0); //72
        board.get(0, 2).redirect = board.get(1, 0); //80

        //snakes
        board.get(3, 8).redirect = board.get(6, 9); //17
        board.get(6, 4).redirect = board.get(6, 6); //54
        board.get(1, 3).redirect = board.get(1, 8); //62
        board.get(3, 3).redirect = board.get(0, 4); //64
        board.get(6, 1).redirect = board.get(4, 6); //87
        board.get(7, 0).redirect = board.get(7, 2); //92
        board.get(5, 0).redirect = board.get(5, 2); //95
        board.get(2, 0).redirect = board.get(1, 2); //98


    }
}
