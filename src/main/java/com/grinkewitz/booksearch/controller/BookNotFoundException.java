package com.grinkewitz.booksearch.controller;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Could not find book with id = " + id);
    }
}
