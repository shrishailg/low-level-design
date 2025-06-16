package main.java.tictactoe.players;

import main.java.tictactoe.pieces.Piece;

public class PlayingPiece {
    private Piece piece;

    public PlayingPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
