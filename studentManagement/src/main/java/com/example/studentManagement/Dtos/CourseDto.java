package com.example.studentManagement.Dtos;


import com.example.studentManagement.Entity.Faculty;
import com.example.studentManagement.Entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long id;

    private String name;

    private String description;

    private int creditHours;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }


    private FacultyDto facultyDto;

    public FacultyDto getFaculty(){
        return facultyDto;
    }

    public void setfaculty(FacultyDto facultyDto){
        this.facultyDto = facultyDto;
    }

}
