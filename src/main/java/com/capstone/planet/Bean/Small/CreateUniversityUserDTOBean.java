package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityTop3GetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreateUniversityUserDTOBean {

    // 대학교 유저 DTO 생성
    public List<Map<Integer, ResponseUserUniversityGetDTO>> exec(UserDAO user, List<UserDAO> userDAOS){

        List<Map<Integer, ResponseUserUniversityGetDTO>> responseUserUniversityGetDTOS = new ArrayList<>();
        Map<Integer, ResponseUserUniversityGetDTO> map = new HashMap<>();

        int total = 0;
        for (UserDAO userDAO : userDAOS){
            total += userDAO.getScore();
        }

        int i = 1;
        for (UserDAO userDAO : userDAOS) {
            ResponseUserUniversityGetDTO responseUserUniversityGetDTO = new ResponseUserUniversityGetDTO();
            responseUserUniversityGetDTO.setRank(i);
            responseUserUniversityGetDTO.setNickName(userDAO.getNickName());
            responseUserUniversityGetDTO.setScore(userDAO.getScore());
            responseUserUniversityGetDTO.setContribution(((double) userDAO.getScore() / total * 100));

            if (userDAO.getUserId().equals(user.getUserId())) {
                responseUserUniversityGetDTO.setImageUrl(user.getImageUrl());
                responseUserUniversityGetDTO.setUniversityLogo(user.getUniversityLogo());
                responseUserUniversityGetDTO.setUniversityName(user.getUniversityName());

                map.put(0, responseUserUniversityGetDTO);
            }
            map.put(i, responseUserUniversityGetDTO);
            i++;
        }
        responseUserUniversityGetDTOS.add(map);

        return responseUserUniversityGetDTOS;
    }

    // 대학교 유저 탑4 DTO 생성
    public List<Map<Integer, ResponseUserUniversityGetDTO>> exec(String check, UserDAO user, List<UserDAO> userDAOS){

        List<Map<Integer, ResponseUserUniversityGetDTO>> responseUserUniversityGetDTOS = new ArrayList<>();
        Map<Integer, ResponseUserUniversityGetDTO> map = new HashMap<>();

        int total = 0;
        for (UserDAO userDAO : userDAOS){
            total += userDAO.getScore();
        }

        int i = 1;
        for (UserDAO userDAO : userDAOS) {
            ResponseUserUniversityGetDTO responseUserUniversityGetDTO = new ResponseUserUniversityGetDTO();
            if (i > 4){
                if (userDAO.getUserId().equals(user.getUserId())) {
                    responseUserUniversityGetDTO.setRank(i);
                    responseUserUniversityGetDTO.setNickName(userDAO.getNickName());
                    responseUserUniversityGetDTO.setScore(userDAO.getScore());
                    responseUserUniversityGetDTO.setContribution(((double) userDAO.getScore() / total * 100));
                    responseUserUniversityGetDTO.setImageUrl(user.getImageUrl());
                    responseUserUniversityGetDTO.setUniversityLogo(user.getUniversityLogo());
                    responseUserUniversityGetDTO.setUniversityName(user.getUniversityName());

                    map.put(0, responseUserUniversityGetDTO);
                }
                i++;
                continue;
            }

            responseUserUniversityGetDTO.setRank(i);
            responseUserUniversityGetDTO.setNickName(userDAO.getNickName());
            responseUserUniversityGetDTO.setScore(userDAO.getScore());
            responseUserUniversityGetDTO.setContribution(((double) userDAO.getScore() / total * 100));

            if (userDAO.getUserId().equals(user.getUserId())) {
                responseUserUniversityGetDTO.setImageUrl(user.getImageUrl());
                responseUserUniversityGetDTO.setUniversityLogo(user.getUniversityLogo());
                responseUserUniversityGetDTO.setUniversityName(user.getUniversityName());

                map.put(0, responseUserUniversityGetDTO);
            }
            map.put(i, responseUserUniversityGetDTO);
            i++;
        }
        responseUserUniversityGetDTOS.add(map);

        return responseUserUniversityGetDTOS;
    }

    // 대학교 유저 탑 3 DTO 생성
    public List<ResponseUserUniversityTop3GetDTO> exec(List<UserDAO> userDAOS){

        List<ResponseUserUniversityTop3GetDTO> responseUserUniversityTop3GetDTOS = new ArrayList<>();

        int i = 0;
        for (UserDAO userDAO : userDAOS) {

            if (i >= 3) break;

            ResponseUserUniversityTop3GetDTO responseUserUniversityTop3GetDTO = new ResponseUserUniversityTop3GetDTO();
            responseUserUniversityTop3GetDTO.setNickName(userDAO.getNickName());
            responseUserUniversityTop3GetDTO.setScore(userDAO.getScore());
            responseUserUniversityTop3GetDTO.setUniversityLogo(userDAO.getUniversityLogo());
            responseUserUniversityTop3GetDTO.setUniversityName(userDAO.getUniversityName());

            responseUserUniversityTop3GetDTOS.add(responseUserUniversityTop3GetDTO);
            i++;
        }

        return responseUserUniversityTop3GetDTOS;
    }
}
