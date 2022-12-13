package de.aboueldahab.aoc.day09;

public class TailMovement {

    private final Tail tail;
    private Coordinates headCoordinates;

    public TailMovement(Tail tail) {
        this.tail = tail;
        headCoordinates = tail.currentCoordinates();
    }

    public Coordinates headCoordinates() {
        return headCoordinates;
    }

    public Coordinates tailCoordinates() {
        return tail.currentCoordinates();
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
    }

}
