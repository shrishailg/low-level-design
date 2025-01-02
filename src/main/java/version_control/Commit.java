package main.java.version_control;

public class Commit {
    private final String id;
    private final String message;

    public Commit(String id, String message) {
        this.id = id;
        this.message = message;
    }


    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}