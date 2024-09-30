package com.example.projectlibrary.book;

import com.example.projectlibrary.entity.Book;
import com.example.projectlibrary.entity.Student;
import com.example.projectlibrary.service.BookService;
import com.example.projectlibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student result = new Student();
        result.setId(student.getId());
        result.setName(student.getName());
        studentService.save(student);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
        studentService.findById(id);
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody Student student) {
        Student result = studentService.updateById(id, student);
        result.setName(student.getName());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> all = studentService.findAll();
        return ResponseEntity.ok(all);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAll() {
        studentService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
