package de.aboueldahab.aoc.day01.domain;


import de.aboueldahab.aoc.day01.domain.Elf;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElfTest {

    @Test
    void foodCanBeAdded() {
        Elf elf = new Elf();
        elf.addFood(1000);
        assertThat(elf.getFood()).singleElement().isEqualTo(1000);
    }

    @Test
    void elfWithoutFoodCarriesZeroCalories() {
        Elf elf = new Elf();
        assertThat(elf.getCalories()).isEqualTo(0);
    }

    @Test
    void caloriesGetAddedUp() {
        Elf elf = new Elf();
        elf.addFood(2000);
        elf.addFood(3200);
        assertThat(elf.getCalories()).isEqualTo(5200);
    }

}