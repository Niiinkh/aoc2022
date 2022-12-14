package de.aboueldahab.aoc.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrtImageTest {

    private CrtImage image;

    @BeforeEach
    void setup() {
        image = new CrtImage();
    }

    @Test
    void newImageHasNoLines() {
        assertThat(image.displayLines()).isEmpty();
    }

    @Test
    void firstThirtyNinePixelsDontCreateALine() {
        image.drawPixel("xxxxxXXXXXxxxxxXXXXXxxxxxXXXXXxxxxx1234");
        assertThat(image.displayLines()).isEmpty();
    }

    @Test
    void fourtyPixelCreateALine() {
        image.drawPixel("xxxxxXXXXXxxxxxXXXXXxxxxxXXXXXxxxxx12345");
        assertThat(image.displayLines()).containsExactly("xxxxxXXXXXxxxxxXXXXXxxxxxXXXXXxxxxx12345");
    }

    @Test
    void multipleLinesArePossible() {
        image.drawPixel("xxxxxXXXXXxxxxxXXXXXxxxxxXXXXXxxxxx12345");
        image.drawPixel("xxxxxXXXXXxxxxxXXXXXxxxxxXXXXXxxxxx67890");
        assertThat(image.displayLines()).containsExactly(
                "xxxxxXXXXXxxxxxXXXXXxxxxxXXXXXxxxxx12345",
                "xxxxxXXXXXxxxxxXXXXXxxxxxXXXXXxxxxx67890");
    }

}