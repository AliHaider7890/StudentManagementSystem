package com.example.studentManagement.ServiceImplementation.Services;
import com.example.studentManagement.Dtos.StudentDto;
import com.example.studentManagement.Entity.Faculty;
import com.example.studentManagement.Entity.Role;
import com.example.studentManagement.Entity.Student;
import com.example.studentManagement.Repo.FacultyRepo;
import com.example.studentManagement.Repo.RoleRepo;
import com.example.studentManagement.Repo.StudentRepo;
import com.example.studentManagement.ServiceImplementation.StudentServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceInterface {


    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public StudentDto addStudent(StudentDto studentDto , Integer facultyId){
//
//        Faculty faculty = this.facultyRepo.findById(facultyId).orElseThrow();
//
//       // Role role = this.roleRepo.findByName("Ro")
//        Student savedStudent = this.modelMapper.map(studentDto , Student.class);
//        savedStudent.setFaculty(faculty);
//
//
//        //String role = studentDto.getRoles().toString();
//        String roleString = studentDto.getRoles().toString();
//        //       if(saved)
//
//
//        Set<Role> roleSet = studentDto.getRoles().stream()
//                .map(roleName -> roleRepo.findByName(roleName)
//                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
//                .collect(Collectors.toSet());
//
//        savedStudent.setRoles(roleSet);
//
//        //  savedStudent.setRoles();
//        String encodedPassword = passwordEncoder.encode(studentDto.getPassword());
//        savedStudent.setPassword(encodedPassword);
//        this.studentRepo.save(savedStudent);
//        StudentDto retStudent = this.modelMapper.map(savedStudent , StudentDto.class);
//        return retStudent;
//    }
public StudentDto addStudent(StudentDto studentDto , Integer facultyId) {

    Faculty faculty = this.facultyRepo.findById(facultyId).orElseThrow();

    Student savedStudent = this.modelMapper.map(studentDto , Student.class);
    savedStudent.setFaculty(faculty);

    Set<Role> roleSet = studentDto.getRoles().stream()
            .map(roleName -> roleRepo.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
            .collect(Collectors.toSet());

    savedStudent.setRoles(roleSet);

    String encodedPassword = passwordEncoder.encode(studentDto.getPassword());
    savedStudent.setPassword(encodedPassword);

    this.studentRepo.save(savedStudent);

    return this.modelMapper.map(savedStudent , StudentDto.class);
}


    @Override
    public StudentDto updateUser(StudentDto studentDto, Integer userId) {

        Student student = this.studentRepo.findById(userId).orElseThrow();
        student = this.modelMapper.map(studentDto , Student.class);
        this.studentRepo.save(student);
        StudentDto studentDto1 =  this.modelMapper.map(student , StudentDto.class);
        return studentDto1;
    }

    @Override
    public void deleteUser(Integer userId) {
        Student stu = this.studentRepo.findById(userId).orElseThrow();
        this.studentRepo.delete(stu);
    }

    @Override
    public StudentDto findById(Integer userId) {
        Student stu = this.studentRepo.findById(userId).orElseThrow();
        StudentDto stu1 = this.modelMapper.map(stu,StudentDto.class);
        return stu1;
    }

    @Override
    public List<StudentDto> getAllStudents(Integer userId, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Student> studentPage = this.studentRepo.findAll(pageable);
        List<Student> pagedStudents = studentPage.getContent();

        List<StudentDto> studentDtos = pagedStudents.stream()
                .map(student -> this.modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());

        return studentDtos;
    }

    public List<StudentDto> searchStudentsByName(String studentName) {
        List<Student> students = studentRepo.findByStudentNameContainingIgnoreCase(studentName);
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }
}
