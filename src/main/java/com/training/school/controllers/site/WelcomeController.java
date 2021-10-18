package com.training.school.controllers;

import com.training.school.models.Student;
import com.training.school.models.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class WelcomeController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("")
    public String displayWelcome(Model model){
        String title = "Welcome Home";
        List<Student> students = studentRepository.findAll();
        model.addAttribute("title",title);
        model.addAttribute("students", students);

        return "index";
    }


}
