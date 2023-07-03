package com.example.basicSpring.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

//ENTITY-JPA ENTITY MAPPED TO DATABASE TABLE
@Entity
public class Author {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<com.example.basicSpring.model.Book> books;
    //ONE TO MANY-AUTHOR CAN HAVE MULTIPLE BOOKS ASSOCIATED
    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    // GETTER SETTERS--------------------

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}