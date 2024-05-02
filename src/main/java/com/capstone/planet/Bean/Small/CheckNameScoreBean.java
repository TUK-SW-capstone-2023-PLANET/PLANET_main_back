package com.capstone.planet.Bean.Small;

import org.springframework.stereotype.Component;

@Component
public class CheckNameScoreBean {

    public Integer exec(String name) {

        return switch (name) {
            case "paper" -> 20;
            case "paper_cup" -> 15;
            case "can" -> 20;
            case "glass" -> 40;
            case "pet" -> 20;
            case "plastic" -> 20;
            case "vinyl" -> 10;
            case "trash" -> 50;
            case "styrofoam" -> 30;
            case "battery" -> 5;
            default -> 0;
        };
    }
}
