package de.aboueldahab.aoc.day02.adapter;

import de.aboueldahab.aoc.day02.domain.GameRound;
import de.aboueldahab.aoc.day02.domain.HandShape;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RockPaperScissorParser {
    public List<GameRound> convert(List<String> input) {
        return input.stream().map(this::convertGameRound).collect(Collectors.toList());
    }

    protected GameRound convertGameRound(String string) {
        String[] hands = string.split(" ");
        HandShape opponentHand = mapShape(hands[0]);
        HandShape myHand = mapShape(hands[1]);
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
}
