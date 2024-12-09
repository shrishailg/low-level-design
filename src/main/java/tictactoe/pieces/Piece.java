package main.java.tictactoe.pieces;

public class Piece {
    private final PieceType pieceType;

    public Piece( PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
