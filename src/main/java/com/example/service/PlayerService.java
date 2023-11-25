package com.example.service;

import com.example.dao.PlayerDao;
import com.example.dto.PlayerDto;
import com.example.util.PlayerUtil;
import com.example.vo.PlayerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerDao playerDao;
    private final PlayerUtil playerUtil;

    @Autowired
    public PlayerService(PlayerDao playerDao,PlayerUtil playerUtil) {
        this.playerDao = playerDao;
        this.playerUtil=playerUtil;
    }
    public PlayerDto infoSimpleList(){
        List<PlayerVo> voList=playerDao.getPlayerList();
        PlayerDto dto=new PlayerDto();

        List<PlayerDto.SimpleInfo> list=new ArrayList<>();
        for (PlayerVo vo:voList) {
            list.add(PlayerDto.SimpleInfo.builder()
                    .id(vo.getId())
                    .name(vo.getName())
                    .image(vo.getImage())
                    .age(playerUtil.calculateAge(vo.getBirthday()))
                    .formation(vo.getFormation())
                    .physical(playerUtil.getPhysical(vo.getHeight(), vo.getWeight()))
                    .average(playerUtil.getAverage(vo))
                    .grade(playerUtil.getGrade(vo))
                    .build());
        }
        dto.setSimpleInfoList(list);
        return dto;
    }

    public int insertPlayer(PlayerVo vo){
        return playerDao.insertPlayer(vo);
    }

}
