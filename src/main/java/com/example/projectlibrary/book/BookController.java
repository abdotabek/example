package com.example.projectlibrary.book;

import com.example.projectlibrary.entity.Book;
import com.example.projectlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        Book result = new Book();
        result.setTitle(book.getTitle());
        result.setDescription(book.getDescription());
        bookService.save(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
        bookService.findById(id);
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") Long id, @RequestBody Book book) {
        Book result = bookService.updateById(id, book);
        result.setTitle(book.getTitle());
        result.setDescription(book.getDescription());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAll() {
        List<Book> all = bookService.findAll();
        return ResponseEntity.ok(all);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAll() {
        bookService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
