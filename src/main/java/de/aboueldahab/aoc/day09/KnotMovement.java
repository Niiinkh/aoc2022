package de.aboueldahab.aoc.day09;

public class KnotMovement {

    private final Knot knot;
    private Coordinates headCoordinates;

    public KnotMovement(Knot knot) {
        this.knot = knot;
        headCoordinates = knot.currentCoordinates();
    }

    public Coordinates headCoordinates() {
        return headCoordinates;
    }

    public Coordinates tailCoordinates() {
        return knot.currentCoordinates();
    }

    public void moveHeadUp() {
        moveHead(0, 1);
    }

    public void moveHeadDown() {
        moveHead(0, -1);
    }

    public void moveHeadRight() {
        moveHead(1, 0);
    }

    public void moveHeadLeft() {
        moveHead(-1, 0);
    }

    private void moveHead(int deltaX, int deltaY) {
        headCoordinates = Coordinates.from(headCoordinates, deltaX, deltaY);
        if (distance() >= 2) {
            tailFollowsHead();
        }
    }

    private void tailFollowsHead() {
        Coordinates delta = tailCoordinates().delta(headCoordinates);
        int yDelta = 0;
        int xDelta = 0;
        if (delta.getX() == 0) {
            yDelta = delta.getY();
        } else if (delta.getY() == 0) {
            xDelta = delta.getX();
        } else {
            xDelta = delta.getX();
            yDelta = delta.getY();
        }
        xDelta = limitToOne(xDelta);
        yDelta = limitToOne(yDelta);
        Coordinates newCoordinates = Coordinates.from(tailCoordinates(), xDelta, yDelta);
        knot.setCoordinates(newCoordinates);
    }

    private int limitToOne(int number) {
        if (Math.abs(number) > 1) {
            return number / Math.abs(number);
        }
        return number;
    }

    private double distance() {
        return Math.abs(headCoordinates.distance(tailCoordinates()));
    }

    public Knot tail() {
        return knot;
    }
}
