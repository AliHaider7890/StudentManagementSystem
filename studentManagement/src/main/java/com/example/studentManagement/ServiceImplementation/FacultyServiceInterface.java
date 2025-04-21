package com.example.studentManagement.ServiceImplementation;

import com.example.studentManagement.Dtos.FacultyDto;

public interface FacultyServiceInterface {

   public FacultyDto saveCategory(FacultyDto facultyDto);

   public void deleteFaculty(Integer facultyId);

}
