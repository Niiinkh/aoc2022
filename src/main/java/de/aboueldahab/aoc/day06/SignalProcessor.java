package de.aboueldahab.aoc.day06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SignalProcessor {

    public int startOfPacketMarker(String signal) {
        return determineEndOfSequenceContainingUniqueCharacters(signal, 4);
    }


    public int startOfMessageMarker(String signal) {
        return determineEndOfSequenceContainingUniqueCharacters(signal, 14);
    }

    private static int determineEndOfSequenceContainingUniqueCharacters(String signal, int n) {
        List<Character> lastCharacters = new ArrayList<>();
        for (int i = 0; i < signal.length(); i++) {
            lastCharacters.add(signal.charAt(i));
            if (lastCharacters.size() > n) {
                lastCharacters.remove(0);
            }
            if (new HashSet<>(lastCharacters).size() == n) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException("No start marker found");
    }

}
