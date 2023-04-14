package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.RequestDTO.AddStudentRequestDTO;
import com.example.LibraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileNoRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobileNoResponseDTO;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Exception.StudentNotExistException;

import java.util.List;

public interface StudentService {

    public String addStudent(AddStudentRequestDTO addStudentRequestDTO);
    public String deleteById(Integer id);

    public Student getById(Integer id);

    public List<Student> getAllStudent();

    UpdateStudentMobileNoResponseDTO updateMobileNo(UpdateStudentMobileNoRequestDTO updateStudentMobileNoRequestDTO) throws StudentNotExistException;
}
