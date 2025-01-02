package main.java.file_system;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class NArrayTree {
    Node root;

    public NArrayTree() {
        root = null;
    }

    private Node traverseDirectory(String[] paths) {
        Node current = root;

        int i = 1;

        while (i < paths.length) {
            String path = paths[i];
            boolean pathFound = false;

            for (var node : current.childNodes) {
                if (Objects.equals(node.name, path)) {
                    pathFound = true;
                    current = node;
                    break;
                }
            }

            if (!pathFound) {
                break;
            }

            i++;
        }

        return current;
    }

    public Node createDirectory(String directoryName, String directories) {
        String[] paths = directories.split("/");

        if (root == null || paths.length == 0) {
            root = new Node(directoryName, "", false);
            return root;
        }

        Node current = traverseDirectory(paths);

        Node newDirectory = new Node(directoryName, "", false);

        current.childNodes.add(newDirectory);

        return newDirectory;
    }

    public Node createFile(String fileName, String directories, String content) {
        String[] paths = directories.split("/");

        if (root == null || paths.length == 0) {
            root = new Node(fileName, content, true);
            return root;
        }

        Node current = traverseDirectory(paths);

        Node newFile = new Node(fileName, content, true);

        current.childNodes.add(newFile);

        return newFile;
    }

    public List<String> ls(String directoryPaths) {
        String[] paths = directoryPaths.split("/");

        Node current = traverseDirectory(paths);

        return current.childNodes.stream().map(node -> node.name).collect(Collectors.toList());
    }

    public String cat(String fileName, String directoryPaths) {
        String[] paths = directoryPaths.split("/");

        Node current = traverseDirectory(paths);

        Optional<Node> file = current.childNodes.stream().filter(node -> Objects.equals(node.name, fileName)).findFirst();

        if (file.isEmpty()) {
            throw new RuntimeException("not present file");
        }

        return file.get().data;
    }
}
