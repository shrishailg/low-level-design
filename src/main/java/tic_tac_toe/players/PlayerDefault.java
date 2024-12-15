package main.java.tic_tac_toe.players;

import main.java.tic_tac_toe.pieces.Piece;

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