package com.example.LibraryManagementSystem.Service.impl;

import com.example.LibraryManagementSystem.DTO.RequestDTO.AddStudentRequestDTO;
import com.example.LibraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileNoRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobileNoResponseDTO;
import com.example.LibraryManagementSystem.Entity.Card;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.Exception.StudentNotExistException;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(AddStudentRequestDTO addStudentRequestDTO) {

        Student student = new Student();
        student.setName(addStudentRequestDTO.getName());
        student.setAge(addStudentRequestDTO.getAge());
        student.setDepartment(addStudentRequestDTO.getDepartment());
        student.setMobile(addStudentRequestDTO.getMobile());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "Student added";
    }

    public String deleteById(Integer id){
        studentRepository.deleteById(id);
        return "Student deleted";
    }

    @Override
    public Student getById(Integer id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public UpdateStudentMobileNoResponseDTO updateMobileNo(UpdateStudentMobileNoRequestDTO updateStudentMobileNoRequestDTO) throws StudentNotExistException {

        try{
            Student student = studentRepository.findById(updateStudentMobileNoRequestDTO.getId()).get();
            student.setMobile(updateStudentMobileNoRequestDTO.getMobile());

            UpdateStudentMobileNoResponseDTO updateStudentMobileNoResponseDTO = new UpdateStudentMobileNoResponseDTO();
            updateStudentMobileNoResponseDTO.setName(student.getName());
            updateStudentMobileNoResponseDTO.setMobile(student.getMobile());
            studentRepository.save(student);
            return updateStudentMobileNoResponseDTO;
        }
        catch (Exception e){
            throw new StudentNotExistException("Student does not exist");
        }




    }
}
