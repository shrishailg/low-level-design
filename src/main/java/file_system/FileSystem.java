package main.java.file_system;

import java.util.List;

public interface FileSystem {
    String getName();
    void rename(String newName);
    void delete();
    void display(String indent);
    void add(FileSystem component) throws UnsupportedOperationException;
    void remove(FileSystem component) throws UnsupportedOperationException;
    List<FileSystem> getChildren() throws UnsupportedOperationException;
    String read() throws UnsupportedOperationException;
    void write(String content) throws UnsupportedOperationException;
    FileSystem search(String name);
    void copyTo(FileSystem destination);
    void moveTo(FileSystem destination);
}
