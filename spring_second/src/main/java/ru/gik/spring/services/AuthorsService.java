package ru.gik.spring.services;

import org.springframework.stereotype.Component;
import ru.gik.spring.model.Author;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component(value = "authorsService")
public class AuthorsService {
   private List<Author> authors;

   public AuthorsService() {
       authors = new ArrayList<>();
       addAuthor("Ivan", "Pushkov");
       addAuthor("Vasilyi", "Bax");
   }

    public void addAuthor(String name, String surname) {
        authors.add(new Author(name, surname));
    }

    public List<Author> getAll() {
        return Collections.unmodifiableList(authors);
    }
}
