package com.fsm.biblio.repository;

import com.fsm.biblio.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
