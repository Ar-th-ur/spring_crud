package com.example.spring_crud.models;

public class WebNote {
    private int id;
    private String note;

    // конструктор
    public WebNote(int id, String note) {
        this.id = id;
        this.note = note;
    }

    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
