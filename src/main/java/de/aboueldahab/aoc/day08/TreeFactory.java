package de.aboueldahab.aoc.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeFactory {

    public List<Tree> createTrees(List<String> input) {
        List<Tree> trees = new ArrayList<>();
        Tree[][] treeArray = create2DTreeArray(input);
        for (Tree[] row : treeArray) {
            trees.addAll(Arrays.asList(row));
        }
        return trees;
    }

    protected static Tree[][] create2DTreeArray(List<String> input) {
        Tree[][] treeArray = new Tree[input.size()][input.get(0).length()];
        int columns = 0;
        int rows = 0;
        for (String row : input) {
            for (String column : row.split("")) {
                treeArray[rows][columns] = new Tree(Integer.parseInt(column));
                columns++;
            }
            columns = 0;
            rows++;
        }
        return treeArray;
    }
}
