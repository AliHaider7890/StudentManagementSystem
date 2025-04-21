package com.example.studentManagement.Controller;

import com.example.studentManagement.Dtos.CourseDto;
import com.example.studentManagement.ServiceImplementation.Services.CourseService;
import com.example.studentManagement.ServiceImplementation.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/faculty/{facultyId}/course")
    public ResponseEntity<CourseDto> saveStudent(@RequestBody CourseDto courseDto,
                                                 @PathVariable Integer facultyId
    ){
        System.out.println("Received Faculty ID: " + facultyId);
        CourseDto courseDto1 = this.courseService.addCourse(courseDto , facultyId);
        return new ResponseEntity<CourseDto>(courseDto1 , HttpStatus.CREATED);
    }
}
