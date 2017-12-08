package com.thisistime.springmockito.SpringMockitoPractice;

import javassist.bytecode.ExceptionsAttribute;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

import java.rmi.server.ExportException;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMockitoPracticeApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ToDoControllerTest {

    private MockMvc mockMvc;

    private WebApplicationContext wac;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyAllToDoList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todo").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)))
                .andDo(print());
    }

    @Test
    public void verifyToDoById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.text").exists())
                .andExpect(jsonPath("$.completed").exists())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.text").value("Build the artifacts"))
                .andExpect(jsonPath("$.completed").value(false))
                .andDo(print());
    }

    @Test
    public void verifyInvalidToDoArgument() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/f").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(400))
                .andExpect(jsonPath("$.message").value("The request could not be understood by the server due to malformed syntax"))
                .andDo(print());
    }


    @Test
    public void verifyInvalidToDoId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("ToDo doesn't exist"))
                .andDo(print());
    }

    @Test
    public void verifyDeleteToDo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/todo/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("ToDo has been deleted"))
                .andDo(print());
    }

    public void verifyInvalidToDoIdToDelete()throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/todo/9").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("ToDo to delete doesn't exist"))
                .andDo(print());
    }




}
