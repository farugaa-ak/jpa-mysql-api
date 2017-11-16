package com.akademiakodu.thymeleaf.api;

import com.akademiakodu.thymeleaf.model.Book;
import com.akademiakodu.thymeleaf.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiBookController.class)
public class ApiBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test //shouldDoSthWhenSth
    public void  shouldGetOneJsonBooks() throws Exception {
        //given
        List<Book> bookList = Arrays.asList(
                new Book("Natasha", "title", "90")
        );
        given(bookService.getBooks()).willReturn(bookList);

        //when & then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author", Matchers.is("Natasha")));
    }


    @Test //shouldDoSthWhenSth
    public void  shouldGetJsonBooks() throws Exception {
        //given
        List<Book> bookList = Arrays.asList(
                new Book("Natasha", "title", "90"),
                new Book("John", "title2", "902")
        );
        given(bookService.getBooks()).willReturn(bookList);

        //when & then
        this.mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].author", Matchers.is("Natasha")))
                .andExpect(jsonPath("$[1].author", Matchers.is("John")));
    }

    @Test
    public void shouldCreateBook() throws Exception {
        //given
        Book book = new Book("Kim", "From", "131");

        ObjectMapper objectMapper = new ObjectMapper();
        String bookJsonString = objectMapper.writeValueAsString(book);

        //when then
        this.mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJsonString))
                .andExpect(status().isCreated());

        verify(bookService).addBook(eq(new Book("Kim", "From", "131")));
    }


}