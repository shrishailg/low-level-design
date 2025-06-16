package main.java.tictactoe.players;

import main.java.tictactoe.pieces.Piece;

public class PlayerDefault extends PlayingPiece {
    private final String name;

    public PlayerDefault(Piece piece, String name) {
        super(piece);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}