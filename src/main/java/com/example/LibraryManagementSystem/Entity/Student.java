package com.example.LibraryManagementSystem.Entity;

import com.example.LibraryManagementSystem.Enum.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobile;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Card card;

}
