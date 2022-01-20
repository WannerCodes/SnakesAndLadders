import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import javax.imageio.ImageIO.*;
import java.awt.image.*;

public class Board extends Canvas{
    Square[][] board;
    ArrayList<Player> playerList;
    static JLabel info = new JLabel();
    String filepath = new String("");

    public Board(ArrayList<Player> pl) throws IOException{
        playerList = pl;
        board = new Square[10][10];


        JFrame window = new JFrame("Board");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel game = new JLabel();
        game.setIcon(new ImageIcon(filepath));
        JPanel setup = new JPanel();
        JPanel squares = new JPanel();

        game.setLayout(new GridBagLayout());

        squares.setLayout(new GridLayout(10, 10));
        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                board[y][x] = new Square(y, x, this);
                board[y][x].initGUI();
                squares.add(board[y][x]);
            }
        }
        squares.setOpaque(false);
        setStartSquare();
        Square.setLaddersSnakes();

        game.add(squares);
        setup.add(game);

        setup.setLayout(new BoxLayout(setup, BoxLayout.X_AXIS));
        JPanel infoPanel = new JPanel();
        info.setText(playerList.get(0).getName() + "'s move: ");

        JPanel dicePanel = new JPanel();
        Dice dice = new Dice(playerList, info);
        Player.dice = dice;


        //add panels
        infoPanel.add(info);
        setup.add(infoPanel);
        dicePanel.add(dice);
        setup.add(dicePanel);


        window.add(setup);

        window.pack();
        window.setVisible(true);
    }


    public Square get(int x, int y){
        return board[x][y];
    }

    public void setStartSquare(){
        Square square = get(0, 9);
        square.label.setText("START");
        for (Player player : playerList)player.square = square;
    }

}
