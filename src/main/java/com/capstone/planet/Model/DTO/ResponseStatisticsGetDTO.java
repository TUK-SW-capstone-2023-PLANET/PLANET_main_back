package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseStatisticsGetDTO {
    Integer average;
    List<DataList> dataList;
}
