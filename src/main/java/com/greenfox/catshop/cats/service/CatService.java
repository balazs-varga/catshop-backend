package com.greenfox.catshop.cats.service;

import com.greenfox.catshop.cats.dao.CatRepository;
import com.greenfox.catshop.cats.error.CatNotFoundException;
import com.greenfox.catshop.cats.model.CartDTO;
import com.greenfox.catshop.cats.model.Cat;
import com.greenfox.catshop.cats.model.CatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {

    @Autowired
    CatRepository catRepository;

    public List<CatDTO> listCats() {
        List<Cat> catList = catRepository.findAll();
        List<CatDTO> catDTOList = new ArrayList<>();

        for (Cat aCatList : catList) {
            catDTOList.add(convertObjectToDTO(aCatList));
        }

        return catDTOList;
    }

    public CatDTO getCatByID(Long id) {
        Cat foundCat = catRepository.findOneById(id);

        if (foundCat == null) {
            throw new CatNotFoundException("Cat not found.");
        }

        return convertObjectToDTO(foundCat);
    }

    public CatDTO getCatByName(String name) {
        Cat foundCat = catRepository.findOneByName(name);

        if (foundCat == null) {
            throw new CatNotFoundException("Cat not found.");
        }

        return convertObjectToDTO(foundCat);
    }

    public List<CatDTO> searchCatsByName(String name) {
        List<Cat> catList = catRepository.findByNameContaining(name);
        List<CatDTO> catDTOList = new ArrayList<>();

        if (catList == null) {
            throw new CatNotFoundException("Cat not found.");
        }

        for (Cat aCatList : catList) {
            catDTOList.add(convertObjectToDTO(aCatList));
        }

        return catDTOList;
    }

    public Cat addNewCat(CatDTO catDTO) {
        Cat cat = convertDTOtoObject(catDTO);
        catRepository.save(cat);

        return cat;
    }

    public void deleteCat(Long id) {
        if (catRepository.findOneById(id) == null) {
            throw new CatNotFoundException("Cat not found.");
        }

        catRepository.deleteById(id);
    }

    public List<CatDTO> listCatsInCart(CartDTO cartDTO) {
        List<CatDTO> catList = new ArrayList<>();

        for (int i = 0; i < cartDTO.getCats().size(); i++) {
            if (catRepository.findOneById(cartDTO.getCats().get(i).getId()) == null) {
                throw new CatNotFoundException("Cat not found.");
            }

            catList.add(convertObjectToDTO(catRepository.findOneById(cartDTO.getCats().get(i).getId())));
        }

        return catList;
    }

    private CatDTO convertObjectToDTO(Cat cat){
        CatDTO catDTO = new CatDTO();
        catDTO.setId(cat.getId());
        if (cat.getGender() != null) {
            catDTO.setGender(cat.getGender());
        }
        catDTO.setName(cat.getName());
        catDTO.setPrice(cat.getPrice());
        catDTO.setPiece(cat.getPiece());
        if (cat.getFluffiness() != null) {
            catDTO.setFluffiness(cat.getFluffiness());
        }
        catDTO.setOnSale(cat.isOnSale());
        catDTO.setAmazingLevel(cat.getAmazingLevel());
        catDTO.setDescription(cat.getDescription());
        catDTO.setDaddy(cat.getDaddy());
        catDTO.setMommy(cat.getMommy());

        return catDTO;
    }

    private Cat convertDTOtoObject(CatDTO catDTO){
        Cat cat = new Cat();
        if (catDTO.getGender() != null) {
            cat.setGender(catDTO.getGender());
        }
        cat.setName(catDTO.getName());
        cat.setPrice(catDTO.getPrice());
        cat.setPiece(catDTO.getPiece());
        if (catDTO.getFluffiness() != null) {
            cat.setFluffiness(catDTO.getFluffiness());
        }
        cat.setOnSale(catDTO.isOnSale());
        cat.setAmazingLevel(catDTO.getAmazingLevel());
        cat.setDescription(catDTO.getDescription());
        cat.setDaddy(catDTO.getDaddy());
        cat.setMommy(catDTO.getMommy());

        return cat;
    }
}
