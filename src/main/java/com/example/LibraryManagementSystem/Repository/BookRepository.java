package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
