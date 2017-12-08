package com.thisistime.springmockito.SpringMockitoPractice.service;

import com.thisistime.springmockito.SpringMockitoPractice.model.ToDo;

import java.util.List;

public interface ToDoServices {

    public List<ToDo> getAllToDo();
    public ToDo getToDoById(long id);
    public ToDo saveToDo(ToDo toDo);
    public void removeTodo(ToDo toDo);


}
