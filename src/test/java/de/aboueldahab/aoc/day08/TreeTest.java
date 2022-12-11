package de.aboueldahab.aoc.day08;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeTest {

    @Test
    void completelyHiddenByEquallyTallTrees() {
        Tree tree = new Tree(2);

        tree.addTreeEast(new Tree(2));
        tree.addTreeWest(new Tree(2));
        tree.addTreeNorth(new Tree(2));
        tree.addTreeSouth(new Tree(2));

        assertThat(tree.isVisible()).isFalse();
    }

    @Test
    void completelyHiddenByTallerTrees() {
        Tree tree = new Tree(2);

        tree.addTreeEast(new Tree(3));
        tree.addTreeWest(new Tree(4));
        tree.addTreeNorth(new Tree(5));
        tree.addTreeSouth(new Tree(6));

        assertThat(tree.isVisible()).isFalse();
    }

    @Test
    void visibleInEachDirection() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(4));
        tree.addTreeWest(new Tree(4));
        tree.addTreeNorth(new Tree(4));
        tree.addTreeSouth(new Tree(4));

        assertThat(tree.isVisible()).isTrue();
    }


    @Test
    void hiddenButThereAreAlsoSmallerTrees() {
        Tree tree = new Tree(2);

        tree.addTreeEast(new Tree(3));
        tree.addTreeEast(new Tree(1));
        tree.addTreeWest(new Tree(4));
        tree.addTreeNorth(new Tree(5));
        tree.addTreeSouth(new Tree(6));

        assertThat(tree.isVisible()).isFalse();
    }

    @Test
    void visibleBecauseOfNoSurroundingTrees() {
        assertThat(new Tree(2).isVisible()).isTrue();
    }

    @Test
    void visibleToTheEast() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(1));
        tree.addTreeWest(new Tree(9));
        tree.addTreeNorth(new Tree(9));
        tree.addTreeSouth(new Tree(9));

        assertThat(tree.isVisible()).isTrue();
    }

    @Test
    void visibleToTheWest() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(9));
        tree.addTreeWest(new Tree(1));
        tree.addTreeNorth(new Tree(9));
        tree.addTreeSouth(new Tree(9));

        assertThat(tree.isVisible()).isTrue();
    }

    @Test
    void visibleToTheNorth() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(9));
        tree.addTreeWest(new Tree(9));
        tree.addTreeNorth(new Tree(1));
        tree.addTreeSouth(new Tree(9));

        assertThat(tree.isVisible()).isTrue();
    }

    @Test
    void visibleToTheSouth() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(9));
        tree.addTreeWest(new Tree(9));
        tree.addTreeNorth(new Tree(9));
        tree.addTreeSouth(new Tree(1));

        assertThat(tree.isVisible()).isTrue();
    }

    @Test
    void scenicScoreIsZeroIfNoTreesToOneSide() {
        Tree tree = new Tree(5);

        tree.addTreeWest(new Tree(1));
        tree.addTreeNorth(new Tree(1));
        tree.addTreeSouth(new Tree(1));

        assertThat(tree.scenicScore()).isEqualTo(0);
    }


    @Test
    void scenicScoreIsFourToTheEast() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(1));
        tree.addTreeEast(new Tree(1));
        tree.addTreeEast(new Tree(1));
        tree.addTreeEast(new Tree(1));

        tree.addTreeWest(new Tree(1));
        tree.addTreeNorth(new Tree(1));
        tree.addTreeSouth(new Tree(1));

        assertThat(tree.scenicScore()).isEqualTo(4);
    }

    @Test
    void scenicScoreForEachDirectionIsMultiplied() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(1));
        tree.addTreeEast(new Tree(1));

        tree.addTreeWest(new Tree(1));
        tree.addTreeWest(new Tree(1));

        tree.addTreeNorth(new Tree(1));
        tree.addTreeNorth(new Tree(1));

        tree.addTreeSouth(new Tree(1));

        assertThat(tree.scenicScore()).isEqualTo(8);
    }

    @Test
    void scenicScoreIsCutOffByTallTreesToEachSide() {
        Tree tree = new Tree(5);

        tree.addTreeEast(new Tree(9));
        tree.addTreeEast(new Tree(1));

        tree.addTreeWest(new Tree(9));
        tree.addTreeWest(new Tree(1));

        tree.addTreeNorth(new Tree(1));

        tree.addTreeSouth(new Tree(5));
        tree.addTreeSouth(new Tree(1));

        assertThat(tree.scenicScore()).isEqualTo(1);
    }

}