package com.example.LibraryManagementSystem.Service.impl;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public Integer noOfBooksWrittenByAuthor(Author author) {
        Author author1 = authorRepository.findById(author.getId()).get();
        return author1.getBooks().size();
    }

    @Override
    public List<Book> findAllTheBooks() {
        List<Author> authors = authorRepository.findAll();
        List<Book> allBooksList = new ArrayList<>();
        for(Author author : authors){
            List<Book> booksByAuthor = author.getBooks();
            for(int i=0; i<booksByAuthor.size(); i++){
                allBooksList.add(booksByAuthor.get(i));
            }
        }
        return allBooksList;
    }

    @Override
    public List<Book> findAllBooksOfAuthor(Author author) throws Exception {
        Author author1;
        try{
            author1 = authorRepository.findById(author.getId()).get();
        }
        catch(Exception e){
            throw new Exception("Author not present");
        }
        return author1.getBooks();
    }


}
