package de.aboueldahab.aoc.day01.domain;

import java.util.ArrayList;
import java.util.List;

public class Elf {

    private List<Integer> food = new ArrayList<>();

    public List<Integer> getFood() {
        return food;
    }

    public void addFood(Integer foodItem) {
        food.add(foodItem);
    }

    public Integer getCalories() {
        return food.stream().reduce(Integer::sum).orElse(0);
    }
}
