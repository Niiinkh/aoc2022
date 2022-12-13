package de.aboueldahab.aoc.day09;

import java.util.Objects;

public class Coordinates {

    private final int x;
    private final int y;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }

    public static Coordinates from(Coordinates coordinates, int deltaX, int deltaY) {
        return new Coordinates(coordinates.x + deltaX, coordinates.y + deltaY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates delta(Coordinates other) {
        return Coordinates.from(other, -x, -y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
