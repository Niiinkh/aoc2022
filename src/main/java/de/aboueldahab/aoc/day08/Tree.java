package de.aboueldahab.aoc.day08;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private final int height;
    private List<Tree> treesWest = new ArrayList<>();
    private List<Tree> treesEast = new ArrayList<>();
    private List<Tree> treesNorth = new ArrayList<>();
    private List<Tree> treesSouth = new ArrayList<>();

    public Tree(int height) {
        this.height = height;
    }

    public int height() {
        return height;
    }


    public List<Tree> treesWest() {
        return treesWest;
    }

    public void setTreesWest(List<Tree> treesWest) {
        this.treesWest = treesWest;
    }

    public void addTreeWest(Tree tree) {
        this.treesWest.add(tree);
    }

    public List<Tree> treesEast() {
        return treesEast;
    }

    public void setTreesEast(List<Tree> treesEast) {
        this.treesEast = treesEast;
    }

    public void addTreeEast(Tree tree) {
        this.treesEast.add(tree);
    }

    public List<Tree> treesNorth() {
        return treesNorth;
    }

    public void setTreesNorth(List<Tree> treesNorth) {
        this.treesNorth = treesNorth;
    }

    public void addTreeNorth(Tree tree) {
        this.treesNorth.add(tree);
    }

    public List<Tree> treesSouth() {
        return treesSouth;
    }

    public void setTreesSouth(List<Tree> treesSouth) {
        this.treesSouth = treesSouth;
    }

    public void addTreeSouth(Tree tree) {
        this.treesSouth.add(tree);
    }

    public boolean isVisible() {
        return isHigherThan(treesEast) || isHigherThan(treesWest)
                || isHigherThan(treesNorth) || isHigherThan(treesSouth);
    }

    private boolean isHigherThan(List<Tree> trees) {
        return trees.stream().noneMatch(otherTree -> otherTree.height >= this.height);
    }

    public int scenicScore() {
        return visibleTrees(treesEast) * visibleTrees(treesWest)
                * visibleTrees(treesSouth) * visibleTrees(treesNorth);
    }

    private int visibleTrees(List<Tree> trees) {
        int count = 0;
        for (Tree tree : trees) {
            count++;
            if (tree.height >= this.height) {
                break;
            }
        }
        return count;
    }
}
