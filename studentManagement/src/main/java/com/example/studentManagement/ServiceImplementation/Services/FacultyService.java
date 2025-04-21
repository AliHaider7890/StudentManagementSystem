package com.example.studentManagement.ServiceImplementation.Services;

import com.example.studentManagement.Dtos.FacultyDto;
import com.example.studentManagement.Entity.Faculty;
import com.example.studentManagement.Repo.FacultyRepo;
import com.example.studentManagement.ServiceImplementation.FacultyServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService implements FacultyServiceInterface {

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FacultyDto saveCategory(FacultyDto facultyDto) {
        Faculty faculty = this.modelMapper.map(facultyDto , Faculty.class);
        this.facultyRepo.save(faculty);
        FacultyDto facultyDto1 = this.modelMapper.map(faculty , FacultyDto.class);
        return facultyDto1;
    }

    @Override
    public void deleteFaculty(Integer facultyId) {
        Faculty faculty = this.facultyRepo.findById(facultyId).orElseThrow();
        this.facultyRepo.delete(faculty);
    }
}
