package com.example.controller;

import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/player/list", method = RequestMethod.GET)
    public String playerList(Model model) {
        model.addAttribute("list", playerService.infoSimpleList().getSimpleInfoList());
        return "posts";
    }

    @RequestMapping(value = "/player/add", method = RequestMethod.GET)
    public String addPlayer() {
        return "add";
    }

    @RequestMapping(value = "/player/addok", method = RequestMethod.POST)
    public String addPlayerOk(HttpServletRequest request) {
        int i = playerService.insertPlayer(request);
        if (i == 0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!");
        return "redirect:list";
    }

    @RequestMapping(value = "/player/view/{id}", method = RequestMethod.GET)
    public String playerView(Model model,@PathVariable("id") int id) {
        model.addAttribute("p", playerService.info(id).getInfo());
        return "view";
    }

    @RequestMapping(value = "/player/edit/{id}", method = RequestMethod.GET)
    public String editPlayer(Model model,@PathVariable("id") int id) {
        model.addAttribute("p", playerService.getVo(id));
        return "edit";
    }

    @RequestMapping(value = "/player/editok/{id}", method = RequestMethod.POST)
    public String editPlayerOk(HttpServletRequest request,@PathVariable("id") String id){
        int i = playerService.editPlayer(request);
        if (i == 0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공!");
        return "redirect:../view/" + id;
    }

    @RequestMapping(value = "/player/delete/{id}", method = RequestMethod.GET)
    public String deletePlayer(HttpServletRequest request,@PathVariable("id") int id) {
        int i = playerService.deletePlayer(request,id);
        if (i == 0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공!");
        return "redirect:../list";
    }
}
