package com.test.service;

import com.test.model.Some;
import com.test.repository.SomeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by yaghob_abbasi on 5/17/2019.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeServiceTest {
    @Autowired
    SomeRepository someRepository;

    @Test
    public void add() {
        Some some = new Some();
        some.setName("yaghob");
        some.setPassword("123");
        some.setAddress("tehran");
        Some result = someRepository.save(some);
        assertNotNull(result.getId());
    }

    @Test
    public void update() {
        Some some = new Some();
        some.setId(1L);
        some.setName("ashkan");
        some.setPassword("123456");
        some.setAddress("tehran");
        Some result = someRepository.save(some);
        assertNotNull(result.getId());
    }

    @Test
    public void delete() {
        Some some = new Some();
        some.setId(1L);
        some.setName("yaghob");
        some.setPassword("123");
        some.setAddress("tehran");
        someRepository.delete(some);
    }

    @Test
    public void getAll() {
        List<Some> somes = (List<Some>) someRepository.findAll();
        assertNotNull(somes);
    }
}
