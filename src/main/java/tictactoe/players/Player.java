package main.java.tictactoe.players;

public class Player {
    private final String name;
    private final PlayingPiece playingPiece;

    public Player(PlayingPiece playingPiece, String name) {
        this.playingPiece = playingPiece;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }
}
