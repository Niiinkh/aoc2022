package de.aboueldahab.aoc.day07;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private List<Directory> subdirectories = new ArrayList<>();
    private Directory parent = null;

    private final String path;
    private final List<AocFile> files = new ArrayList<>();

    public Directory(String path) {
        this.path = path;
    }

    public void addFile(AocFile file) {
        files.add(file);
    }

    public List<AocFile> files() {
        return new ArrayList<>(files);
    }

    public Directory parent() {
        return parent;
    }

    public void setParent(Directory directory) {
        parent = directory;
        if (!parent.subdirectories.contains(this)) {
            parent.subdirectories.add(this);
        }
    }

    public List<Directory> subdirectories() {
        return new ArrayList<>(subdirectories);
    }

    public void addSubdirectory(Directory directory) {
        if (!subdirectories.contains(directory)) {
            subdirectories.add(directory);
        }
        directory.setParent(this);
    }

    public String path() {
        return path;
    }

    public long filesize() {
        return files.stream().map(AocFile::size).reduce(Long::sum).orElse(0L);
    }

    public long size() {
        return 0L;
    }

}
