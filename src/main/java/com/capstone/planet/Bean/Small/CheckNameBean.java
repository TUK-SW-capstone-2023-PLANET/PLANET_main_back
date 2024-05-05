package com.capstone.planet.Bean.Small;

import org.springframework.stereotype.Component;

@Component
public class CheckNameBean {

    public String exec(String name) {

        return switch (name) {
            case "paper", "paper_pack" -> "paper";
            case "paper_cup" -> "paper_cup";
            case "can" -> "can";
            case "reusable_glass", "brown_glass", "green_glass", "white_glass", "etc_glass" -> "glass";
            case "pet" -> "pet";
            case "plastic" -> "plastic";
            case "vinyl" -> "vinyl";
            case "paper_dirty", "paper_cup_dirty", "can_dirty", "etc_glass_dirty", "pet_dirty_packaging", "pet_dirty", "plastic_dirty", "vinyl_dirty", "reusable_glass_packaging", "brown_glass_packaging", "green_glass_packaging", "white_glass_packaging", "pet_packaging" -> "trash";
            case "white_Styrofoam", "color_Styrofoam", "Styrofoam_dirty" -> "styrofoam";
            case "battery" -> "battery";
            default -> "";
        };
    }

    public String exec(String name, String check) {

        return switch (name) {
            case "paper" -> "종이";
            case "paper_cup" -> "종이컵";
            case "can" -> "캔";
            case "glass" -> "유리";
            case "pet" -> "페트병";
            case "plastic" -> "플라스틱";
            case "vinyl" -> "비닐";
            case "trash" -> "일반쓰레기";
            case "styrofoam" -> "스티로폼";
            case "battery" -> "건전지";
            default -> "";
        };
    }

    public String exec(String name, String check, String check1) {

        return switch (name) {
            case "종이" -> "paper";
            case "종이컵" -> "paper_cup";
            case "캔" -> "can";
            case "유리" -> "glass";
            case "페트병" -> "pet";
            case "플라스틱" -> "plastic";
            case "비닐" -> "vinyl";
            case "일반쓰레기" -> "trash";
            case "스티로폼" -> "styrofoam";
            case "건전지"-> "battery";
            default -> "";
        };
    }

}
