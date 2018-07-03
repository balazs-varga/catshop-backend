package com.greenfox.catshop.cats.model;

import com.greenfox.catshop.cats.util.Fluffiness;
import com.greenfox.catshop.cats.util.Gender;

import javax.persistence.*;

@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;
    private String name;
    private Long price;
    private Long piece;
    private String fluffiness;
    private boolean isOnSale;
    private int amazingLevel;
    private String description;
    private String daddy;
    private String mommy;

    public Cat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPiece() {
        return piece;
    }

    public void setPiece(Long piece) {
        this.piece = piece;
    }

    public String getFluffiness() {
        return fluffiness;
    }

    public void setFluffiness(String fluffiness) {
        this.fluffiness = fluffiness;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public int getAmazingLevel() {
        return amazingLevel;
    }

    public void setAmazingLevel(int amazingLevel) {
        this.amazingLevel = amazingLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDaddy() {
        return daddy;
    }

    public void setDaddy(String daddy) {
        this.daddy = daddy;
    }

    public String getMommy() {
        return mommy;
    }

    public void setMommy(String mommy) {
        this.mommy = mommy;
    }
}
