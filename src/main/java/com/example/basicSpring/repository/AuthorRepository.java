package com.example.basicSpring.repository;

import com.example.basicSpring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

//<ENTITY,PRIMARY KEY>
//THIS AUTHORREPOSITORY INTERFACE IS SPECIFIC TO THE AUTHOR ENTITY
