package models;

public class Teleporter {
    private int startCell;
    private int endCell;

    public Teleporter(int startCell, int endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public int getStartCell() {
        return startCell;
    }

    public void setStartCell(int startCell) {
        this.startCell = startCell;
    }

    public int getEndCell() {
        return endCell;
    }

    public void setEndCell(int endCell) {
        this.endCell = endCell;
    }
}
