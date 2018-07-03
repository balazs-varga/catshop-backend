package com.greenfox.catshop.cats.error;

public class CartElementNotFound extends RuntimeException {

    private static final long serialVersionUID = 986177099377287773L;

    public CartElementNotFound(final String message) {
        super(message);
    }
}
