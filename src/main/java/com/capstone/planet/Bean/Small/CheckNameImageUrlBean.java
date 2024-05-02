package com.capstone.planet.Bean.Small;

import org.springframework.stereotype.Component;

@Component
public class CheckNameImageUrlBean {

    // https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/trash.png

    public String exec(String name) {

        return switch (name) {
            case "paper" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/paper.png";
            case "paper_cup" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/papercup.png";
            case "can" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/can.png";
            case "glass" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/glass.png";
            case "pet" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/pet.png";
            case "plastic" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/plastic.png";
            case "vinyl" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/vinyl.png";
            case "trash" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/trash.png";
            case "styrofoam" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/styrofoam.png";
            case "battery" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/battery.png";
            default -> "";
        };
    }
}