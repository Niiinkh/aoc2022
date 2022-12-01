package de.aboueldahab.aoc.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AocFileReaderTest {

    private AocFileReader fileReader;

    @BeforeEach
    void setup() {
        fileReader = new AocFileReader();
    }

    @Test
    void emptyListThrowsNoException() {
        List<String> inputLines = new ArrayList<>();
        assertThat(fileReader.removeLastLineIfEmpty(inputLines)).isEmpty();
    }

    @Test
    void emptyLastLineGetsRemoved() {
        List<String> inputLines = Arrays.asList("abcde", "");
        assertThat(fileReader.removeLastLineIfEmpty(inputLines)).containsExactly("abcde");
    }

    @Test
    void lastLineDoesntGetRemovedIfContainsInput() {
        List<String> inputLines = Arrays.asList("abcde", "xyz");
        assertThat(fileReader.removeLastLineIfEmpty(inputLines)).containsExactly("abcde", "xyz");
    }

}