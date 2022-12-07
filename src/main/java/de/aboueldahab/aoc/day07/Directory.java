package de.aboueldahab.aoc.day07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Directory {

    private Set<Directory> subdirectories = new HashSet<>();
    private Directory parent = null;

    private final String name;
    private final List<AocFile> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
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
        parent.subdirectories.add(this);
    }

    public Set<Directory> subdirectories() {
        return new HashSet<>(subdirectories);
    }

    public void addSubdirectory(Directory directory) {
        subdirectories.add(directory);
        directory.setParent(this);
    }
}
