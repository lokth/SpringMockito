package com.thisistime.springmockito.SpringMockitoPractice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private long id;
    private String text;
    private boolean completed;

    public ToDo() {
    }

    public ToDo(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public ToDo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }

    public ToDo(int i, String s, boolean b) {
        this.id= i;
        this.text = s;
        this.completed = b;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
