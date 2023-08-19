package models;

public class Dice {
    private int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int getNoOfDice() {
        return noOfDice;
    }

    public void setNoOfDice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int rollDice(){
        return ((int)(Math.random()*(6*noOfDice - 1*noOfDice)))+noOfDice;
    }
}
