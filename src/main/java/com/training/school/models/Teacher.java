package com.training.school.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Teacher extends AbstractEntity{

    @ManyToOne
    @JoinColumn (name = "student_id")
    private Student student;

    @NotBlank(message = "Department is required")
    @Size(min = 3, max = 50, message = "Department must be between 3 and 50 characters")
    @Column(name = "department")
    private String department;

    @NotBlank(message = "Evaluation is required")
    @Size(min = 1, max = 50, message = "Evaluation must be between 3 and 50 characters")
    @Column(name = "evaluation")
    private String evaluation;

    @NotBlank(message = "Salary is required")
    @Size(min = 1, max = 50, message = "Salary must be between 3 and 50 characters")
    @Column(name = "salary")
    private String salary;

    public Teacher() {
    }

    public Teacher(String department, String evaluation, String salary) {
        this.department = department;
        this.evaluation = evaluation;
        this.salary = salary;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
