package com.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PlayerDto {

    private List<SimpleInfo> simpleInfoList;
    private Info info;
    @Getter
    @Builder
    public static class Info{
        private int id;
        private String name;
        private String image;
        private int age;
        private int weight;
        private int height;
        private LocalDate birthday;
        private String formation;
        private String physical;
        private String grade;
        private int price;
        private int pass;
        private int shoot;
        private int defense;
        private int speed;
        private int intelligence;
        private int goalkeeping;
        private int average;
    }
    @Builder
    @Getter
    public static class SimpleInfo{
        private int id;
        private String name;
        private String image;
        private int age;
        private String formation;
        private String physical;
        private int average;
        private String grade;
    }
}
