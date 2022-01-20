
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Piece{
    String[] pieces = {"purple_piece.png", "blue_piece.png", "green_piece.png", "red_piece.png"};
    int pieceCount = 0;

    public Piece(Player p){
        String link = pieces[pieceCount];
        ImageIcon icon = new ImageIcon(link);
        p.piece = icon;
    }
}
