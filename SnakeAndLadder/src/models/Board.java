package models;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Board {
    private Dice dice;

    private Queue<Player> players;

    private List<Teleporter> snakes;
    private List<Teleporter> ladders;

    static Map<String,Integer> playerPositions;
    private int boardSize;
    public Board(Dice dice, List<Teleporter> snakes, List<Teleporter> ladders,Queue<Player> players) {
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        playerPositions = new HashMap<>();
        boardSize = 100;
    }

    public void updateMap(Queue<Player> players,int initialPos){
        for(Player p : players){
            playerPositions.put(p.getName(),initialPos);
        }
    }
    public void start(){
        while(players.size() > 1){
            Player currPlayer = players.poll();
            int currPos = playerPositions.get(currPlayer.getName());
            int diceVal = this.dice.rollDice();
            int nextCellVal = currPos+diceVal;

            if(nextCellVal > boardSize){
                this.players.add(currPlayer);
            }else if(nextCellVal == boardSize){
                System.out.println("Here we got the winner "+currPlayer.getName());
                return;
            }else{
                int[] nextPossible = new int[1];
                boolean[] snakeChecker = new boolean[1];
                nextPossible[0] = nextCellVal;
                this.snakes.forEach((s)->{
                    if(nextCellVal == s.getStartCell()){
                        nextPossible[0] = s.getEndCell();
                        snakeChecker[0] = true;
                    }
                });
                this.ladders.forEach((l)->{
                    if(nextCellVal == l.getStartCell()){
                        nextPossible[0] = l.getEndCell();
                    }
                });
                if(snakeChecker[0] && nextCellVal != nextPossible[0]){
                    System.out.println(currPlayer.getName()+" got bitten by snake :(");
                }
                if(nextCellVal != nextPossible[0]){
                    System.out.println(currPlayer.getName()+" got ladder :)");
                }
                if(nextPossible[0] == boardSize){
                    System.out.println("Here we got the winner "+currPlayer.getName());
                    return;
                }else{
                    System.out.println(currPlayer.getName() + " is at position "+nextPossible[0]);
                    this.players.offer(currPlayer);
                    playerPositions.put(currPlayer.getName(), nextPossible[0]);
                }
            }

        }
    }

}
