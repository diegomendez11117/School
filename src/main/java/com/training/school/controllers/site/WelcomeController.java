package com.training.school.controllers.site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String displayWelcome(){
        return "Enrique Mendez Roger";
    }


}
