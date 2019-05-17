package com.test.repository;

import com.test.model.Some;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yaghob_abbasi on 5/17/2019.
 */
@Repository
public interface SomeRepository extends CrudRepository<Some, Long> {
    @Query(value = "SELECT * FROM Some  WHERE Name = ?1", nativeQuery = true)
    Some findSomeByName(String name);
}
