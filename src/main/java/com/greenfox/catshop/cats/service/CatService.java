package com.greenfox.catshop.cats.service;

import com.greenfox.catshop.cats.dao.CatRepository;
import com.greenfox.catshop.cats.error.CatNotFoundException;
import com.greenfox.catshop.cats.model.CartDTO;
import com.greenfox.catshop.cats.model.Cat;
import com.greenfox.catshop.cats.model.CatDTO;
import com.greenfox.catshop.cats.util.Fluffiness;
import com.greenfox.catshop.cats.util.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public CatDTO voteForCatById(Long id, String vote) {
        Cat foundCat = catRepository.findOneById(id);

        if (foundCat == null) {
            throw new CatNotFoundException("Cat not found.");
        }

        Random rand = new Random();

        int priceChange = rand.nextInt(15) + 5;

        if (vote.equals("up")) {
            foundCat.setAmazingLevel(foundCat.getAmazingLevel() + 1);
            foundCat.setPrice(foundCat.getPrice() + priceChange);
            catRepository.save(foundCat);
        } else if (vote.equals("down") && foundCat.getAmazingLevel() >= 1) {
            if (foundCat.getPrice() >= 100) {
                foundCat.setPrice(foundCat.getPrice() - priceChange);
            }
            foundCat.setAmazingLevel(foundCat.getAmazingLevel() - 1);
            catRepository.save(foundCat);
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

        for (int i = 0; i < cartDTO.getCartElements().size(); i++) {
            if (catRepository.findOneById(cartDTO.getCartElements().get(i).getId()) == null) {
                throw new CatNotFoundException("Cat not found.");
            }

            catList.add(convertObjectToDTO(catRepository.findOneById(cartDTO.getCartElements().get(i).getId())));
        }

        return catList;
    }

    public List<CatDTO> listCatsByFluffiness(String fluffiness) {
        List<Cat> catList = catRepository.findAllByFluffiness(fluffiness);

        if (catList == null) {
            throw new CatNotFoundException("Cat not found.");
        }

        List<CatDTO> catDTOList = new ArrayList<>();

        for (int i = 0; i < catList.size(); i++) {
            catDTOList.add(convertObjectToDTO(catList.get(i)));
        }

        return catDTOList;
    }

    public CatDTO convertObjectToDTO(Cat cat) {
        CatDTO catDTO = new CatDTO();
        catDTO.setId(cat.getId());
        if (cat.getGender() != null) {
            catDTO.setGender(Gender.valueOf(cat.getGender()));
        }
        catDTO.setName(cat.getName());
        catDTO.setPrice(cat.getPrice());
        catDTO.setPiece(cat.getPiece());
        if (cat.getFluffiness() != null) {
            catDTO.setFluffiness(Fluffiness.valueOf(cat.getFluffiness()));
        }
        catDTO.setOnSale(cat.isOnSale());
        catDTO.setAmazingLevel(cat.getAmazingLevel());
        catDTO.setDescription(cat.getDescription());
        catDTO.setDaddy(cat.getDaddy());
        catDTO.setMommy(cat.getMommy());

        return catDTO;
    }

    public Cat convertDTOtoObject(CatDTO catDTO) {
        Cat cat = new Cat();
        if (catDTO.getGender() != null) {
            cat.setGender(catDTO.getGender().toString());
        }
        cat.setName(catDTO.getName());
        cat.setPrice(catDTO.getPrice());
        cat.setPiece(catDTO.getPiece());
        if (catDTO.getFluffiness() != null) {
            cat.setFluffiness(catDTO.getFluffiness().toString());
        }
        cat.setOnSale(catDTO.isOnSale());
        cat.setAmazingLevel(catDTO.getAmazingLevel());
        cat.setDescription(catDTO.getDescription());
        cat.setDaddy(catDTO.getDaddy());
        cat.setMommy(catDTO.getMommy());

        return cat;
    }
}
