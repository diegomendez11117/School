package com.training.school.controllers.site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("")
public class WelcomeController {

    @GetMapping("")
    public String displayWelcome(Model model){
        String title = "Welcome Home";
        model.addAttribute("title",title);
        return "index";
    }


}
