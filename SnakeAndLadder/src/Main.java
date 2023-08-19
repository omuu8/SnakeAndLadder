import models.Board;
import models.Dice;
import models.Player;
import models.Teleporter;
import service.GameService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Snakes and Ladders");
        System.out.println("Do you want to customize the board with snakes and ladders? (y/n)");
        Scanner sc = new Scanner(System.in);
        GameService service = new GameService();
        String resp = sc.next();
        if(resp.equalsIgnoreCase("y")){
            service.customizeBoard();
        }
        List<Teleporter> snakes = new ArrayList<>();
        List<Teleporter> ladders = new ArrayList<>();
        snakes.add(new Teleporter(72,24));
        snakes.add(new Teleporter(99,6));
        ladders.add(new Teleporter(25,50));
        ladders.add(new Teleporter(12,52));
        Queue<Player> players = new LinkedList<>();
        players.add(new Player("Mangesh",11));
        players.add(new Player("Santosh",12));
        Dice ds = new Dice(3);
        Board game = new Board(ds,snakes,ladders,players);
        game.updateMap(players,0);
        game.start();
    }
}