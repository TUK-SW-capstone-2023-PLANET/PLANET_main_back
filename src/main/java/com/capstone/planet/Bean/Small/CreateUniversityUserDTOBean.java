package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserUniversity4GetDTO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityTop3GetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreateUniversityUserDTOBean {

    // 대학교 유저 DTO 생성
    public Page<ResponseUserUniversityGetDTO> exec(int total, Page<UserDAO> userDAOS){

        List<ResponseUserUniversityGetDTO> responseUserUniversityGetDTOS = new ArrayList<>();


        int pageSize = userDAOS.getPageable().getPageSize();
        int pageNumber = userDAOS.getPageable().getPageNumber();

        int i = pageSize * pageNumber + 1;

        for (UserDAO userDAO : userDAOS) {
            ResponseUserUniversityGetDTO responseUserUniversityGetDTO = new ResponseUserUniversityGetDTO();
            responseUserUniversityGetDTO.setRank(i);
            responseUserUniversityGetDTO.setNickName(userDAO.getNickName());
            responseUserUniversityGetDTO.setScore(userDAO.getScore());
            responseUserUniversityGetDTO.setContribution(((double) userDAO.getScore() / total * 100));

            responseUserUniversityGetDTOS.add(responseUserUniversityGetDTO);

            i++;
        }

        return new PageImpl<>(responseUserUniversityGetDTOS, userDAOS.getPageable(), userDAOS.getTotalElements());
    }

    // 대학교 유저 탑4 DTO 생성
    public List<Map<Integer, ResponseUserUniversity4GetDTO>> exec(String check, UserDAO user, List<UserDAO> userDAOS){

        List<Map<Integer, ResponseUserUniversity4GetDTO>> responseUserUniversityGetDTOS = new ArrayList<>();
        Map<Integer, ResponseUserUniversity4GetDTO> map = new HashMap<>();

        int total = 0;
        for (UserDAO userDAO : userDAOS){
            total += userDAO.getScore();
        }

        int i = 1;
        for (UserDAO userDAO : userDAOS) {
            ResponseUserUniversity4GetDTO responseUserUniversity4GetDTO = new ResponseUserUniversity4GetDTO();
            if (i > 4){
                if (userDAO.getUserId().equals(user.getUserId())) {
                    responseUserUniversity4GetDTO.setRank(i);
                    responseUserUniversity4GetDTO.setNickName(userDAO.getNickName());
                    responseUserUniversity4GetDTO.setScore(userDAO.getScore());
                    responseUserUniversity4GetDTO.setContribution(((double) userDAO.getScore() / total * 100));
                    responseUserUniversity4GetDTO.setUniversityLogo(user.getUniversityLogo());
                    responseUserUniversity4GetDTO.setUniversityName(user.getUniversityName());
                    responseUserUniversity4GetDTO.setImageUrl(user.getImageUrl());

                    map.put(0, responseUserUniversity4GetDTO);
                }
                i++;
                continue;
            }

            responseUserUniversity4GetDTO.setRank(i);
            responseUserUniversity4GetDTO.setNickName(userDAO.getNickName());
            responseUserUniversity4GetDTO.setScore(userDAO.getScore());
            responseUserUniversity4GetDTO.setContribution(((double) userDAO.getScore() / total * 100));

            if (userDAO.getUserId().equals(user.getUserId())) {

                responseUserUniversity4GetDTO.setUniversityLogo(user.getUniversityLogo());
                responseUserUniversity4GetDTO.setUniversityName(user.getUniversityName());
                responseUserUniversity4GetDTO.setImageUrl(user.getImageUrl());
                map.put(0, responseUserUniversity4GetDTO);
            }
            map.put(i, responseUserUniversity4GetDTO);
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
