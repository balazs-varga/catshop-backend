package com.greenfox.catshop.cats.service;

import com.greenfox.catshop.cats.dao.CartModelRepository;
import com.greenfox.catshop.cats.dao.CatRepository;
import com.greenfox.catshop.cats.model.CartDTO;
import com.greenfox.catshop.cats.model.CartModel;
import com.greenfox.catshop.cats.model.Cat;
import com.greenfox.catshop.cats.model.CatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartModelRepository cartModelRepository;

    @Autowired
    CatRepository catRepository;

    @Autowired
    CatService catService;

   public List<CartModel> convertCartDTOToCartModel(CartDTO cartDTO){
       List<CartModel> cartModels = new ArrayList<>();
       for (int i = 0; i < cartDTO.getCats().size(); i++) {
           Long id = cartDTO.getCats().get(i).getId();
           Long piece = cartDTO.getCats().get(i).getPiece();
           cartModels.add(new CartModel(id, piece));
       }
       return cartModels;
   }

   public void transferCatsToCartTable(CartDTO cartDTO){
       List<CartModel> cartModels = convertCartDTOToCartModel(cartDTO);
       for (int i = 0; i < cartModels.size(); i++) {
           cartModelRepository.save(cartModels.get(i));
           catService.deleteCat(cartModels.get(i).getId());
       }
   }
}
