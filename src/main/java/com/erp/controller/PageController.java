package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :
 * @date : 2019/8/23 10:13
 * @description : 视图入口
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("pages/main.html");
    }

    @RequestMapping("/{page}")
    public ModelAndView getPage(@PathVariable String page) {
        return new ModelAndView("pages/" + page);
    }

    @RequestMapping("/l")
    public ModelAndView getLogin() {
        return new ModelAndView("pages/login.html");
    }
}
