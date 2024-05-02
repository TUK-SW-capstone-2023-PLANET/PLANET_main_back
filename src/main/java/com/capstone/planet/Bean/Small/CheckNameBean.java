package com.capstone.planet.Bean.Small;

import org.springframework.stereotype.Component;

@Component
public class CheckNameBean {

    public String exec(String name) {

        return switch (name) {
            case "paper", "paper_pack" -> "종이";
            case "paper_cup" -> "종이컵";
            case "can" -> "캔";
            case "reusable_glass", "brown_glass", "green_glass", "white_glass", "etc_glass" -> "유리";
            case "pet" -> "페트병";
            case "plastic" -> "플라스틱";
            case "vinyl" -> "비닐";
            case "paper_dirty", "paper_cup_dirty", "can_dirty", "etc_glass_dirty", "pet_dirty_packaging", "pet_dirty", "plastic_dirty", "vinyl_dirty", "reusable_glass_packaging", "brown_glass_packaging", "green_glass_packaging", "white_glass_packaging", "pet_packaging" -> "일반쓰레기";
            case "white_Styrofoam", "color_Styrofoam", "Styrofoam_dirty" -> "스티로폼";
            case "battery" -> "건전지";
            default -> "";
        };
    }
}
