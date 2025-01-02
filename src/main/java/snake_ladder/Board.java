package main.java.snake_ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final Integer winningPosition;
   private final int size;
   private Map<Integer, Integer> snakes;
   private Map<Integer, Integer> ladders;
   private List<Integer> playingBoard;

   public Board(int size) {
       this.size = size;
       snakes = new HashMap<>();
       ladders = new HashMap<>();
       playingBoard = new ArrayList<>(size);
       this.winningPosition = size-1;
   }

   public void addSnake(int head, int tail) {
       if (head == winningPosition) {
           throw new RuntimeException("snake head should not be at the winning position");
       }

       snakes.put(head, tail);
   }

    public void addLadder(int head, int tail) {
        snakes.put(tail, head);
    }

    public Integer getWinningPosition() {
        return winningPosition;
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public List<Integer> getPlayingBoard() {
        return playingBoard;
    }

    public void setPlayingBoard(List<Integer> playingBoard) {
        this.playingBoard = playingBoard;
    }
}
