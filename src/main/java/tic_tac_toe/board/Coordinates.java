package main.java.tic_tac_toe.board;

public class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int x, int y) {
        this.row = x;
        this.col = y;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
