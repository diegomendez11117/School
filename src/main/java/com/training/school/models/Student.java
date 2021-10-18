package com.training.school.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends AbstractEntity {

    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL)
    private List<Teacher> teachers = new ArrayList<>();

    @NotBlank(message = "Aspiration is required")
    @Size(min = 3, max = 300, message = "Aspiration must be between 3 and 300 characters")
    @Column(name = "aspiration")
    private String aspiration;

    public Student() {
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Student(String aspiration) {
        this.aspiration = aspiration;
    }

    public String getAspiration() {
        return aspiration;
    }

    public void setAspiration(String aspiration) {
        this.aspiration = aspiration;
    }
}
