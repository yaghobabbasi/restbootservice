package com.test.controller;

/**
 * Created by yaghob_abbasi on 5/17/2019.
 */

import com.test.service.SomeService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public abstract class AbstractControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected SomeService someService;

    @Before
    public void setUp(){
        Mockito.reset(someService);
    }

}
