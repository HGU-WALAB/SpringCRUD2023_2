package com.example.service;

import com.example.dao.PlayerDao;
import com.example.dto.PlayerDto;
import com.example.util.FileUpload;
import com.example.util.PlayerUtil;
import com.example.vo.PlayerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerDao playerDao;
    private final FileUpload fileUpload;

    @Autowired
    public PlayerService(PlayerDao playerDao,FileUpload fileUpload) {
        this.playerDao = playerDao;
        this.fileUpload=fileUpload;
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
                    .age(PlayerUtil.calculateAge(vo.getBirthday()))
                    .formation(vo.getFormation())
                    .physical(PlayerUtil.getPhysical(vo.getHeight(), vo.getWeight()))
                    .average(PlayerUtil.getAverage(vo))
                    .grade(PlayerUtil.getGrade(vo))
                    .build());
        }
        dto.setSimpleInfoList(list);
        return dto;
    }

    public int insertPlayer(HttpServletRequest request){
        PlayerVo vo= fileUpload.uploadPhoto(request);
        return playerDao.insertPlayer(vo);
    }

    public PlayerDto info(int id) {
        PlayerVo vo=playerDao.getPlayer(id);
        PlayerDto dto=new PlayerDto();
        dto.setInfo(PlayerDto.Info.builder()
                .id(vo.getId())
                .name(vo.getName())
                .image(vo.getImage())
                .age(PlayerUtil.calculateAge(vo.getBirthday()))
                .formation(vo.getFormation())
                .physical(PlayerUtil.getPhysical(vo.getHeight(), vo.getWeight()))
                .average(PlayerUtil.getAverage(vo))
                .grade(PlayerUtil.getGrade(vo))
                .weight(vo.getWeight())
                .height(vo.getHeight())
                .birthday(vo.getBirthday().toLocalDate())
                .price(PlayerUtil.calculatePrice(vo))
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

    public int editPlayer(HttpServletRequest request) {
        PlayerVo vo= fileUpload.uploadPhoto(request);
        return playerDao.updatePlayer(vo);
    }

    public int deletePlayer(HttpServletRequest request,int id) {
        PlayerVo vo=playerDao.getPlayer(id);
        FileUpload.deleteFile(request,vo.getImage());
        return playerDao.deletePlayer(id);
    }
}
