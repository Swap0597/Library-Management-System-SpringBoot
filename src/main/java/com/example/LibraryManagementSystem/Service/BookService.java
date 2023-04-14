package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Book;

import java.util.List;

public interface BookService {
    public String addBook(Book book) throws Exception;

    Integer noOfBooksWrittenByAuthor(Author author);

    List<Book> findAllTheBooks();

    List<Book> findAllBooksOfAuthor(Author author) throws Exception;
}
