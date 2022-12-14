package de.aboueldahab.aoc.day09;

import java.util.HashSet;
import java.util.Set;

public class Knot {

    private final Set<Coordinates> visitedCoordinates = new HashSet<>();
    private Knot followingKnot;
    private Coordinates coordinates;
    private TailMovement tailMovement;

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

    public void setFollowingKnot(Knot tail) {
        this.followingKnot = tail;
        tailMovement = new TailMovement(this, tail);
        followingKnot.setCoordinates(coordinates);
    }

    public void moveUp() {
        move(0, 1);
    }

    public void moveDown() {
        move(0, -1);
    }

    public void moveRight() {
        move(1, 0);
    }

    public void moveLeft() {
        move(-1, 0);
    }

    private void move(int deltaX, int deltaY) {
        setCoordinates(Coordinates.from(currentCoordinates(), deltaX, deltaY));
        if (followingKnot != null) {
            tailMovement.tailFollowsHead();
        }
    }
}
