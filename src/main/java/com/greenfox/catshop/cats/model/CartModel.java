package com.greenfox.catshop.cats.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartModel {
    @Id
    private Long id;
    private Long piece;

    public CartModel(Long id, Long piece) {
        this.id = id;
        this.piece = piece;
    }

    public CartModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPiece() {
        return piece;
    }

    public void setPiece(Long piece) {
        this.piece = piece;
    }
}
