package com.alex.spring.security.controller;

import com.alex.spring.security.model.InvestUser;
import com.alex.spring.security.service.InvestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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

    @RequestMapping("/test/globalRole")
    @ResponseBody
    @Secured({"ROLE_boss"})
    public InvestUser testGlobal() {
        InvestUser investUser = investUserService.selectById(1L);
        System.out.println(investUser);
        return investUser;
    }

    @RequestMapping("/test/globalAuthority")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('admin')")
    public InvestUser testGlobalAuthority() {
        InvestUser investUser = investUserService.selectById(1L);
        System.out.println(investUser);
        return investUser;
    }

    @RequestMapping("/test/logout")
    public String testLogout() {
        InvestUser investUser = investUserService.selectById(1L);
        return "logout";
    }
}
