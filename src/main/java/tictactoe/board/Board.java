package main.java.tictactoe.board;

import main.java.tictactoe.pieces.Piece;
import main.java.tictactoe.pieces.PieceType;
import main.java.tictactoe.players.PlayerDefault;
import main.java.tictactoe.players.PlayingPiece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;
    private final PlayingPiece[][] playingBoard;
    private final PlayerDefault playerDefault;

    public Board(int size) {
        this.size = size;
        this.playingBoard = new PlayingPiece[size][size];
        this.playerDefault = new PlayerDefault(new Piece(PieceType.E), "default");
        initializeTheBoard();
    }

    public PlayingPiece[][] getPlayerBoard() {
        return playingBoard;
    }

    public List<Coordinates> getFreeCoordinates() {
        List<Coordinates> freeCoordinates = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playingBoard[i][j].getPiece().getPieceType() == PieceType.E) {
                    freeCoordinates.add(new Coordinates(i, j));
                }
            }
        }

        return freeCoordinates;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(playingBoard[i][j].getPiece().getPieceType() + " ");
            }

            System.out.println();
        }
    }

    private void initializeTheBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                playingBoard[i][j] = playerDefault;
            }
        }
    }
}
