package com.thisistime.springmockito.SpringMockitoPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class ToDoServiceImpl  implements ToDoServices{

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(long id) {
        return toDoRepository.findOne(id);
    }

    @Override
    public ToDo saveToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void removeTodo(ToDo toDo) {
        toDoRepository.delete(toDo);
    }
}
