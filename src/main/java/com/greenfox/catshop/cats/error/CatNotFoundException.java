package com.greenfox.catshop.cats.error;

public final class CatNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 986177099377287773L;

    public CatNotFoundException(final String message) {
        super(message);
    }
}
