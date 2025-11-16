package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "confirmation";
    }

//    @RequestMapping("/processFormVersionTwo")
//    public String shout(HttpServletRequest request,Model model)
//    {
//        String name=request.getParameter("studentName");
//        name=name.toUpperCase();
//        String msg="Yo! "+name;
//        model.addAttribute("message",msg);
//        return "confirmation";
//    }
    @RequestMapping("/processFormVersionThree")
    public String shoutv3(@RequestParam("studentName") String name,Model model)
    {
        name=name.toUpperCase();
        String msg="Hey there from v3! "+name;
        model.addAttribute("message",msg);
        return "confirmation";
    }
}
