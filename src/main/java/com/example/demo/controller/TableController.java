package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;


@Controller
public class TableController {
    @Autowired
    private UserService userService;

    @GetMapping("/table")
    public String table(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
//        List<User> list = userService.list();

//        model.addAttribute("users",list);
        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);

        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);
        return "table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        redirectAttributes.addAttribute("pn",pn);
        //这里为什么要用redirect，使用return "table";会报错？
        return "redirect:/table";

    }


}
