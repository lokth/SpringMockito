package com.thisistime.springmockito.SpringMockitoPractice;

public class ToDo {

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
