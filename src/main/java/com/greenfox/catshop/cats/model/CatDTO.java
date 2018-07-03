package com.greenfox.catshop.cats.model;


import com.greenfox.catshop.cats.util.Fluffiness;
import com.greenfox.catshop.cats.util.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CatDTO {

    private Long id;
    private Gender gender;
    @NotNull(message = "Name should be provided.")
    private String name;
    private Long price;
    private Long piece;
    private List<Cat> parents;
    private Fluffiness fluffiness;
    private boolean isOnSale;
    private int amazingLevel;
    private String description;
}
