package com.alex.spring.security.controller;

import com.alex.spring.security.model.InvestUser;
import com.alex.spring.security.service.InvestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @Autowired
    private InvestUserService investUserService;


    @RequestMapping("/index")
    @ResponseBody
    public InvestUser index() {
        InvestUser investUser = investUserService.selectById(1L);

        System.out.println(investUser);
        return investUser;
    }

    @RequestMapping("/test/index")
    @ResponseBody
    public InvestUser testIndex() {
        InvestUser investUser = investUserService.selectById(1L);

        System.out.println(investUser);
        return investUser;
    }

    @RequestMapping("/test/permit")
    @ResponseBody
    public InvestUser testPermit() {
        InvestUser investUser = investUserService.selectById(1L);

        System.out.println(investUser);
        return investUser;
    }
    @RequestMapping("/test/role")
    @ResponseBody
    public InvestUser testRole() {
        InvestUser investUser = investUserService.selectById(1L);

        System.out.println(investUser);
        return investUser;
    }

    @RequestMapping("/test/anyRole")
    @ResponseBody
    public InvestUser testAnyRole() {
        InvestUser investUser = investUserService.selectById(1L);

        System.out.println(investUser);
        return investUser;
    }
}
