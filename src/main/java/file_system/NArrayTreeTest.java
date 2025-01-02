package main.java.file_system;

public class NArrayTreeTest {

    public static void main(String... args) {
        NArrayTree nArrayTree = new NArrayTree();

        nArrayTree.createDirectory("Users", "");
        nArrayTree.createDirectory("Shrishail", "Users");
        nArrayTree.createDirectory("practice", "Users/Shrishail");

        nArrayTree.createFile("gotilla", "Users/Shrishail/practice", "Hello folks");

        String content = nArrayTree.cat("gotilla", "Users/Shrishail/practice");

        System.out.println(content);
    }
}
