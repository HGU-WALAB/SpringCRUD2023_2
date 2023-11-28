package com.example.util;

import com.example.vo.PlayerVo;

import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;

public class PlayerUtil {
    public static int calculateAge(Date birthday){
        // Date를 LocalDate로 변환
        LocalDate localBirthDate = birthday.toLocalDate();

        // 현재 날짜
        LocalDate currentDate = LocalDate.now();

        // 나이 계산
        Period period = Period.between(localBirthDate, currentDate);

        // 나이 반환
        return period.getYears();
    }

    public static String getPhysical(int height, int weight){
        double heightInMeter = height / 100.0;
        double bmi = weight / (heightInMeter * heightInMeter);
        String result;
        if (bmi < 18.5) {
            result = "마름";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            result = "보통";
        } else if (bmi >= 25 && bmi < 29.9) {
            result = "건장";
        } else {
            result = "비대";
        }
        return result;
    }

    public static int getAverage(PlayerVo vo) {
        int average = 0;

        switch (vo.getFormation()) {
            case "GK":
                average = (vo.getPass() + vo.getIntelligence() + vo.getGoalkeeping()) / 3;
                break;
            case "DF":
                average = (vo.getPass() + vo.getDefense() + vo.getSpeed() + vo.getIntelligence()) / 4;
                break;
            case "MF":
                average = (vo.getPass() + vo.getDefense() + vo.getSpeed() + vo.getIntelligence() + vo.getShoot()) / 5;
                break;
            case "FW":
                average = (vo.getPass() + vo.getSpeed() + vo.getIntelligence() + vo.getShoot()) / 4;
                break;
        }
        return average;
    }

    public static String getGrade(PlayerVo vo){
        int average=getAverage(vo);
        String grade;
        if(average>=90){
            grade="S";
        }else if(average>=85){
            grade="A";
        }else if(average>=80){
            grade="B";
        }else{
            grade="C";
        }
        return grade;
    }

    public static int calculatePrice(PlayerVo vo){
        int average=getAverage(vo);
        int age=calculateAge(vo.getBirthday());
        double key=(double) average/age;
        double formation=0;
        switch (vo.getFormation()) {
            case "GK":
                formation = 0.6;
                break;
            case "DF":
                formation = 0.8;
                break;
            case "MF":
                formation = 0.9;
                break;
            case "FW":
                formation = 1;
                break;
        }
        return (int)((key*key*key)*formation)*30;
    }
}
