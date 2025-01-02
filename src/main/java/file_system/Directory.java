package main.java.file_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> fileSystemList;

    public Directory(String name) {
        this.name = name;
        this.fileSystemList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void rename(String newName) {
        this.name = newName;
    }

    @Override
    public void delete() {
        for (var component:fileSystemList) {
            component.delete();
        }

        fileSystemList.clear();

        System.out.println("Deleting the directory");
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Directory: " + name);
        for (var component : fileSystemList) {
            component.display(indent + "  ");
        }
    }

    @Override
    public void add(FileSystem component) throws UnsupportedOperationException {
        fileSystemList.add(component);
    }

    @Override
    public void remove(FileSystem component) throws UnsupportedOperationException {
        fileSystemList.remove(component);
    }

    @Override
    public List<FileSystem> getChildren() throws UnsupportedOperationException {
        return fileSystemList;
    }

    @Override
    public String read() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("cannot read from directory");
    }

    @Override
    public void write(String content) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("cannot write to directory");
    }

    @Override
    public FileSystem search(String name) {
        if (Objects.equals(this.name, name)) {
            return this;
        }

        for (var component:fileSystemList) {
            FileSystem result = component.search(name);
            if (Objects.nonNull(result)) {
                return result;
            }
        }

        return null;
    }

    @Override
    public void copyTo(FileSystem destination) {
        if (destination instanceof Directory) {
            Directory copy = new Directory(this.name);
            for (var components: fileSystemList) {
                components.copyTo(copy);
            }

            destination.add(copy);
        } else {
            throw new UnsupportedOperationException("Cannot copy directory to non-directory.");
        }
    }

    @Override
    public void moveTo(FileSystem destination) {
        this.copyTo(destination);
        this.delete();
    }
}
