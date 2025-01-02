package main.java.snake_ladder;

import java.util.List;
import java.util.Objects;

public class Client {

    public static void main(String... args) {
        Board board = new Board(100);
        board.addLadder(20, 40);
        board.addLadder(50, 10);

        Player player1 = new Player("Shrishail1");
        Player player2 = new Player("Shrishail2");

        SnakeLadderGameService snakeLadderGameService = new SnakeLadderGameService(board, 40, List.of(player1, player2));

        String name = snakeLadderGameService.startGame();

        if (Objects.equals(name, "Draw")) {
            System.out.println("Game is drawn");
        } else {
            System.out.println("winner is "+ name);
        }
    }
}
