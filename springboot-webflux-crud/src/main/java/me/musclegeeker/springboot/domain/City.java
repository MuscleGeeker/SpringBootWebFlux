package me.musclegeeker.springboot.domain;

import lombok.Data;

@Data
public class City {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市描述
     */
    private String description;
}
