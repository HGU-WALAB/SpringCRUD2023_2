package com.example.controller;

import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/player/list",method = RequestMethod.GET)
    public String playerList(Model model){
        model.addAttribute("list",playerService.infoSimpleList().getSimpleInfoList());
        return "posts";
    }
}
