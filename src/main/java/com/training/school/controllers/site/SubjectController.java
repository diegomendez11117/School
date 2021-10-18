package com.training.school.controllers.site;


import com.training.school.models.Subject;
import com.training.school.models.data.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("")
    public String displayManageSubject(Model model){
        List<Subject> subjects  = subjectRepository.findAll();
        model.addAttribute("title", "Subjects");
        model.addAttribute("subject",new Subject());
        model.addAttribute("subjects", subjects);
        return "/subject/index";
    }

    @GetMapping("new")
    public String displayNewSubject(Model model){
        model.addAttribute("title", "Add Subject");
        model.addAttribute(new Subject());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "Subject/add";
    }

    @PostMapping("new")
    public String processAddSubject(@ModelAttribute @Valid Subject Subject, Errors errors, Model model){
        subjectRepository.save(Subject);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteSubject(Model model){
        model.addAttribute("title", "Delete Subject");
        model.addAttribute("subjects", subjectRepository.findAll());
        return "subject/delete";
    }

    @PostMapping("delete")
    public String processDeleteSubject(@RequestParam(required = false) int[] subjectIds){

        if (subjectIds != null){
            for (int id : subjectIds){
                subjectRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
