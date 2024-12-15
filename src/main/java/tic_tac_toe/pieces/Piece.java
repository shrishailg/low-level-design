package main.java.tic_tac_toe.pieces;

public class Piece {
    private final PieceType pieceType;

    public Piece( PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
