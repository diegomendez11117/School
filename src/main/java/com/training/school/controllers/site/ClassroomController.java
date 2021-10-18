package com.training.school.controllers.site;


import com.training.school.models.Classroom;
import com.training.school.models.data.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("classroom")
public class ClassroomController {

    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("")
    public String displayManageClassroom(Model model){
        List<Classroom> classrooms  = classroomRepository.findAll();
        model.addAttribute("title", "Classrooms");
        model.addAttribute("classroom",new Classroom());
        model.addAttribute("classrooms", classrooms);
        return "/classroom/index";
    }

    @GetMapping("new")
    public String displayNewClassroom(Model model){
        model.addAttribute("title", "Add Classroom");
        model.addAttribute(new Classroom());
        model.addAttribute("classrooms", classroomRepository.findAll());
        return "classroom/add";
    }

    @PostMapping("new")
    public String processAddClassroom(@ModelAttribute @Valid Classroom classroom, Errors errors, Model model){
        classroomRepository.save(classroom);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteClassroom(Model model){
        model.addAttribute("title", "Delete Classroom");
        model.addAttribute("classrooms", classroomRepository.findAll());
        return "classroom/delete";
    }

    @PostMapping("delete")
    public String processDeleteClassroom(@RequestParam(required = false) int[] classroomIds){

        if (classroomIds != null){
            for (int id : classroomIds){
                classroomRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
