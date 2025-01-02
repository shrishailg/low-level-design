package main.java.tic_tac_toe.players;

import main.java.tic_tac_toe.pieces.Piece;
import main.java.tic_tac_toe.pieces.PieceType;

public class PlayerO extends PlayingPiece{

    public PlayerO() {
        super(new Piece(PieceType.O));
    }
}
