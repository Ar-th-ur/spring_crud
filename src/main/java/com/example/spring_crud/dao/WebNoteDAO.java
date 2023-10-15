package com.example.spring_crud.dao;

import com.example.spring_crud.models.WebNote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebNoteDAO {
    private static int NOTES_COUNT;
    private List<WebNote> notes;

    public WebNoteDAO() {
        // инициализируем список и добавляем тестовые значения
        notes = new ArrayList<>();

        notes.add(new WebNote(++NOTES_COUNT, "test1"));
        notes.add(new WebNote(++NOTES_COUNT, "test2"));
        notes.add(new WebNote(++NOTES_COUNT, "test3"));
        notes.add(new WebNote(++NOTES_COUNT, "test4"));
        notes.add(new WebNote(++NOTES_COUNT, "test5"));
    }

    // возвращает список заметок
    public List<WebNote> index() {
        return notes;
    }
    // возвращает заметку по id
    public WebNote show(int id) {
        return notes.get(id);
    }

    // сохраняем заметку
    public void save(WebNote webNote) {
        webNote.setId(++NOTES_COUNT);
        notes.add(webNote);
    }

    // обновляем заметку
    public void update(int id, WebNote webNote) {
        WebNote toUpdate = show(id);
        toUpdate.setNote(webNote.getNote());
    }

    // Удалить заметку
    public void delete(int id) {
        notes.removeIf(n -> n.getId() == id);
    }
}
