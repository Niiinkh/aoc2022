package de.aboueldahab.aoc.day01.adapter;

import de.aboueldahab.aoc.day01.domain.Elf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ElfInputConverterTest {

    private ElfInputConverter inputConverter;

    @BeforeEach
    void setup() {
        inputConverter = new ElfInputConverter();
    }

    @Test
    void emptyInput() {
        assertThat(inputConverter.convert(Collections.emptyList())).isEmpty();
    }

    @Test
    void oneElf() {
        List<String> input = Arrays.asList("100", "500");
        List<Elf> elves = inputConverter.convert(input);
        assertThat(elves).hasSize(1);
        assertThat(elves.get(0).getFood()).containsExactly(100, 500);
    }

    @Test
    void twoElves() {
        List<String> input = Arrays.asList("100", "500", "", "20", "");
        List<Elf> elves = inputConverter.convert(input);
        assertThat(elves).hasSize(2);
        assertThat(elves.get(0).getFood()).containsExactly(100, 500);
        assertThat(elves.get(1).getFood()).containsExactly(20);
    }

    @Test
    void exampleInput() {
        List<String> input = Arrays.asList(
                "1000", "2000", "3000",
                "", "4000",
                "", "5000", "6000",
                "", "7000", "8000", "9000",
                "", "10000");
        assertThat(inputConverter.convert(input)).hasSize(5);
    }

}