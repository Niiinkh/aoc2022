package de.aboueldahab.aoc.day10;

import java.util.ArrayList;
import java.util.List;

public class CrtImage {

    private final List<String> displayLines = new ArrayList<>();
    private String currentLine = "";

    public void drawPixel(String pixel) {
        currentLine += pixel;
        if (currentLine.length() >= 40) {
            displayLines.add(currentLine);
            currentLine = "";
        }
    }

    public List<String> displayLines() {
        return displayLines;
    }

    public void print() {
        displayLines.forEach(System.out::println);
    }

}
