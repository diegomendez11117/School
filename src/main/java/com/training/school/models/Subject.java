package com.training.school.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Column(name = "name")
    private String name;

    @Positive(message = "Score must be a number greater or equal than 0")
    @Column(name = "score")
    private float score;

    @Positive(message = "Score must be a number greater or equal than 0")
    @Column(name = "hours")
    private float hours;

    @NotBlank(message = "Hours is required")
    @Size(min = 1, max = 300, message = "Hours must be between 1 and 300 characters")
    @Column(name = "description")
    private String description;

    public Subject() {
    }

    public Subject(int id, String name, float score, float hours, String description) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.hours = hours;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score, hours, description);
    }
}
