package com.example.basicSpring;
import com.example.basicSpring.model.Author;
import com.example.basicSpring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthorList implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorList(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (authorRepository.count() == 0) {
            Author author1 = new Author("Eric Carle");
            Author author2 = new Author("Giles Andreae");
            Author author3 = new Author("Maurice Sendak");

            authorRepository.save(author1);
            authorRepository.save(author2);
            authorRepository.save(author3);
        }
    }
}

//AUTHORLIST.JAVA-PURPOSE OF CLASS IS TO POPULATE THE THREE AUTHOR DATA IN
// THE AUTHORREPOSITORY ONCE APPLICATION STARTS.