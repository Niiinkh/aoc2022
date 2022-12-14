package de.aboueldahab.aoc.day09;

import java.util.HashSet;
import java.util.Set;

public class Knot {

    private final Set<Coordinates> visitedCoordinates = new HashSet<>();
    private Coordinates coordinates;

    public Coordinates currentCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        visitedCoordinates.add(coordinates);
        this.coordinates = coordinates;
    }

    public Set<Coordinates> visitedCoordinates() {
        return new HashSet<>(visitedCoordinates);
    }
}
