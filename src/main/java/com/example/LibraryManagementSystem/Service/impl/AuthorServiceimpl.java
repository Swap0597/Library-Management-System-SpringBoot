package com.example.LibraryManagementSystem.Service.impl;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceimpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author added Successfully";
    }

    @Override
    public String deleteById(Integer id) {
        authorRepository.deleteById(id);
        return "Author Deleted";
    }

    @Override
    public Author getById(Integer id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
