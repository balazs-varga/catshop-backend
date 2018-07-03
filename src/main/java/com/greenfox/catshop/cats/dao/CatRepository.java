package com.greenfox.catshop.cats.dao;

import com.greenfox.catshop.cats.model.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CatRepository extends CrudRepository<Cat, Long> {

    Cat findOneById(Long id);

    Cat findOneByName(String name);

    List<Cat> findAll();
}
