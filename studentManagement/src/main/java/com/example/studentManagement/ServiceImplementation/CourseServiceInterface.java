package com.example.studentManagement.ServiceImplementation;

import com.example.studentManagement.Dtos.CourseDto;
import com.example.studentManagement.Entity.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseServiceInterface {

    CourseDto addCourse(CourseDto courseDto , Integer facultyId);

}
