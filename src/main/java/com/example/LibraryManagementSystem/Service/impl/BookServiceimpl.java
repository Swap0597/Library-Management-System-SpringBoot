package com.example.LibraryManagementSystem.Service.impl;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceimpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception{

        Author author;
        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch(Exception e){
            throw new Exception("Author not present");
        }
        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book added";

    }
}
