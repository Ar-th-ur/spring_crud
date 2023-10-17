package com.example.spring_crud.controller;

import com.example.spring_crud.dao.WebNoteDAO;
import com.example.spring_crud.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NotesController {
    private final WebNoteDAO noteDAO;

    @Autowired
    public NotesController(WebNoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("notes", noteDAO.index());
        return "notes/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Note note = noteDAO.show(id);
        model.addAttribute("note", note);
        return "notes/show";
    }

    @GetMapping("/new")
    public String newNote(@ModelAttribute("note") Note note) {
        return "notes/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("note") Note note) {
        noteDAO.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("note", noteDAO.show(id));
        return "notes/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("note") Note note, @PathVariable("id") int id) {
        noteDAO.update(id, note);
        return "redirect:/notes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        noteDAO.delete(id);
        return "redirect:/notes";
    }
}
