package com.example.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PlayerVo {
    private int id;
    private String name;
    private int weight;
    private int height;
    private String image;
    private Date birthday;
    private String formation;
    private int pass;
    private int shoot;
    private int defense;
    private int speed;
    private int intelligence;
    private int goalkeeping;
}
