package com.fsm.biblio.controller;

import com.fsm.biblio.entity.Book;
import com.fsm.biblio.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepo;

    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public String showBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("book", new Book());
        return "books";
    }

    @PostMapping
    public String addBook(@RequestParam String isbn,
                          @RequestParam String titre,
                          @RequestParam int anneeParution) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitre(titre);
        book.setAnneeParution(anneeParution);
        bookRepo.save(book);
        return "redirect:/books";
    }
}

