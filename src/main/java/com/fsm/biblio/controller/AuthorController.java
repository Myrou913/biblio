package com.fsm.biblio.controller;

import com.fsm.biblio.entity.Author;
import com.fsm.biblio.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ✅ CORRECT
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorRepo.findAll());
        model.addAttribute("author", new Author());
        return "authors";
    }

    @PostMapping
    public String addAuthor(@ModelAttribute Author author) {
        authorRepo.save(author);
        return "redirect:/authors";
    }
}