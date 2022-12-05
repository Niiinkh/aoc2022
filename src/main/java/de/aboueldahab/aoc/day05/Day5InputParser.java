package de.aboueldahab.aoc.day05;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day5InputParser {

    private List<String> input;

    public Day5InputParser(List<String> input) {
        this.input = input;
    }

    public List<String> getCraneInstructions() {
        return input.stream()
                .filter(s -> s.startsWith("move"))
                .collect(Collectors.toList());
    }

    public CargoShip createInitialCargoShip() {
        List<Integer> keys = determineKeys();
        HashMap<Integer, CrateStack> stacks = createEmptyStacks(keys);
        for (int i = getKeyIndex() - 1; i >= 0; i--) {
            addToStack(stacks, input.get(i), keys);
        }
        return new CargoShip(stacks);
    }

    private static HashMap<Integer, CrateStack> createEmptyStacks(List<Integer> keys) {
        HashMap<Integer, CrateStack> stacks = new HashMap<>();
        keys.forEach(key -> stacks.put(key, new CrateStack()));
        return stacks;
    }

    private void addToStack(HashMap<Integer, CrateStack> stacks, String inputLine, List<Integer> keys) {
        for (int i = 0; i < keys.size(); i++) {
            char crate = inputLine.charAt(i * 4 + 1);
            if (crate != ' ') {
                Integer key = keys.get(i);
                CrateStack stack = stacks.get(key);
                stack.push(Character.toString(crate));
            }
        }
    }

    List<Integer> determineKeys() {
        return Arrays.stream(input.get(getKeyIndex()).split(" "))
                .filter(StringUtils::isNotBlank)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getKeyIndex() {
        for (int i = 0; i < input.size(); i++) {
            if (StringUtils.isNumeric(StringUtils.deleteWhitespace(input.get(i)))) {
                return i;
            }
        }
        throw new IllegalArgumentException("Keys could not be found");
    }


}
