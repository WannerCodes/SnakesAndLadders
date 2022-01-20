import java.util.Random;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dice extends JButton{
    static int number = 0;
    static int turn = 0;
    static ArrayList<Player> playerList;
    static JLabel info;

    Dice(ArrayList<Player> pl, JLabel i){
        initGUI();
        playerList = pl;
        info = i;

        class Trykk implements ActionListener{
            int number = 0;
            Random ran = new Random();
            Dice dice;
            JLabel info;

            Trykk(Dice dice, JLabel i){
                this.dice = dice;
                info = i;
            }

            @Override
            public void actionPerformed(ActionEvent e){
                Dice.number = ran.nextInt(6) + 1;
                dice.setText(Integer.toString(Dice.number));
                Dice.movePlayer(playerList.get(turn));
                if(turn < playerList.size()-1){
                    turn++;
                }
                else if (playerList.size() != 1) turn--;
                info.setText(playerList.get(turn).getName() + "'s move: ");
            }
        }
        this.addActionListener(new Trykk(this, info));
    }

    public static void movePlayer(Player p){
        p.move(number);
    }

    public void initGUI(){
        setPreferredSize(new Dimension(50,50));
        setOpaque(true);
        setFont(new Font("Arial", Font.PLAIN, 18));
        setText("");
    }

    public void gameOver(){
        this.setEnabled(false);
    }

}
