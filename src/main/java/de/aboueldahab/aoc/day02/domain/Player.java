package de.aboueldahab.aoc.day02.domain;

public class Player {

    private HandShape shape;

    public Result playAgainst(Player opponent) {
        if (shape == null || opponent.shape == null) {
            throw new IllegalStateException("Both Players must be assigned a shape");
        }
        if (shape.equals(opponent.shape))
            return Result.DRAW;

        if (shape.equals(HandShape.ROCK)) {
            if (opponent.shape.equals(HandShape.SCISSORS)) {
                return Result.WIN;
            }
            if (opponent.shape.equals(HandShape.PAPER)) {
                return Result.LOSS;
            }
        }
        if (shape.equals(HandShape.PAPER)) {
            if (opponent.shape.equals(HandShape.ROCK)) {
                return Result.WIN;
            }
            if (opponent.shape.equals(HandShape.SCISSORS)) {
                return Result.LOSS;
            }
        }
        if (shape.equals(HandShape.SCISSORS)) {
            if (opponent.shape.equals(HandShape.PAPER)) {
                return Result.WIN;
            }
            if (opponent.shape.equals(HandShape.ROCK)) {
                return Result.LOSS;
            }
        }
        throw new IllegalStateException(String.format("The result of %s vs %s cannot be calculated.", shape, opponent.shape));
    }

    public HandShape getShape() {
        return shape;
    }

    public void setShape(HandShape shape) {
        this.shape = shape;
    }
}
