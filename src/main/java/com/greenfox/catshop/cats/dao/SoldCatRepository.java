package com.greenfox.catshop.cats.dao;

import com.greenfox.catshop.cats.model.SoldCats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SoldCatRepository extends CrudRepository<SoldCats, Long> {
}
