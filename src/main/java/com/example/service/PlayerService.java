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

    public PlayerDto info(int id) {
        PlayerVo vo=playerDao.getPlayer(id);
        PlayerDto dto=new PlayerDto();
        dto.setInfo(PlayerDto.Info.builder()
                .id(vo.getId())
                .name(vo.getName())
                .image(vo.getImage())
                .age(playerUtil.calculateAge(vo.getBirthday()))
                .formation(vo.getFormation())
                .physical(playerUtil.getPhysical(vo.getHeight(), vo.getWeight()))
                .average(playerUtil.getAverage(vo))
                .grade(playerUtil.getGrade(vo))
                .weight(vo.getWeight())
                .height(vo.getHeight())
                .birthday(vo.getBirthday().toLocalDate())
                .price(playerUtil.calculatePrice(vo))
                .pass(vo.getPass())
                .shoot(vo.getShoot())
                .defense(vo.getDefense())
                .speed(vo.getSpeed())
                .intelligence(vo.getIntelligence())
                .goalkeeping(vo.getGoalkeeping())
                .build());
        return dto;
    }

    public Object getVo(int id) {
        return playerDao.getPlayer(id);
    }

    public int editPlayer(PlayerVo vo) {
        return playerDao.updatePlayer(vo);
    }

    public int deletePlayer(int id) {
        return playerDao.deletePlayer(id);
    }
}
