package main.java.tictactoe.players;

import main.java.tictactoe.pieces.Piece;
import main.java.tictactoe.pieces.PieceType;

public class PlayerO extends PlayingPiece{

    public PlayerO() {
        super(new Piece(PieceType.O));
    }
}
