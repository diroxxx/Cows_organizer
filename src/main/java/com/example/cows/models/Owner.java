package com.example.cows.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Owner extends Person {


    @NotNull
    @Size(min = 2, max = 100)
    private String address;

    @OneToMany
    @JoinColumn(name = "owner_id")
    private List<Cattle> listOfCattle = new ArrayList<Cattle>();

}
