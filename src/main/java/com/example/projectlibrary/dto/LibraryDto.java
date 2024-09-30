package com.example.projectlibrary.dto;

import lombok.Data;

import java.util.List;

@Data
public class LibraryDto {
    private List<Long> bookId;
    private Long studentId;

}
