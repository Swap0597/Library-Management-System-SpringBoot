package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.DTO.RequestDTO.AddStudentRequestDTO;
import com.example.LibraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileNoRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobileNoResponseDTO;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Exception.StudentNotExistException;
import com.example.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return studentService.addStudent(addStudentRequestDTO);
    }

    @DeleteMapping("/delete-by-id")
    public String deleteById(@RequestParam("id")Integer id){return studentService.deleteById(id); }

    @GetMapping("/get-by-id")
    public Student geById(@RequestParam("id")Integer id){
        return studentService.getById(id);
    }

    @GetMapping("/get-all")
    public List<Student> getAllStudent(){ return studentService.getAllStudent(); }

    @GetMapping("/update-mobileNo")
    public UpdateStudentMobileNoResponseDTO updateMobileNo(@RequestBody UpdateStudentMobileNoRequestDTO updateStudentMobileNoRequestDTO) throws StudentNotExistException {
        return studentService.updateMobileNo(updateStudentMobileNoRequestDTO);
    }
}
