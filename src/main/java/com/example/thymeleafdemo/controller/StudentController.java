package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;
    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model)
    {
        model.addAttribute("student",new Student());
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute ("student") Student theStudent)
    {
        System.out.println("First Name: "+theStudent.getFirstName()+"\nLast Name: "+theStudent.getLastName()
        +"\nCountry: "+theStudent.getCountry()+
                "\nFavourite Programming Language: "+theStudent.getFavouriteLanguage()
        +"\nFavourite Operating System(s): "+theStudent.getFavouriteSystems());
        return "student-confirmation";
    }
}
