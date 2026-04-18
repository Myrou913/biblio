package com.fsm.biblio.controller;

import com.fsm.biblio.entity.Author;
import com.fsm.biblio.entity.Book;
import com.fsm.biblio.repository.AuthorRepository;
import com.fsm.biblio.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AffectationController {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    public AffectationController(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @GetMapping({"/affectation", "/livre/affecterAuteur"})
    public String showAffectation(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("authors", authorRepo.findAll());
        model.addAttribute("allAuthors", authorRepo.findAll());
        return "affectation";
    }

    @PostMapping({"/affectation", "/livre/affecterAuteur"})
    public String processAffectation(@RequestParam Long bookId, @RequestParam Long authorId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        Author author = authorRepo.findById(authorId).orElseThrow();

        if (!book.getAuthors().contains(author)) {
            book.getAuthors().add(author);
            author.setPoints(author.getPoints() + 10);
            bookRepo.save(book);
            authorRepo.save(author);
        }

        return "redirect:/affectation";
    }
}

