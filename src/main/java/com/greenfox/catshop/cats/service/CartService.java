package com.greenfox.catshop.cats.service;

import com.greenfox.catshop.cats.dao.CartRepository;
import com.greenfox.catshop.cats.dao.CatRepository;
import com.greenfox.catshop.cats.error.CartElementNotFound;
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
        List<CartModel> cartModelList = cartDTO.getCartElements();

        if (cartModelList != null) {
            for (int i = 0; i < cartModelList.size(); i++) {
                if (cartModelList.get(i).getCartId() != null && cartRepository.findOneById(cartModelList.get(i).getCartId()) == null) {
                    throw new CartElementNotFound("Cart Element not found.");
                }

                CartModel dto = cartModelList.get(i);

                if (dto.getCartId() != null) {
                    Cart cart = cartRepository.findOneById(dto.getCartId());
                    cart.setId(dto.getCartId());
                    cart.setCatId(dto.getId());

                    Cat cat = catRepository.findOneById(dto.getId());
                    cartCalculator(dto, cart, cat);

                    cartRepository.save(cart);
                    catRepository.save(cat);

                    CatDTO catDTO = catService.convertObjectToDTO(
                            catRepository.findOneById(cartModelList.get(i).getId()));
                    catDTO.setCartId(cart.getId());

                    catDTOList.add(catDTO);
                } else {
                    Cart cart = new Cart();
                    cart.setCatId(dto.getId());
                    cart.setPiece(dto.getPiece());

                    Cat cat = catRepository.findOneById(dto.getId());
                    cartCalculator(dto, cart, cat);

                    cartRepository.save(cart);
                    catRepository.save(cat);

                    CatDTO catDTO = catService.convertObjectToDTO(
                            catRepository.findOneById(cartModelList.get(i).getId()));
                    catDTO.setCartId(cart.getId());

                    catDTOList.add(catDTO);
                }
            }
        }

        return catDTOList;
    }

    private void cartCalculator(CartModel dto, Cart cart, Cat cat) {
        if (dto.getPiece() > cat.getPiece() + cart.getPiece()) {
            cart.setPiece(cat.getPiece());
            cat.setPiece(0L);
        } else if (dto.getPiece() > cart.getPiece()) {
            Long different = dto.getPiece() - cart.getPiece();
            cat.setPiece(cat.getPiece() - different);
            cart.setPiece(dto.getPiece());
        } else if (dto.getPiece() < cart.getPiece()) {
            Long different = (cart.getPiece() - dto.getPiece());
            cat.setPiece(cat.getPiece() + different);
            cart.setPiece(dto.getPiece());
        }
    }
}
