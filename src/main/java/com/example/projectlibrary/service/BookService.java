package com.example.projectlibrary.service;

import com.example.projectlibrary.entity.Book;
import com.example.projectlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        Book result = new Book();
        result.setTitle(book.getTitle());
        result.setDescription(book.getDescription());
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateById(Long id, Book book) {
        Book result = bookRepository.findById(id).orElse(null);
        result.setTitle(book.getTitle());
        result.setDescription(book.getDescription());
        return bookRepository.save(result);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
