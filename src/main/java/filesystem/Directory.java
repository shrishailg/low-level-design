package main.java.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    List<FileSystem> fileSystemList;

    public Directory() {
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }


    @Override
    public List<FileSystem> ls() {
        return fileSystemList;
    }

    @Override
    public void cd() {

    }

    @Override
    public boolean mkdir(String directoryName) {
        return false;
    }

    public String pwd() {
        return "";
    }
}
