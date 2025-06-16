package main.java.tictactoe.players;

import main.java.tictactoe.pieces.Piece;
import main.java.tictactoe.pieces.PieceType;

public class PlayerX extends PlayingPiece {

    public PlayerX() {
        super(new Piece(PieceType.X));
    }
}
