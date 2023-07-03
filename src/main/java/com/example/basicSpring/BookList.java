package com.example.basicSpring;

import com.example.basicSpring.model.Book;
import com.example.basicSpring.model.Author;
import com.example.basicSpring.repository.AuthorRepository;
import com.example.basicSpring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookList implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookList(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Eric Carle");
        Author author2 = new Author("Giles Andreae");
        Author author3 = new Author("Maurice Sendak");

        Book book1 = new Book("The Very Hungry Caterpillar", author1);
        Book book2 = new Book("Giraffes Can't Dance", author2);
        Book book3 = new Book("Where the Wild Things Are", author3);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }
}
