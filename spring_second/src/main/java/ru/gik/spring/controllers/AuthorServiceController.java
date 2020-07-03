package ru.gik.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gik.spring.model.Author;
import ru.gik.spring.services.AuthorsService;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorServiceController {
    private AuthorsService authorsService;

   @Autowired
    public void setAuthorsService(AuthorsService authorsService) {
         this.authorsService = authorsService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAuthors(Model model) {
        List<Author> authors = authorsService.getAll();
        model.addAttribute("authors",authors);
        return "home";
    }
}
