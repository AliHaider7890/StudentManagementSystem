package com.example.studentManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Faculty_Information")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String facultyName;

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for facultyName
    public String getFacultyName() {
        return facultyName;
    }

    // Setter for facultyName
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }



    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Course> courses;
    public List<Course> getCourses() {
        return courses;
    }

    // Setter method
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @OneToMany(mappedBy = "faculty" , cascade = CascadeType.ALL)
    private List<Student> students;
    public List<Student> getStudents(){
        return students;
    }
    public void setStudent(List<Student> students){
        this.students = students;
    }
}
