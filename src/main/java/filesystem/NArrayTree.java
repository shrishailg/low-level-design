package main.java.filesystem;

public class NArrayTree {

    void insert(Node node, Integer data) {
        Node childNode = new Node(data);

        node.nodes.add(childNode);
    }
}
