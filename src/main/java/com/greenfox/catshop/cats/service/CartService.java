package com.greenfox.catshop.cats.service;

import com.greenfox.catshop.cats.dao.CartRepository;
import com.greenfox.catshop.cats.dao.CatRepository;
import com.greenfox.catshop.cats.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CatRepository catRepository;

    @Autowired
    CatService catService;

    public List<CatDTO> createCart(CartDTO cartDTO) {
        List<CatDTO> catDTOList = new ArrayList<>();
        List<CartModel> cartModelList = cartDTO.getElements();

        if (cartModelList != null) {
            for (int i = 0; i < cartModelList.size(); i++) {
                Cart cart = new Cart();
                cart.setCatId(cartModelList.get(i).getId());
                cart.setPiece(cartModelList.get(i).getPiece());

                Cat cat = catRepository.findOneById(cartModelList.get(i).getId());
                if (cartModelList.get(i).getPiece() >= cat.getPiece()) {
                    cart.setPiece(cat.getPiece());
                    cat.setPiece(0L);
                } else {
                    cat.setPiece(cat.getPiece() - cartModelList.get(i).getPiece());
                }

                cartRepository.save(cart);
                catRepository.save(cat);
            }

            for (int i = 0; i < cartModelList.size(); i++) {
                catDTOList.add(catService.convertObjectToDTO(
                        catRepository.findOneById(cartModelList.get(i).getId())));
            }
        } else {
            System.out.println("fasz");
        }

        return catDTOList;
    }
}
