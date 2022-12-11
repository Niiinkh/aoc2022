package de.aboueldahab.aoc.day08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TreeFactoryTest {

    private TreeFactory treeFactory;

    @BeforeEach
    void setup() {
        treeFactory = new TreeFactory();
    }

    @Test
    void arrayHasCorrectDimensions() {
        Tree[][] treeArray = treeFactory.create2DTreeArray(Arrays.asList(
                "123",
                "454"));
        assertThat(treeArray).hasDimensions(2, 3);
    }

    @Test
    void treesHaveCorrectHeight() {
        Tree[][] treeArray = treeFactory.create2DTreeArray(Arrays.asList(
                "123",
                "454"));
        assertThat(treeArray[0][0].height()).isEqualTo(1);
        assertThat(treeArray[0][1].height()).isEqualTo(2);
        assertThat(treeArray[0][2].height()).isEqualTo(3);
        assertThat(treeArray[1][0].height()).isEqualTo(4);
        assertThat(treeArray[1][1].height()).isEqualTo(5);
        assertThat(treeArray[1][2].height()).isEqualTo(4);
    }

}