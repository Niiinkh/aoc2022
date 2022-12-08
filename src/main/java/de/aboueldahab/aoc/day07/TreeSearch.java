package de.aboueldahab.aoc.day07;

import java.util.ArrayList;
import java.util.List;

public class TreeSearch {

    public List<Directory> depthFirstDirectories(Directory directory) {
        List<Directory> directories = new ArrayList<>();
        addAllDirectories(directory, directories);
        return directories;
    }

    private void addAllDirectories(Directory directory, List<Directory> allDirectories) {
        if (directory == null) {
            return;
        }
        allDirectories.add(directory);
        for (Directory subdirectory : directory.subdirectories()) {
            addAllDirectories(subdirectory, allDirectories);
        }
    }

}
