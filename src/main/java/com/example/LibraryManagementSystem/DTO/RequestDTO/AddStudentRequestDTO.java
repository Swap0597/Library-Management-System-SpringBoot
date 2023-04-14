package com.example.LibraryManagementSystem.DTO.RequestDTO;

import com.example.LibraryManagementSystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddStudentRequestDTO {
    private String name;
    private int age;
    private Department department;
    private String mobile;
}
