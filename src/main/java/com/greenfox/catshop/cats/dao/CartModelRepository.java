package com.greenfox.catshop.cats.dao;

import com.greenfox.catshop.cats.model.CartModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartModelRepository extends CrudRepository<CartModel, Long> {

}
