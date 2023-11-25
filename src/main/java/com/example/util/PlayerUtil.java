package com.example.util;

import com.example.vo.PlayerVo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class PlayerUtil {
    public int calculateOld(LocalDate birthday){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthday, currentDate);
        return period.getYears();
    }

    public String getPhysical(int height,int weight){
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

    public int getAverage(PlayerVo vo) {
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

    public String getGrade(PlayerVo vo){
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
}
