package main.java.tic_tac_toe.players;

import main.java.tic_tac_toe.pieces.Piece;
import main.java.tic_tac_toe.pieces.PieceType;

public class PlayerX extends PlayingPiece {

    public PlayerX() {
        super(new Piece(PieceType.X));
    }
}
