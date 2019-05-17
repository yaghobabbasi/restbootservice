package com.test.service;

import com.test.model.Some;
import com.test.repository.SomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaghob_abbasi on 5/17/2019.
 */
@Service
public class SomeServiceImpl implements SomeService {
    @Autowired
    SomeRepository someRepository;

    @Override
    public Some add(Some param) {
        try {
            param.setPassword(encryptPassword(param.getPassword()));
            Some some = new Some();
            Some s = someRepository.save(param);
            if (s != null) {
                some.setId(s.getId());
                return some;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Some update(Some param) {
        try {
            param.setPassword(encryptPassword(param.getPassword()));
            Some some = new Some();
            Some s = someRepository.save(param);
            if (s != null) {
                some.setId(s.getId());
                return some;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean delete(Some param) {
        try {
            someRepository.delete(param);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Some> getAll() {
        try {
            List<Some> somes = (List<Some>) someRepository.findAll();
            somes.forEach(some -> some.setPassword(""));
            return somes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private Boolean isvalidPassword(String password, String pbkdf2CryptedPassword) {
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        return pbkdf2PasswordEncoder.matches(password, pbkdf2CryptedPassword);
    }

    private String encryptPassword(String password) {
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        return pbkdf2PasswordEncoder.encode(password);
    }
}
