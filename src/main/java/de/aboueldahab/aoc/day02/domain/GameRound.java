package de.aboueldahab.aoc.day02.domain;

public class GameRound {

    private final HandShape myHand;
    private final HandShape opponentHand;

    public GameRound(HandShape myHand, HandShape opponentHand) {
        this.myHand = myHand;
        this.opponentHand = opponentHand;
    }

    public int calculatePoints() {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Result result = rockPaperScissors.determineResult(myHand, opponentHand);
        return rockPaperScissors.getPoints(myHand, result);
    }
}
