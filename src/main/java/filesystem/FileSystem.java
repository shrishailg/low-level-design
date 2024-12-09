package main.java.filesystem;

import java.util.List;

public interface FileSystem {
    List<FileSystem> ls();
    void cd();
    boolean mkdir(String directoryName);
    String pwd();
}
