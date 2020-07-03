package ru.gik.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class MainController {

 /*   @RequestMapping(value = "/start", method = RequestMethod.GET)//@GetMapping -- сокращенная форма без параметра get
    public String mainPage(Model uiModel) {
        uiModel.addAttribute("name", "World");
        return "index";
    }*/

    @RequestMapping(value = "/start/{name}", method = RequestMethod.GET)//получаем все что после start/ в переменную name
    public String mainPage(Model uiModel, @PathVariable(value = "name") String name) {
        uiModel.addAttribute("name",name);
        return "index";
    }
}
