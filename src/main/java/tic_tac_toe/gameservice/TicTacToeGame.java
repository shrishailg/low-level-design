package main.java.tic_tac_toe.gameservice;

import main.java.tic_tac_toe.board.Board;
import main.java.tic_tac_toe.board.Coordinates;
import main.java.tic_tac_toe.pieces.Piece;
import main.java.tic_tac_toe.pieces.PieceType;
import main.java.tic_tac_toe.players.Player;
import main.java.tic_tac_toe.players.PlayingPiece;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private final int size;
    private final Board gameBoard;
    private final Deque<Player> players;


    public TicTacToeGame(Board board, Player player1, Player player2, int size) {
        this.size = size;
        this.gameBoard = board;
        this.players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
    }

    public String startGame() {
        boolean noPlayerWin = true;

        while (noPlayerWin) {

            // choose player
            Player playerTurn = players.removeFirst();

            // choose coordinates
            List<Coordinates> freeCoordinates = gameBoard.getFreeCoordinates();
            if (freeCoordinates.isEmpty()) {
                noPlayerWin = false;
                continue;
            }

            System.out.println("Enter the coordinates for player "+ playerTurn.getName() + ":");
            Scanner scanner = new Scanner(System.in);
            String inputScanner = scanner.nextLine();

            if (inputScanner.isEmpty()) {
                System.out.println("Enter the details in correct format");
                players.addFirst(playerTurn);
                continue;
            }

            //expecting the input in the form ==> 1,0
            String[] inputs = inputScanner.split(",");

            int row = Integer.parseInt(inputs[0].trim());
            int col = Integer.parseInt(inputs[1].trim());

            boolean isValidMove = addPlayerPiece(playerTurn, row, col);

            if (!isValidMove) {
                System.out.println("Enter the details of the coordinates correctly");
                players.addFirst(playerTurn);
                continue;
            }

            GameCurrentStatus gameCurrentStatus = checkCurrentGameStatus(playerTurn, row, col);

            if (gameCurrentStatus.name().equals(GameCurrentStatus.WON.name())) {
               return playerTurn.getName();
            }

            players.addLast(playerTurn);
        }

        return GameCurrentStatus.DRAW.name();
    }

    private boolean addPlayerPiece(Player player,int row, int col) {
        Piece piece = player.getPlayingPiece().getPiece();

        if (row >= size || row < 0 || col >= size || col < 0) {
            return false;
        }

        PlayingPiece[][] board = gameBoard.getPlayerBoard();

        if (board[row][col].getPiece().getPieceType() != PieceType.E) {
            return false;
        }

        board[row][col] = new PlayingPiece(piece);

        return true;
    }

    private GameCurrentStatus checkCurrentGameStatus(Player player, int row, int col) {
        boolean isRowMatch = true;
        boolean isColMatch = true;
        boolean isPrimaryDiagonalMatch = true;
        boolean isSecondaryDiagonalMatch = true;

        PlayingPiece[][] board = gameBoard.getPlayerBoard();


        //check if the all rows match for the given player
        for (int i = 0; i < size; i++) {
            if (board[row][i].getPiece().getPieceType() != player.getPlayingPiece().getPiece().getPieceType()) {
                isRowMatch = false;
            }
        }

        //check if the all rows match for the given player
        for (int i = 0; i < size; i++) {
            if (board[i][col].getPiece().getPieceType() != player.getPlayingPiece().getPiece().getPieceType()) {
                isColMatch = false;
            }
        }

        //check primary diagonally
        for (int i = 0; i < size; i++) {
            if (board[i][i].getPiece().getPieceType() != player.getPlayingPiece().getPiece().getPieceType()) {
                isPrimaryDiagonalMatch = false;
            }
        }

        //check secondary diagonally
        for (int i = 0, j = size-1; i < size && j>=0; i++, j--) {
            if (board[i][j].getPiece().getPieceType() != player.getPlayingPiece().getPiece().getPieceType()) {
                isSecondaryDiagonalMatch = false;
            }
        }

        if (isRowMatch || isColMatch || isPrimaryDiagonalMatch || isSecondaryDiagonalMatch) {
            return GameCurrentStatus.WON;
        }

        return GameCurrentStatus.IN_PROGRESS;
    }
}
