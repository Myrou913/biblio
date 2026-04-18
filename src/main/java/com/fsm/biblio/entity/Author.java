package com.fsm.biblio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int points = 0; // Initialize with 0

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}