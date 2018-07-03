package com.greenfox.catshop.cats.dao;

import com.greenfox.catshop.cats.model.Cat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatRepository extends CrudRepository<Cat, Long> {

    Cat findOneById(Long id);

    List<Cat> findAll();
}
