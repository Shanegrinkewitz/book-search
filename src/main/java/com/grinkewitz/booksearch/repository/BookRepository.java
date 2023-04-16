package com.grinkewitz.booksearch.repository;

import com.grinkewitz.booksearch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
