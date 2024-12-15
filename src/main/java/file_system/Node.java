package main.java.file_system;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    String data;
    boolean isFile;
    List<Node> childNodes;

    public Node(String name, String data, boolean isFile) {
        this.name = name;
        this.data = data;
        this.isFile = isFile;
        this.childNodes = new ArrayList<>();
    }
}
