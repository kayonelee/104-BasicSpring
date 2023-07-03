package com.example.basicSpring.controller;

import com.example.basicSpring.model.Author;
import com.example.basicSpring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("")
    public String showAuthorList(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author_list";
    }

    @GetMapping("/details/{id}")
    public String getAuthorById(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Author ID: " + id));
        model.addAttribute("author", author);
        return "author_detail";
    }

    @GetMapping("/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author_add";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute("author") Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Author ID: " + id));
        model.addAttribute("author", author);
        return "author_edit";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author updatedAuthor) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Author ID: " + id));


//        SAVING THE UPDATED AUTHOR OBJECT TO THE AUTHORREPOSITORY
        author.setName(updatedAuthor.getName());
        authorRepository.save(author);

        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }
}