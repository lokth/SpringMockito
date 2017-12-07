package com.thisistime.springmockito.SpringMockitoPractice;

import java.util.List;

public interface ToDoServices {

    public List<ToDo> getAllToDo();
    public ToDo getToDoById(long id);
    public ToDo saveToDo(ToDo toDo);
    public void removeTodo(ToDo toDo);


}
