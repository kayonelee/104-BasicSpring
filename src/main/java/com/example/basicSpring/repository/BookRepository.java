package com.example.basicSpring.repository;
import com.example.basicSpring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

//<ENTITY,PRIMARY KEY>
//THIS BOOKREPOSITORY INTERFACE IS SPECIFIC TO THE BOOK ENTITY