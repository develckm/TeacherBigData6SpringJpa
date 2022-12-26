package com.bigdata6.spring_jpa.controller;

import com.bigdata6.spring_jpa.entity.User;
import com.bigdata6.spring_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list.do")
    public String list(Model model){
        List<User> userList=userService.listAllTest();
        model.addAttribute(userList);
        return "/user/list";
    }
    @GetMapping("/detail.do")
    public String detail(
            Model model,
            @RequestParam(name = "user_id") String userId){
        Optional<User> userOpt=userService.detail(userId);
        if(userOpt.isPresent()){
            model.addAttribute("user",userOpt.get());
            return "/user/detail";
        }else {
            return "redirect:/user/list.do";
        }
    }
}
