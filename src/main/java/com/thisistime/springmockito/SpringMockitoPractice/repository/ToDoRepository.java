package com.thisistime.springmockito.SpringMockitoPractice.repository;

import com.thisistime.springmockito.SpringMockitoPractice.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDo, Long>{



}
