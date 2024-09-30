package com.example.projectlibrary.service;

import com.example.projectlibrary.entity.Book;
import com.example.projectlibrary.entity.Library;
import com.example.projectlibrary.dto.LibraryDto;
import com.example.projectlibrary.entity.Student;
import com.example.projectlibrary.repository.BookRepository;
import com.example.projectlibrary.repository.LibraryRepo;
import com.example.projectlibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    public Library create(LibraryDto dto) {
        Library library = new Library();
        List<Book> books = bookRepository.findAllById(dto.getBookId());
        Optional<Student> students = studentRepository.findById(dto.getStudentId());
        library.setBooks(books);
        library.setStudents(students.stream().toList());
        libraryRepo.save(library);
        return library;
    }

    public List<Library> getAll() {
        return libraryRepo.findAll();
    }
}
