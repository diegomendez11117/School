package com.training.school.controllers.site;

import com.training.school.models.Grade;
import com.training.school.models.data.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("grade")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("")
    public String displayManageGrade(Model model){
        List<Grade> grades  = gradeRepository.findAll();
        model.addAttribute("title", "Grades");
        model.addAttribute("grade",new Grade());
        model.addAttribute("grades", grades);
        return "/grade/index";
    }

    @GetMapping("new")
    public String displayNewGrade(Model model){
        model.addAttribute("title", "Add Grade");
        model.addAttribute(new Grade());
        model.addAttribute("grades", gradeRepository.findAll());
        return "grade/add";
    }

    @PostMapping("new")
    public String processAddGrade(@ModelAttribute @Valid Grade grade, Errors errors, Model model){
        gradeRepository.save(grade);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteGrade(Model model){
        model.addAttribute("title", "Delete Grade");
        model.addAttribute("grades", gradeRepository.findAll());
        return "grade/delete";
    }

    @PostMapping("delete")
    public String processDeleteGrade(@RequestParam(required = false) int[] gradeIds){

        if (gradeIds != null){
            for (int id : gradeIds){
                gradeRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
