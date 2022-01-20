import java.util.*;

public class Game{
    static int number;
    static ArrayList<Player> playerList = new ArrayList<Player>();

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        //uses cmd to input the right amount of players
        System.out.print("Enter the number of players: \n > ");
        number = scanner.nextInt();
        scanner.nextLine();

        //adds players names to game
        for(int i = 1; i < number+1; i++){
            System.out.print("Enter player number " + i + "'s name:\n > ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            playerList.add(player);
        }

        //creates the board
        Board board = new Board(playerList);
        Player.board = board;
    }
}
