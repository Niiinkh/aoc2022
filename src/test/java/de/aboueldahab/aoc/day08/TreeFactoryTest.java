package de.aboueldahab.aoc.day08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TreeFactoryTest {

    private TreeFactory treeFactory;
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;
    private Tree tree4;

    @BeforeEach
    void setup() {
        treeFactory = new TreeFactory();

        this.tree1 = new Tree(1);
        this.tree2 = new Tree(2);
        this.tree3 = new Tree(3);
        this.tree4 = new Tree(4);
    }

    @Test
    void arrayHasCorrectDimensions() {
        List<String> input = Arrays.asList(
                "123",
                "454");
        Tree[][] treeArray = treeFactory.create2DTreeArray(input);
        assertThat(treeArray).hasDimensions(2, 3);
    }

    @Test
    void treesHaveCorrectHeight() {
        List<String> input = Arrays.asList(
                "123",
                "454");
        Tree[][] treeArray = treeFactory.create2DTreeArray(input);
        assertThat(treeArray[0][0].height()).isEqualTo(1);
        assertThat(treeArray[0][1].height()).isEqualTo(2);
        assertThat(treeArray[0][2].height()).isEqualTo(3);
        assertThat(treeArray[1][0].height()).isEqualTo(4);
        assertThat(treeArray[1][1].height()).isEqualTo(5);
        assertThat(treeArray[1][2].height()).isEqualTo(4);
    }

    @Test
    void treesToTheWestAreIdentified() {
        Tree[][] trees = new Tree[1][4];
        trees[0][0] = tree1;
        trees[0][1] = tree2;
        trees[0][2] = tree3;
        trees[0][3] = tree4;

        treeFactory.savePossiblyBlockingTrees(trees);

        assertThat(tree1.treesWest()).isEmpty();
        assertThat(tree2.treesWest()).containsExactly(tree1);
        assertThat(tree3.treesWest()).containsExactly(tree2, tree1);
        assertThat(tree4.treesWest()).containsExactly(tree3, tree2, tree1);
    }

    @Test
    void treesToTheEastAreIdentified() {
        Tree[][] trees = new Tree[1][4];
        trees[0][0] = tree1;
        trees[0][1] = tree2;
        trees[0][2] = tree3;
        trees[0][3] = tree4;

        treeFactory.savePossiblyBlockingTrees(trees);

        assertThat(tree1.treesEast()).containsExactly(tree2, tree3, tree4);
        assertThat(tree2.treesEast()).containsExactly(tree3, tree4);
        assertThat(tree3.treesEast()).containsExactly(tree4);
        assertThat(tree4.treesEast()).isEmpty();
    }

    @Test
    void treesToTheNorthAreIdentified() {
        Tree[][] trees = new Tree[4][1];
        trees[0][0] = tree1;
        trees[1][0] = tree2;
        trees[2][0] = tree3;
        trees[3][0] = tree4;

        treeFactory.savePossiblyBlockingTrees(trees);

        assertThat(tree1.treesNorth()).isEmpty();
        assertThat(tree2.treesNorth()).containsExactly(tree1);
        assertThat(tree3.treesNorth()).containsExactly(tree2, tree1);
        assertThat(tree4.treesNorth()).containsExactly(tree3, tree2, tree1);
    }

    @Test
    void treesToTheSouthAreIdentified() {
        Tree[][] trees = new Tree[4][1];
        trees[0][0] = tree1;
        trees[1][0] = tree2;
        trees[2][0] = tree3;
        trees[3][0] = tree4;

        treeFactory.savePossiblyBlockingTrees(trees);

        assertThat(tree1.treesSouth()).containsExactly(tree2, tree3, tree4);
        assertThat(tree2.treesSouth()).containsExactly(tree3, tree4);
        assertThat(tree3.treesSouth()).containsExactly(tree4);
        assertThat(tree4.treesSouth()).isEmpty();
    }

}