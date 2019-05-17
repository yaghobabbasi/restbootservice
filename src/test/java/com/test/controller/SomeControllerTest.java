package com.test.controller;

import com.test.model.Some;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yaghob_abbasi on 5/17/2019.
 */
public class SomeControllerTest extends AbstractControllerTest {

    @Test
    public void add() throws Exception {
        //given
        Some some = new Some();
        some.setAddress("tesran");
        some.setPassword("12345");
        some.setName("yaghob");

        //when
        when(someService.add(some));

        //then
        mockMvc.perform(post("/api/v1/somes").accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.address", is("address")))
                .andExpect(jsonPath("$.password", is("password")));

    }

    @Test
    public void update() throws Exception {
        //given
        Some some = new Some();
        some.setAddress("tesran");
        some.setPassword("12345");
        some.setName("yaghob");

        //when
        when(someService.add(some));

        //then
        mockMvc.perform(put("/api/v1/somes").accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.address", is("address")))
                .andExpect(jsonPath("$.password", is("password")));

    }

    @Test
    public void delete() throws Exception {
        //given
        Some some = new Some();
        some.setAddress("tesran");
        some.setPassword("12345");
        some.setName("yaghob");

        //when
        when(someService.add(some));

        //then
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/somes").accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.address", is("address")))
                .andExpect(jsonPath("$.password", is("password")));

    }

    @Test
    public void getAll() throws Exception {
        //given
        Some some = new Some();
        some.setAddress("tesran");
        some.setPassword("12345");
        some.setName("yaghob");

        //when
        when(someService.add(some));

        //then
        mockMvc.perform(get("/api/v1/somes").accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.address", is("address")))
                .andExpect(jsonPath("$.password", is("password")));

    }
}
