package com.example.projectlibrary.book;

import com.example.projectlibrary.entity.Library;
import com.example.projectlibrary.dto.LibraryDto;
import com.example.projectlibrary.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public ResponseEntity<Library> createLibrary(@RequestBody LibraryDto library) {
        Library result = libraryService.create(library);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Library>> getAll() {
        return ResponseEntity.ok(libraryService.getAll());
    }
}
