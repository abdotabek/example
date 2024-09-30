package com.example.projectlibrary.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;
}
