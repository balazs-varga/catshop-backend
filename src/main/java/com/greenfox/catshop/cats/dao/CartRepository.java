package com.greenfox.catshop.cats.dao;

import com.greenfox.catshop.cats.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartRepository extends CrudRepository<Cart, Long> {

    Cart findOneById(Long id);

    List<Cart> findAll();
}
