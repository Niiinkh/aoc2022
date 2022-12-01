package de.aboueldahab.aoc.day01.adapter;

import de.aboueldahab.aoc.day01.domain.Elf;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ElfInputConverter {
    public List<Elf> convert(List<String> input) {
        ArrayList<Elf> elves = new ArrayList<>();
        Elf currentElf = new Elf();
        for (String line : input) {
            if (isNewElf(line)) {
                addToList(elves, currentElf);
                currentElf = new Elf();
            } else {
                addFoodToCurrentElf(currentElf, line);
            }
        }
        addToList(elves, currentElf);
        return elves;
    }

    private static boolean isNewElf(String line) {
        return StringUtils.isAllBlank(line);
    }

    private static void addToList(ArrayList<Elf> elves, Elf currentElf) {
        if (!currentElf.getFood().isEmpty()) {
            elves.add(currentElf);
        }
    }

    private static void addFoodToCurrentElf(Elf currentElf, String line) {
        currentElf.addFood(Integer.parseInt(line));
    }
}
