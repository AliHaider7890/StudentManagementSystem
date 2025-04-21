package com.example.studentManagement.ServiceImplementation;

import com.example.studentManagement.Dtos.StudentDto;
import com.example.studentManagement.Entity.Student;

import java.util.List;

public interface StudentServiceInterface {

    public StudentDto addStudent(StudentDto studentdto , Integer facultyId);

    public StudentDto updateUser(StudentDto studentDto , Integer userId);

    public void deleteUser(Integer userId);

    public StudentDto findById(Integer userId);

  public   List<StudentDto> getAllStudents(Integer userId , Integer pageNumber, Integer pageSize);

    public List<StudentDto> searchStudentsByName(String studentName);

}
