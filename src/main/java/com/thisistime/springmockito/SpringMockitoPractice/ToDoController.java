package com.thisistime.springmockito.SpringMockitoPractice;

import com.thisistime.springmockito.SpringMockitoPractice.exception.ToDoException;
import com.thisistime.springmockito.SpringMockitoPractice.model.Response;
import com.thisistime.springmockito.SpringMockitoPractice.model.ToDo;
import com.thisistime.springmockito.SpringMockitoPractice.service.ToDoServices;
import com.thisistime.springmockito.SpringMockitoPractice.util.PayloadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private ToDoServices toDoServices;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public ResponseEntity<List<ToDo>> getAllToDo(){
        logger.info("Returning all the ToDo's");
        return new ResponseEntity<List<ToDo>>(toDoServices.getAllToDo(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable("id") long id) throws ToDoException {
        logger.info("ToDo id to return "+id);

        ToDo toDo = toDoServices.getToDoById(id);
        if(toDo == null || toDo.getId() <= 0){
            throw new ToDoException("ToDo doesn't exist");
        }

        return new ResponseEntity<ToDo>(toDo, HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Response>  removeToDoById(@PathVariable("id") long id) throws ToDoException{
        logger.info("ToDo id to remove "+id);

        ToDo toDo = toDoServices.getToDoById(id);

        if(toDo == null || toDo.getId() <= 0){
            throw new ToDoException("Todo to delete doesn't exist");
        }

        toDoServices.removeTodo(toDo);

        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "ToDo has been deleted"), HttpStatus.OK);


    }

    @PostMapping("/todo")
    public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo payload) throws ToDoException{
        logger.info("Payload to save " + payload);

        if(!PayloadValidator.validateCreatePayload(payload)){
            throw new ToDoException("Payload malformed, id must not be defined");
        }

        return new ResponseEntity<ToDo>(toDoServices.saveToDo(payload), HttpStatus.OK);

    }

    @PatchMapping("/todo")
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo payload) throws ToDoException{

        logger.info("Payload to update " + payload);

        ToDo toDo = toDoServices.getToDoById(payload.getId());

        if(toDo == null || toDo.getId() <= 0){
            throw new ToDoException("Todo to update doesn't exist");
        }

        return new ResponseEntity<ToDo>(toDoServices.saveToDo(payload), HttpStatus.OK);
    }







}
