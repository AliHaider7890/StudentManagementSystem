package com.example.studentManagement.Controller;

import com.example.studentManagement.Dtos.FacultyDto;
import com.example.studentManagement.Repo.FacultyRepo;
import com.example.studentManagement.ServiceImplementation.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/addCat")
    public ResponseEntity<FacultyDto> addCategory(@RequestBody FacultyDto facultyDto){
        FacultyDto fd = this.facultyService.saveCategory(facultyDto);
        return new ResponseEntity<FacultyDto>(fd , HttpStatus.CREATED);
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<String> deleteFaculty(@PathVariable ("facultyId") Integer facultyId){
        this.facultyService.deleteFaculty(facultyId);
        return ResponseEntity.ok("Faculty has been Deleted");
    }

}
