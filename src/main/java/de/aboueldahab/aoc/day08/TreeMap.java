package de.aboueldahab.aoc.day08;

import java.util.List;

public class TreeMap {

    private final List<Tree> trees;

    public TreeMap(List<String> input) {
        trees = new TreeFactory().createTrees(input);
    }


}
