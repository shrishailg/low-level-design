package main.java.snake_ladder;

import java.util.*;

public class SnakeLadderGameService {
    private Board board;
    private Deque<Player> players;
    private final int diceSize;

    public SnakeLadderGameService(Board board, int diceSize, List<Player> players) {
        this.board = board;
        this.players = new LinkedList<>();
        this.players.addAll(players);
        this.diceSize = diceSize;
    }

    public String startGame() {
        boolean noPlayerWon = true;
        int index = 100000000;
        //1000 times only:
        while (index>0) {
            Player playerTurn = players.removeFirst();

//            System.out.println("Enter the dice value");
//            Scanner scanner = new Scanner(System.in);
//            int input = scanner.nextInt(); //assume that input always will be int

//            int playerNextPosition = input + playerTurn.getPosition();


            int playerNextPosition = rollDice();


            if (playerNextPosition == board.getWinningPosition()) {
                return playerTurn.getName();
            }

            if (playerNextPosition >= board.getSize()) {
                System.out.println("player position is exceeding the board size");
                players.addLast(playerTurn);
                index--;
                continue;
            }

            if (board.getSnakes().containsKey(playerNextPosition)) {
                System.out.println("Player " + playerTurn.getName() +" has bit by snake");
                playerTurn.setPosition(board.getSnakes().get(playerNextPosition));
                players.addLast(playerTurn);
                index--;
                continue;
            }

            if (board.getLadders().containsKey(playerNextPosition)) {
                System.out.println("Player " + playerTurn.getName() +" has bit by snake");
                playerTurn.setPosition(board.getLadders().get(playerNextPosition));

                if (playerTurn.getPosition() == board.getWinningPosition()) {
                    return playerTurn.getName();
                }
            }

            index--;
            playerTurn.setPosition(playerTurn.getPosition() + playerNextPosition);
            players.addLast(playerTurn);
        }

        return "Drawn";
    }

    private int rollDice() {
        Random random = new Random();

        return random.nextInt(diceSize+1);
    }



}
