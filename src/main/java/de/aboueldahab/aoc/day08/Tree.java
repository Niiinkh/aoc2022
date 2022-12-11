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

    public List<Tree> treesEast() {
        return treesEast;
    }

    public void setTreesEast(List<Tree> treesEast) {
        this.treesEast = treesEast;
    }

    public List<Tree> treesNorth() {
        return treesNorth;
    }

    public void setTreesNorth(List<Tree> treesNorth) {
        this.treesNorth = treesNorth;
    }

    public List<Tree> treesSouth() {
        return treesSouth;
    }

    public void setTreesSouth(List<Tree> treesSouth) {
        this.treesSouth = treesSouth;
    }
}
