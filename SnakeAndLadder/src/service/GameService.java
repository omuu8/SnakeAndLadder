package service;

import models.Board;
import models.Teleporter;

import java.util.List;
import java.util.Scanner;

public class GameService {
    public GameService() {
    }

    Scanner scanner  = new Scanner(System.in);
    Board board = new Board();


    public List<Teleporter> getSnakes(){

    }

    public void customizeBoard() {
        System.out.println("Lets Modify Snakes !");
        System.out.println("Where do you want start ? from 1 to 100");
        int startNo = scanner.nextInt();

    }
}
