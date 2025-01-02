package main.java.tic_tac_toe.players;

import main.java.tic_tac_toe.pieces.Piece;

public class PlayingPiece {
    private Piece piece;

    public PlayingPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
