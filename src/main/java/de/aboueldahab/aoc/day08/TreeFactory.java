package de.aboueldahab.aoc.day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;

public class TreeFactory {


    public List<Tree> createTrees(List<String> input) {
        Tree[][] treeArray = create2DTreeArray(input);
        savePossiblyBlockingTrees(treeArray);
        return convertToList(treeArray);
    }

    protected void savePossiblyBlockingTrees(Tree[][] treeArray) {
        int width = treeArray[0].length;
        int columns = 0;
        int rows = 0;
        for (Tree[] row : treeArray) {
            for (Tree tree : row) {
                // trees west
                List<Tree> treesWest = asList(copyOfRange(treeArray[rows], 0, columns));
                Collections.reverse(treesWest);
                tree.setTreesWest(treesWest);
                // trees east
                if (columns < width) {
                    tree.setTreesEast(asList(copyOfRange(treeArray[rows], columns + 1, width)));
                }
                //trees north
                tree.setTreesNorth(getTreesNorth(treeArray, rows, columns));
                //trees south
                tree.setTreesSouth(getTreesSouth(treeArray, rows, columns));
                columns++;
            }
            columns = 0;
            rows++;
        }
    }

    private List<Tree> getTreesNorth(Tree[][] trees, int row, int column) {
        List<Tree> treesNorth = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            treesNorth.add(trees[i][column]);
        }
        Collections.reverse(treesNorth);
        return treesNorth;
    }

    private List<Tree> getTreesSouth(Tree[][] trees, int row, int column) {
        List<Tree> treesSouth = new ArrayList<>();
        int height = trees.length;
        for (int i = row + 1; i < height; i++) {
            treesSouth.add(trees[i][column]);
        }
        return treesSouth;
    }

    private static List<Tree> convertToList(Tree[][] treeArray) {
        List<Tree> trees = new ArrayList<>();
        for (Tree[] row : treeArray) {
            Collections.addAll(trees, row);
        }
        return trees;
    }

    protected Tree[][] create2DTreeArray(List<String> input) {
        Tree[][] treeArray = new Tree[input.size()][input.get(0).length()];
        int columns = 0;
        int rows = 0;
        for (String row : input) {
            for (String column : row.split("")) {
                treeArray[columns][rows] = new Tree(Integer.parseInt(column));
                rows++;
            }
            rows = 0;
            columns++;
        }
        return treeArray;
    }
}
