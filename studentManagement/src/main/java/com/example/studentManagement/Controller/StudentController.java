package com.example.studentManagement.Controller;

import com.example.studentManagement.Dtos.StudentDto;
import com.example.studentManagement.Entity.Student;
import com.example.studentManagement.ServiceImplementation.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/add/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/{facultyId}")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto , @PathVariable ("facultyId") Integer facultyId ) throws Exception {
        StudentDto studentToDb = this.studentService.addStudent(studentDto , facultyId);
        return new ResponseEntity<StudentDto>(studentToDb, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable("userId") Integer userId) {
        StudentDto editUser = this.studentService.updateUser(studentDto, userId);
       return ResponseEntity.ok(editUser);
    }

    @DeleteMapping("/{userId}")
        public ResponseEntity<String> deleteStudent(@PathVariable ("userId") Integer userId){
        this.studentService.deleteUser(userId);
        return ResponseEntity.ok().body("User deleted Successfully.");
        //Testing the GitHub Repo
        // Another One
    }

    @GetMapping("user/{userId}")
    public ResponseEntity <StudentDto> getUser(@PathVariable ("userId") Integer userId){
        StudentDto st1 = this.studentService.findById(userId);
        return ResponseEntity.ok(st1);
    }

    @PreAuthorize("hasRole('ADMIN')") // Only ADMIN can access this endpoint
    @GetMapping("/{userId}/getAll/users")
    public ResponseEntity<List<StudentDto>> getAllStudents(
            @PathVariable("userId") Integer userId,
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

        List<StudentDto> students = this.studentService.getAllStudents(userId, pageNumber, pageSize);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/search")
    public ResponseEntity<List<StudentDto>> searchStudents(@RequestParam("studentName") String studentName) {
        List<StudentDto> students = studentService.searchStudentsByName(studentName);
        return ResponseEntity.ok(students);
    }
}
