package com.greenfox.catshop.cats.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.greenfox.catshop.cats.util.Fluffiness;
import com.greenfox.catshop.cats.util.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Gender gender;
    private String name;
    private Long price;
    private Long piece;
    private Fluffiness fluffiness;
    private boolean isOnSale;
    private int amazingLevel;
    private String description;
}
