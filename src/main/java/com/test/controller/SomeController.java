package com.test.controller;

import com.test.model.Some;
import com.test.service.SomeService;
import com.test.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SomeController {

   /* @GetMapping
    public ResponseEntity save(Some some) {
        return ResponseEntity.ok(new Some());
    }*/
   @Autowired
   SomeService someService;

    //add
    @PostMapping("/somes")
    public String add(@RequestBody Some some) {
        try {
            return Utility.mapToJson(someService.add(some));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //update
    @PutMapping("/somes")
    public String update(@RequestBody Some some) {
        try {
            return Utility.mapToJson(someService.update(some));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //delete
    @DeleteMapping("/somes")
    public String delete(@RequestBody Some some) {
        try {
            return Utility.mapToJson(someService.delete(some));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //getAll
    @GetMapping("/somes")
    public String getAll() {
        try {
            return Utility.mapToJson(someService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
