package main.java.design_patterns.composite;


import java.util.ArrayList;
import java.util.List;

// This pattern helps in scenarios where we have object inside object(tree like structure)
// Ex: File System
public class Composite {

    public static void main(String[] args) {
        Directory parentDirectory  = new Directory();
        FileSystem file1 = new File();
        parentDirectory.add(file1);

        Directory childDirectory = new Directory();
        FileSystem file2 = new File();
        childDirectory.add(file2);

        parentDirectory.add(childDirectory);

        parentDirectory.ls();
    }
}

interface FileSystem {
    void ls();
}

class File implements  FileSystem {

    public void ls() {
        System.out.println("file1.txt");
    }
}

class Directory implements  FileSystem {
    List<FileSystem> fileSystemList;

    public Directory() {
        this.fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    public void ls() {
       fileSystemList.forEach(FileSystem::ls);
    }
}
