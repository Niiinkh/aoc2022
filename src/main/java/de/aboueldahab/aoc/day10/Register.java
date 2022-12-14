package de.aboueldahab.aoc.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Register {

    private int spritePosition = 1;
    private int cycle = 0;

    private int signalStrength;

    private final CrtImage image = new CrtImage();

    private final List<Integer> criticalCycles = new ArrayList<>(Arrays.asList(20, 60, 100, 140, 180, 220));

    public int value() {
        return spritePosition;
    }

    public int cycle() {
        return cycle;
    }

    public void addValue(int value) {
        this.spritePosition += value;
    }

    public void execute(Operation operation) {
        for (int i = 0; i < operation.duration(); i++) {
            drawSprite();
            cycle++;
            adjustSignalStrengthIfNeccessary();
        }
        operation.execute(this);
    }

    private void drawSprite() {
        if (isSpriteVisible()) {
            image.drawPixel("#");
        } else {
            image.drawPixel(".");
        }
    }

    private boolean isSpriteVisible() {
        int currentPixel = cycle % 40;
        return spritePosition - 1 <= currentPixel && spritePosition + 1 >= currentPixel;
    }

    private void adjustSignalStrengthIfNeccessary() {
        if (!criticalCycles.isEmpty() && cycle > criticalCycles.get(0) - 1) {
            signalStrength += criticalCycles.remove(0) * spritePosition;
        }
    }

    public int signalStrength() {
        return signalStrength;
    }

    public CrtImage image() {
        return image;
    }

}
