package de.aboueldahab.aoc.day02.domain;

import static java.util.Objects.requireNonNull;

public class RockPaperScissors {

    public Result determineResult(HandShape shape, HandShape opponentShape) {
        requireNonNull(shape, "shape must not be null");
        requireNonNull(opponentShape, "opponentShape must not be null");

        if (shape.equals(opponentShape))
            return Result.DRAW;

        if (shape.equals(HandShape.ROCK)) {
            if (opponentShape.equals(HandShape.SCISSORS)) {
                return Result.WIN;
            }
            if (opponentShape.equals(HandShape.PAPER)) {
                return Result.LOSS;
            }
        }
        if (shape.equals(HandShape.PAPER)) {
            if (opponentShape.equals(HandShape.ROCK)) {
                return Result.WIN;
            }
            if (opponentShape.equals(HandShape.SCISSORS)) {
                return Result.LOSS;
            }
        }
        if (shape.equals(HandShape.SCISSORS)) {
            if (opponentShape.equals(HandShape.PAPER)) {
                return Result.WIN;
            }
            if (opponentShape.equals(HandShape.ROCK)) {
                return Result.LOSS;
            }
        }
        throw new IllegalStateException(String.format("The result of %s vs %s cannot be calculated.", shape, opponentShape));
    }

    public int getPoints(HandShape hand, Result result) {
        requireNonNull(hand, "hand must not be null");
        requireNonNull(result, "result must not be null");
        int points = 0;
        switch (hand) {
            case ROCK -> points += 1;
            case PAPER -> points += 2;
            case SCISSORS -> points += 3;
        }
        switch (result) {
            case LOSS -> points += 0;
            case DRAW -> points += 3;
            case WIN -> points += 6;
        }
        return points;
    }

}
