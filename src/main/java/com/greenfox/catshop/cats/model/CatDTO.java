package com.greenfox.catshop.cats.model;

import com.greenfox.catshop.cats.util.Fluffiness;
import com.greenfox.catshop.cats.util.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class CatDTO {

    private Long id;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull(message = "Name should be provided.")
    private String name;
    private Long price;
    private Long piece;
    @Enumerated(EnumType.STRING)
    private Fluffiness fluffiness;
    private boolean isOnSale;
    private int amazingLevel;
    private String description;
    private String mommy;
    private String daddy;
    private Long cartId;

    public CatDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public Fluffiness getFluffiness() {
        return fluffiness;
    }

    public void setFluffiness(Fluffiness fluffiness) {
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

    public String getMommy() {
        return mommy;
    }

    public void setMommy(String mommy) {
        this.mommy = mommy;
    }

    public String getDaddy() {
        return daddy;
    }

    public void setDaddy(String daddy) {
        this.daddy = daddy;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
