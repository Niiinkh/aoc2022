package de.aboueldahab.aoc.day09;

public class TailMovement {

    private final Knot head;
    private final Knot tail;

    public TailMovement(Knot head, Knot tail) {
        this.head = head;
        this.tail = tail;
    }


    public void tailFollowsHead() {
        if (distance() < 2) {
            return;
        }
        Coordinates delta = tail.currentCoordinates().delta(head.currentCoordinates());
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
        Coordinates newCoordinates = Coordinates.from(tail.currentCoordinates(), xDelta, yDelta);
        tail.setCoordinates(newCoordinates);
    }

    private int limitToOne(int number) {
        if (Math.abs(number) > 1) {
            return number / Math.abs(number);
        }
        return number;
    }

    private double distance() {
        return Math.abs(head.currentCoordinates().distance(tail.currentCoordinates()));
    }

}
