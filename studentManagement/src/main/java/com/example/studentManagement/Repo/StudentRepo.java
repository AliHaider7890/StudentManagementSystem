package com.example.studentManagement.Repo;

import com.example.studentManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student , Integer> {

    Optional<Student> findByEmail(String email);

    List<Student> findByStudentNameContainingIgnoreCase(String studentName);

}
