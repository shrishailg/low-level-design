package main.java.tic_tac_toe;

import main.java.tic_tac_toe.board.Board;
import main.java.tic_tac_toe.gameservice.TicTacToeGame;
import main.java.tic_tac_toe.players.Player;
import main.java.tic_tac_toe.players.PlayerO;
import main.java.tic_tac_toe.players.PlayerX;
import main.java.tic_tac_toe.players.PlayingPiece;

import java.util.Scanner;

public class Client {

    public static void main(String... args) {
        PlayingPiece playingPiece1 = new PlayerX();
        PlayingPiece playingPiece2 = new PlayerO();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the player1 name: ");
        String playerXName = scanner.next();
        System.out.print("Enter the player2 name: ");
       String PlayerOName = scanner.next();

        Player player1 = new Player(playingPiece1, playerXName);
        Player player2 = new Player(playingPiece2,PlayerOName);

        int size = 3;

        Board board = new Board(size);

        TicTacToeGame ticTacToeGame = new TicTacToeGame(board, player1, player2, size);

        String winner = ticTacToeGame.startGame();

        System.out.println("winner of the game is: " + winner);
    }

    public static void readingStream(String[] args) {

    }
}
