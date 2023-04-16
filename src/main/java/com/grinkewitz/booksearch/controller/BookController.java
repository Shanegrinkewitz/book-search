package com.grinkewitz.booksearch.controller;

import com.grinkewitz.booksearch.model.Book;
import com.grinkewitz.booksearch.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String search) {
        final String searchLower = search.toLowerCase();
        List<Book> allBooks = repository.findAll();
        List<Book> results = allBooks.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(searchLower) ||
                        b.getAuthor().toLowerCase().contains(searchLower))
                .collect(Collectors.toList());
        return results;
    }
}
