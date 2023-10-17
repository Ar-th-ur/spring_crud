package com.example.spring_crud.dao;

import com.example.spring_crud.models.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebNoteDAO {
    private static int NOTES_COUNT = 0;
    private List<Note> notes;

    public WebNoteDAO() {
        notes = new ArrayList<>();
        notes.add(new Note(NOTES_COUNT++, "Заметка 1"));
    }

    public List<Note> index() {
        return notes;
    }
    public Note show(int id) {
        return notes.get(id);
    }

    public void save(Note note) {
        note.setId(NOTES_COUNT++);
        notes.add(note);
    }

    public void update(int id, Note note) {
        Note toUpdate = show(id);
        toUpdate.setNote(note.getNote());
    }

    public void delete(int id) {
        notes.removeIf(n -> n.getId() == id);
    }
}
