package main.java.file_system;

import java.util.List;
import java.util.Objects;

public class File implements FileSystem {
    private String name;
    private String contents;

    public File(String name) {
        this.name = name;
        this.contents = "";
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void rename(String newName) {
        this.name = newName;
    }

    @Override
    public void delete() {
        // Code to delete the file from the file system
        System.out.println("Deleting file: " + name);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name);
    }

    @Override
    public void add(FileSystem component) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot add to a file.");
    }

    @Override
    public void remove(FileSystem component) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot remove from a file.");
    }

    @Override
    public List<FileSystem> getChildren() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("File does not have children.");
    }

    @Override
    public String read() throws UnsupportedOperationException {
        return contents;
    }

    @Override
    public void write(String content) throws UnsupportedOperationException {
        this.contents = content;
    }

    @Override
    public FileSystem search(String name) {
        return Objects.equals(this.name, name) ? this:null;
    }

    @Override
    public void copyTo(FileSystem destination) {
        File copy = new File(this.name);
        copy.write(this.contents);
        destination.add(copy);
    }

    @Override
    public void moveTo(FileSystem destination) {
        this.copyTo(destination);
        this.delete();
    }
}
