package com.greenfox.catshop.cats.service;

import com.greenfox.catshop.cats.dao.CatRepository;
import com.greenfox.catshop.cats.error.CatNotFoundException;
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

    public CatDTO getCat(Long id) {
        Cat foundCat = catRepository.findOneById(id);

        if (foundCat == null) {
            throw new CatNotFoundException("Cat not found.");
        }

        return convertObjectToDTO(foundCat);
    }

    public CatDTO convertObjectToDTO(Cat cat){
        CatDTO catDTO = new CatDTO();
        catDTO.setGender(cat.getGender());
        catDTO.setName(cat.getName());
        catDTO.setPrice(cat.getPrice());
        catDTO.setPiece(cat.getPiece());
        catDTO.setFluffiness(cat.getFluffiness());
        catDTO.setOnSale(cat.isOnSale());
        catDTO.setAmazingLevel(cat.getAmazingLevel());
        catDTO.setDescription(cat.getDescription());
        catDTO.setDaddy(cat.getDaddy());
        catDTO.setMommy(cat.getMommy());

        return catDTO;
    }
}
