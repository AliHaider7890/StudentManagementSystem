package com.example.studentManagement.ServiceImplementation.Services;

import com.example.studentManagement.Dtos.CourseDto;
import com.example.studentManagement.Entity.Course;
import com.example.studentManagement.Entity.Faculty;
import com.example.studentManagement.Entity.Student;
import com.example.studentManagement.Exception.ResourceNotFoundException;
import com.example.studentManagement.Repo.CourseRepo;
import com.example.studentManagement.Repo.FacultyRepo;
import com.example.studentManagement.Repo.StudentRepo;
import com.example.studentManagement.ServiceImplementation.CourseServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService implements CourseServiceInterface {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDto addCourse(CourseDto courseDto , Integer facultyId) {

      //  Student student =this.studentRepo.findById(userId).orElseThrow();
        Faculty faculty = this.facultyRepo.findById(facultyId).
        orElseThrow(() -> new ResourceNotFoundException("Faculty ", "Faculty id", facultyId));

        Course course = this.modelMapper.map(courseDto , Course.class);
        System.out.println("Received Faculty ID: " + facultyId);
        course.setFaculty(faculty);
        this.courseRepo.save(course);
        return this.modelMapper.map(course , CourseDto.class);
    }
}
