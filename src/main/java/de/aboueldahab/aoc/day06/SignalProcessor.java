package de.aboueldahab.aoc.day06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SignalProcessor {

    public int startOfPacketMarker(String signal) {
        List<Character> lastCharacters = new ArrayList<>();
        for (int i = 0; i < signal.length(); i++) {
            lastCharacters.add(signal.charAt(i));
            if (lastCharacters.size() > 4) {
                lastCharacters.remove(0);
            }
            if (fourUniqueCharcters(lastCharacters)) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException("No start of packet marker found");
    }

    private boolean fourUniqueCharcters(List<Character> lastFourChars) {
        return new HashSet<>(lastFourChars).size() == 4;
    }

}
