package com.training.school.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 300, message = "Description must be between 3 and 300 characters")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Floor is required")
    @Positive(message = "Floor must be a number greater than 0")
    @Size(min = 1, message = "Floor must be a number greater than 0")
    @Column(name = "floor")
    private int floor;

    @NotBlank(message = "Quantity is required")
    @Positive(message = "Quantity must be a number greater than 0")
    @Size(min = 1, message = "Quantity must be a number greater than 0")
    @Column(name = "quantity")
    private int quantity;

    public Classroom() {
    }

    public Classroom(int id, String name, String description, int floor, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.floor = floor;
        this.quantity = quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' +
                '}';
    }
}
