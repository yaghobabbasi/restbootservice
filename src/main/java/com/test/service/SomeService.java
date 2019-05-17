package com.test.service;

import com.test.model.Some;

import java.util.List;

/**
 * Created by yaghob_abbasi on 5/17/2019.
 */
public interface SomeService {
    public Some add(Some param);

    public Some update(Some param);

    public Boolean delete(Some param);

    public List<Some> getAll();


}
