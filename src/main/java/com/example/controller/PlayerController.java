package com.example.controller;

import com.example.service.PlayerService;
import com.example.vo.PlayerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String playerList(Model model) {
        model.addAttribute("list", playerService.infoSimpleList().getSimpleInfoList());
        return "posts";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addPlayer() {
        return "add";
    }

    @RequestMapping(value = "addok", method = RequestMethod.POST)
    public String addPlayerOk(PlayerVo vo) {
        int i = playerService.insertPlayer(vo);
        if (i == 0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!");
        return "redirect:list";
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String playerView(Model model,@PathVariable("id") int id) {
        model.addAttribute("p", playerService.info(id).getInfo());
        return "view";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editPlayer(Model model,@PathVariable("id") int id) {
        model.addAttribute("p", playerService.getVo(id));
        return "edit";
    }

    @RequestMapping(value = "editok", method = RequestMethod.POST)
    public String editPlayerOk(PlayerVo vo) {
        int i = playerService.editPlayer(vo);
        if (i == 0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공!");
        return "redirect:/player/view/" + vo.getId();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable("id") int id) {
        int i = playerService.deletePlayer(id);
        if (i == 0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공!");
        return "redirect:../list";
    }
}
