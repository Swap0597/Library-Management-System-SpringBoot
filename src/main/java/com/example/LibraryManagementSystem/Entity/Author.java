package com.example.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     private String name;
     private int age;
     private String email;

     @JsonManagedReference
     @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
     List<Book> books = new ArrayList<>();

}
