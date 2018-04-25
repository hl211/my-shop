package cn.binux.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "购物车");
        return "index";
    }

    @RequestMapping("/login.html")
    public String tologin(Model model) {
        model.addAttribute("msg", "购物车");
        return "login";
    }

}
