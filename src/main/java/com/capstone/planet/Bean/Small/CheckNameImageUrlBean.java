package com.capstone.planet.Bean.Small;

import org.springframework.stereotype.Component;

@Component
public class CheckNameImageUrlBean {

    // https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/trash.png

    public String exec(String name) {

        return switch (name) {
            case "paper", "paper_pack" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/paper.png";
            case "paper_cup" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/papercup.png";
            case "can" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/can.png";
            case "reusable_glass", "brown_glass", "green_glass", "white_glass", "etc_glass" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/glass.png";
            case "pet" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/pet.png";
            case "plastic" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/plastic.png";
            case "vinyl" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/vinyl.png";
            case "paper_dirty", "paper_cup_dirty", "can_dirty", "etc_glass_dirty", "pet_dirty_packaging", "pet_dirty", "plastic_dirty", "vinyl_dirty", "reusable_glass_packaging", "brown_glass_packaging", "green_glass_packaging", "white_glass_packaging", "pet_packaging" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/trash.png";
            case "white_Styrofoam", "color_Styrofoam", "Styrofoam_dirty" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/styrofoam.png";
            case "battery" -> "https://tuk-planet.s3.ap-northeast-2.amazonaws.com/trashBasic/battery.png";
            default -> "";
        };
    }
}