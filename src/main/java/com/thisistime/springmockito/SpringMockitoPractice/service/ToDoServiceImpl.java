package com.thisistime.springmockito.SpringMockitoPractice.service;

import com.thisistime.springmockito.SpringMockitoPractice.model.ToDo;
import com.thisistime.springmockito.SpringMockitoPractice.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("toDoService")
public class ToDoServiceImpl  implements ToDoServices {

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
