package com.training.school.controllers.site;

import com.training.school.models.Student;
import com.training.school.models.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("")
    public String displayManageStudent(Model model){
        List<Student> students  = studentRepository.findAll();
        model.addAttribute("title", "Students");
        model.addAttribute("student",new Student());
        model.addAttribute("students", students);
        return "/student/index";
    }

    @GetMapping("new")
    public String displayNewStudent(Model model){
        model.addAttribute("title", "Add Student");
        model.addAttribute(new Student());
        model.addAttribute("students", studentRepository.findAll());
        return "student/add";
    }

    @PostMapping("new")
    public String processAddStudent(@ModelAttribute @Valid Student student, Errors errors, Model model){
        studentRepository.save(student);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteStudent(Model model){
        model.addAttribute("title", "Delete Student");
        model.addAttribute("students", studentRepository.findAll());
        return "student/delete";
    }

    @PostMapping("delete")
    public String processDeleteStudent(@RequestParam(required = false) int[] studentIds){

        if (studentIds != null){
            for (int id : studentIds){
                studentRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
