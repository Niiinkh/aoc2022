package de.aboueldahab.aoc.day02.adapter;

import de.aboueldahab.aoc.day02.domain.GameRound;
import de.aboueldahab.aoc.day02.domain.HandShape;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RockPaperScissorParser {
    public List<GameRound> convertPart1(List<String> input) {
        return input.stream().map(this::convertGameRoundPart1).collect(Collectors.toList());
    }

    public List<GameRound> convertPart2(List<String> input) {
        return input.stream().map(this::convertGameRoundPart2).collect(Collectors.toList());
    }


    protected GameRound convertGameRoundPart1(String string) {
        String[] hands = string.split(" ");
        HandShape opponentHand = mapShape(hands[0]);
        HandShape myHand = mapShape(hands[1]);
        return new GameRound(myHand, opponentHand);
    }

    protected GameRound convertGameRoundPart2(String string) {
        String[] hands = string.split(" ");
        HandShape opponentHand = mapShape(hands[0]);
        HandShape myHand = mapPart2(opponentHand, hands[1]);
        return new GameRound(myHand, opponentHand);
    }

    private HandShape mapShape(String hand) {
        if (StringUtils.equalsAny(hand, "A", "X")) {
            return HandShape.ROCK;
        }
        if (StringUtils.equalsAny(hand, "B", "Y")) {
            return HandShape.PAPER;
        }
        if (StringUtils.equalsAny(hand, "C", "Z")) {
            return HandShape.SCISSORS;
        }
        throw new IllegalArgumentException(String.format("Letter %s cannot be parsed to a hand", hand));
    }

    private HandShape mapPart2(HandShape opponentHand, String hand) {
        if (StringUtils.equals(hand, "X")) {
            // we try to loose
            switch (opponentHand) {
                case ROCK:
                    return HandShape.SCISSORS;
                case PAPER:
                    return HandShape.ROCK;
                case SCISSORS:
                    return HandShape.PAPER;
            }
        }
        if (StringUtils.equals(hand, "Y")) {
            return opponentHand;
        }
        if (StringUtils.equals(hand, "Z")) {
            switch (opponentHand) {
                case ROCK:
                    return HandShape.PAPER;
                case PAPER:
                    return HandShape.SCISSORS;
                case SCISSORS:
                    return HandShape.ROCK;
            }
        }
        throw new IllegalArgumentException(String.format("Letter %s cannot be parsed to a command", hand));
    }
}
