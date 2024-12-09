package main.java.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Integer data;
    List<Node> nodes;

    public Node(Integer data) {
        this.data = data;
        this.nodes = new ArrayList<>();
    }
}
