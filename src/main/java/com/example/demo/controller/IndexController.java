package com.example.demo.controller;

import com.example.demo.exception.MyException;
import com.example.demo.model.*;
import com.example.demo.service.CityService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PersonService personService;

    @Autowired
    private CityService cityService;

    @Autowired
    private Color color;

    @ResponseBody
    @GetMapping("/color")
    public Color color(){
        return color;
    }
    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/person")
    public Person getById(@RequestParam("id") Integer id){
        return personService.getPersonById(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        if (StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassword())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到index.html；  重定向防止表单重复提交
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "密码错误");
            //回到登录页面
            return "login";
        }

    }

    @GetMapping("/index")
    public String mainPage(HttpSession session, Model model) {
        //是否登录   拦截器   过滤器

//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null) {
//            return "index";
//        }
//        else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        return "index";
    }

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        int i = 10 / 0;
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/world")
    public String world(@RequestParam("a") String message) {
        if ("123".equals(message))
            throw new MyException();
        return "";
    }
}
