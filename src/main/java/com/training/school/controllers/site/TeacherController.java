package com.training.school.controllers.site;

import com.training.school.models.Teacher;
import com.training.school.models.data.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("")
    public String displayManageTeacher(Model model){
        List<Teacher> teachers  = teacherRepository.findAll();
        model.addAttribute("title", "Teachers");
        model.addAttribute("teacher",new Teacher());
        model.addAttribute("teachers", teachers);
        return "/teacher/index";
    }

    @GetMapping("new")
    public String displayNewTeacher(Model model){
        model.addAttribute("title", "Add Teacher");
        model.addAttribute(new Teacher());
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teacher/add";
    }

    @PostMapping("new")
    public String processAddTeacher(@ModelAttribute @Valid Teacher teacher, Errors errors, Model model){
        teacherRepository.save(teacher);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteTeacher(Model model){
        model.addAttribute("title", "Delete Teacher");
        model.addAttribute("teacher", teacherRepository.findAll());
        return "teacher/delete";
    }

    @PostMapping("delete")
    public String processDeleteTeacher(@RequestParam(required = false) int[] teacherIds){

        if (teacherIds != null){
            for (int id : teacherIds){
                teacherRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
