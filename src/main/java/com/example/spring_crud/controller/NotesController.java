package com.example.spring_crud.controller;

import com.example.spring_crud.dao.WebNoteDAO;
import com.example.spring_crud.models.WebNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NotesController {
    private final WebNoteDAO webNoteDAO;

    @Autowired
    public NotesController(WebNoteDAO webNoteDAO) {
        this.webNoteDAO = webNoteDAO;
    }

    @GetMapping()
    public String index(Model model) {
        // получаем все заметки из DAO и передаем их на веб-страницу
        model.addAttribute("notes", webNoteDAO.index());
        return "notes/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // Получаем одну заметку по id из DAO и передаём её на веб-страницу
        model.addAttribute("note", webNoteDAO.show(id));
        return "notes/show";
    }

    // открываем страницу для создания новой заметки
    @GetMapping("/new")
    public String newNote(@ModelAttribute("webNote") WebNote webNote) {
        return "notes/new";
    }

    // сохраняем новую заметку
    @PostMapping()
    public String create(@ModelAttribute("webNote") WebNote webNote) {
        webNoteDAO.save(webNote);
        return "redirect:/notes";
    }

    // открываем страницу для изменения заметки
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("webNote", webNoteDAO.show(id));
        return "notes/edit";
    }

    // обновляем данные существующей заметки
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("webNote") WebNote webNote, @PathVariable("id") int id) {
        webNoteDAO.update(id, webNote);
        return "redirect:/notes";
    }

    // Удаление заметки
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        webNoteDAO.delete(id);
        return "redirect:/notes";
    }
}
